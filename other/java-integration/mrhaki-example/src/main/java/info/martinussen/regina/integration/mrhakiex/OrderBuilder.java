package info.martinussen.regina.integration.mrhakiex;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OrderBuilder {
	private String orderNumber = null;
	private Integer lineNumber = null;
	private Double quantity = null;
	private String articleNumber = null;
	private List<Map<String,String>> orderLines = null;
	
	private boolean initialized = false;
	private boolean built = false;

	public void setOrderNumber(String orderNumber) {
		if (initialized){
			throw new IllegalStateException("cannot change orderNumber on an initialized order");
		}
		if (built) {
			throw new IllegalStateException("cannot change orderNumber on an already built order");
		}
		this.orderNumber = orderNumber;
	}
	
	public String getOrderNumber() {
		if (!built) throw new IllegalStateException("order must be built before getting ordernumber");
		return orderNumber;
	}

	public void init(){
		if (initialized){
			throw new IllegalStateException("cannot call init on an initialized order");
		}
		if (orderNumber == null) {
			throw new IllegalStateException("Ordernumber must be set before calling init()");
		} 
		orderLines = new ArrayList<Map<String,String>>();
		initialized = true;
		System.out.println("Order " + orderNumber + " initialized");
	}
	
	public void addOrderLine(){
		if (quantity == null || articleNumber == null || lineNumber == null){
			throw new IllegalStateException("Orderline fields must be set before calling addOrderLine");
		}
		else {
			Map<String, String> orderLine = new LinkedHashMap<String, String>();
			orderLine.put("articleNumber", articleNumber);
			orderLine.put("quantity", quantity.toString());//XXX there are other ways...
			orderLine.put("lineNumber", lineNumber.toString());
			orderLines.add(orderLine);  
			System.out.println("Orderline added");
			clearOrderLineFields();
		}
	}
	
	public List<Map<String,String>> getOrderLines(){
		if (!built) throw new IllegalStateException("order must be built before getting orderLines");
		return orderLines;
	}
	
	public void buildOrder(){
		if (!initialized){
			throw new IllegalStateException("cannot build an order which has not been initialized - call init() and add one or more orderlines before building order");
		}
		if (orderLines.size() < 1){
			throw new IllegalStateException("add one or more orderlines before building order");
		}
		built = true;
		System.out.println("Order " + orderNumber + " built");
	}
	
	public void clear(){
		orderNumber = null;
		clearOrderLineFields();
		orderLines = null;
		built = false;
		initialized = false;
	}

	private void clearOrderLineFields() {
		quantity = null;
		articleNumber = null;
		lineNumber = null;
	}

	public void setLineNumber(Integer lineNumber) {
		if (lineNumber == null) throw new NullPointerException();
		if (lineNumber < 0) throw new IllegalArgumentException("lineNumber cannot be negative");
		this.lineNumber = lineNumber;
	}

	public void setQuantity(Double quantity) {
		if (quantity == null) throw new NullPointerException();
		if (quantity < 0) throw new IllegalArgumentException("quantity cannot be negative");
		this.quantity = quantity;
	}

	public void setArticleNumber(String articleNumber) {
		if (articleNumber == null) throw new NullPointerException();
		if (articleNumber.isEmpty()) throw new IllegalArgumentException("cannot use empty string as articlenumber");
		this.articleNumber = articleNumber;
	}

	public boolean isInitialized(){
		return initialized;
	}
}
