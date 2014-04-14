package info.martinussen.regina.integration.orderimporter;

import java.util.List;
import java.util.Map;

public interface OrderBuilder {

	void setOrderNumber(String string);
	void init();
	boolean isInitialized();
	void setLineNumber(Integer i);
	void setArticleNumber(String string);
	void setQuantity(Double d);
	void addOrderLine();
	void buildOrder();
	boolean isReady();
	String getOrderNumber();
	List<Map<String, String>> getOrderLines();
	void clear();
}
