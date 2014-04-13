package info.martinussen.regina.integration.orderimporter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class OrderBuilderImpl implements OrderBuilder {

	/* State pattern implementation  */
	private String orderNumber = null;
	private Integer lineNumber = null;
	private Double quantity = null;
	private String articleNumber = null;
	private List<Map<String,String>> orderLines = null;
	
	private State notInitializedState = new NotInitializedState();
	private State initializedState = new InitializedState();
	private State buildableState = new BuildableState();
	private State builtState = new BuiltState();
	private State currentState = notInitializedState;
	

	private static Logger log = Logger.getLogger(OrderBuilder.class);
	
	public void setOrderNumber(String orderNumber) {
		currentState.setOrderNumber(orderNumber);
	}
	
	public String getOrderNumber() {
		return currentState.getOrderNumber();
	}

	public void init(){
		currentState.init();
	}
	
	public void addOrderLine(){
		currentState.addOrderLine();
	}
	
	public List<Map<String,String>> getOrderLines(){
		return currentState.getOrderLines();
	}
	
	public void buildOrder(){
		currentState.buildOrder();
	}
	
	public void clear(){
		currentState.clear();
	}

	private void clearOrderLineFields() {
		quantity = null;
		articleNumber = null;
		lineNumber = null;
	}

	public void setLineNumber(Integer lineNumber) {
		currentState.setLineNumber(lineNumber);
	}

	public void setQuantity(Double quantity) {
		currentState.setQuantity(quantity);
	}

	public void setArticleNumber(String articleNumber) {
		currentState.setArticleNumber(articleNumber);
	}

	public boolean isInitialized(){
		return currentState.isInitialized();
	}

	public boolean isReady() {
		return currentState.isReady();
	}
	
	abstract class State {
		public void clear() {
			orderNumber = null;
			clearOrderLineFields();
			orderLines = null;
			currentState = notInitializedState;
		}
		
		abstract void setOrderNumber(String orderNumber);
		abstract void init();
		abstract boolean isInitialized();
		abstract void setLineNumber(Integer i);
		abstract void setArticleNumber(String string);
		abstract void setQuantity(Double d);
		abstract void addOrderLine();
		abstract void buildOrder();
		abstract String getOrderNumber();
		abstract List<Map<String, String>> getOrderLines();
		abstract boolean isReady();
	}
	
	class NotInitializedState extends State {
		
		public String getOrderNumber(){
			throw new IllegalStateException("order must be built before getting ordernumber");
		}
		
		
		public void setOrderNumber(String orderNumber){
			if (orderNumber == null){
				throw new NullPointerException("OrderNumber cannot be set to null");
			}
			if (orderNumber.isEmpty()){
				throw new IllegalArgumentException("OrderNumber cannot be set to empty");
			}
			OrderBuilderImpl.this.orderNumber = orderNumber;
			log.trace("OrderBuilder.setOrderNumber(" + orderNumber + ")");
		}
		
		public void init() {
			if (orderNumber == null || orderNumber.isEmpty()){
				throw new IllegalStateException("Ordernumber must be set before calling init()");
			}
			orderLines = new ArrayList<Map<String, String>>();
			log.debug("OrderBuilder: Order " + orderNumber + " initialized");
			currentState  = initializedState;
		}
		
		public boolean isInitialized() {
			return false;
		}

		public void buildOrder() {
			throw new IllegalStateException("cannot build an order which has not been initialized - call init() and add one or more orderlines before building order");
		}

		public boolean isReady() {
			return false;
		}


		public void setLineNumber(Integer i) {
			throw new IllegalStateException("cannot set lineNumber on an order which has not been initialized - call init() before adding one or more orderlines");
		}

		public void setArticleNumber(String string) {
			throw new IllegalStateException("cannot set articleNumber on an order which has not been initialized - call init() before adding one or more orderlines");
		}

		public void setQuantity(Double d) {
			throw new IllegalStateException("cannot set quantity on an order which has not been initialized - call init() before adding one or more orderlines");
		}

		public void addOrderLine() {
			throw new IllegalStateException("Cannot add OrderLine to an order which has not been initialized - set OrderNumber and call init()");
		}

		public List<Map<String, String>> getOrderLines() {
			throw new IllegalStateException("order must be built before getting orderLines");
		}
		
	}

	class InitializedState extends State {
		
		public void init() {
			throw new IllegalStateException("cannot call init on an initialized order");
		}

		public void setOrderNumber(String orderNumber){
			throw new IllegalStateException("cannot change orderNumber on an initialized order");
		}
		
		public boolean isInitialized() {
			return true;
		}

		public void buildOrder() {
			throw new IllegalStateException("add one or more orderlines before building order");
		}
		
		public String getOrderNumber(){
			throw new IllegalStateException("order must be built before getting ordernumber");
		}

		public boolean isReady() {
			return false;
		}

		@Override
		public void setLineNumber(Integer lineNumber) {
			if (lineNumber == null) throw new NullPointerException();
			if (lineNumber < 0) throw new IllegalArgumentException("lineNumber cannot be negative");
			OrderBuilderImpl.this.lineNumber = lineNumber;
		}

		@Override
		public void setArticleNumber(String articleNumber) {
			if (articleNumber == null) throw new NullPointerException();
			if (articleNumber.isEmpty()) throw new IllegalArgumentException("cannot use empty string as articlenumber");
			OrderBuilderImpl.this.articleNumber = articleNumber;
		}

		@Override
		public void setQuantity(Double quantity) {
			if (quantity == null) throw new NullPointerException();
			if (quantity < 0) throw new IllegalArgumentException("quantity cannot be negative");
			OrderBuilderImpl.this.quantity = quantity;
		}

		
		@Override
		public void addOrderLine() {
			if (quantity == null || articleNumber == null || lineNumber == null){
				throw new IllegalStateException("Orderline fields must be set before calling addOrderLine");
			}
			else {
				Map<String, String> orderLine = new LinkedHashMap<String, String>();
				orderLine.put("articleNumber", articleNumber);
				orderLine.put("quantity", quantity.toString());//XXX there are other ways...
				orderLine.put("lineNumber", lineNumber.toString());
				orderLines.add(orderLine);  
				log.debug("Orderline added");
				clearOrderLineFields();
				currentState = buildableState;
			}
		}

		@Override
		public List<Map<String, String>> getOrderLines() {
			throw new IllegalStateException("order must be built before getting orderLines");
		}
	}

	public class BuildableState extends InitializedState{
		public void buildOrder() {
			currentState = builtState;
			log.info("Order " + orderNumber + " built");
		}

	}
	
	
	public class BuiltState extends InitializedState {
		
		
		public void setOrderNumber(String orderNumber){
			throw new IllegalStateException("cannot change orderNumber on an already built order");
		}
		
		
		@Override
		public void buildOrder() {
			throw new IllegalStateException("cannot build an order which has already been built");
		}
		
		@Override
		public boolean isReady() {
			return true;
		}

		@Override
		public String getOrderNumber() {
			return orderNumber;
		}
		
		public List<Map<String,String>> getOrderLines(){
			return orderLines;
		}

		@Override
		public void setLineNumber(Integer i) {
			throw new IllegalStateException("cannot add set LineNumber on an order which has already been built");
		}

		@Override
		public void setArticleNumber(String string) {
			throw new IllegalStateException("cannot set articleNumber on an order which has already been built");
		}

		@Override
		public void setQuantity(Double d) {
			throw new IllegalStateException("cannot set Quantity on an order which has already been built");
		}

		@Override
		public void addOrderLine() {
			throw new IllegalStateException("cannot add OrderLine to an order which has already been built");
		}
		
	}
}
