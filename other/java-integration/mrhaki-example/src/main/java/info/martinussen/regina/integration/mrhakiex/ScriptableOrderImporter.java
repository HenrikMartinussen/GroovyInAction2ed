package info.martinussen.regina.integration.mrhakiex;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.io.File;
import java.io.IOException;

import org.codehaus.groovy.control.CompilationFailedException;

public class ScriptableOrderImporter{

	public static void main (String[] args) throws CompilationFailedException, IOException, InstantiationException, IllegalAccessException{
		final GroovyClassLoader classLoader = new GroovyClassLoader();
		Class groovyClass = classLoader.parseClass(new File("src/main/resources/ImportScript.groovy"));
		GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();
		
		
		
		File orderFile = new File("src/test/resources/transferorder.csv");
		OrderBuilder builder = (OrderBuilder) groovyObject.invokeMethod("importFile", new Object[] {new OrderBuilder(), orderFile});
		printOrder(builder);
//		classLoader.close();
	}
	
	private static void printOrder(OrderBuilder orderBuilder){
		StringBuilder builder = new StringBuilder();
		builder.append("OrderLine[");
		builder.append("OrderNumber:");
		builder.append(orderBuilder.getOrderNumber());
		builder.append(", ");
		builder.append("LineNumber:");
		builder.append(orderBuilder.getOrderLines().get(0).get("lineNumber"));
		builder.append(", ");
		builder.append("ArticleNumber:");
		builder.append(orderBuilder.getOrderLines().get(0).get("articleNumber"));
		builder.append(", ");
		builder.append("Quantity:");
		builder.append(orderBuilder.getOrderLines().get(0).get("quantity"));
		builder.append("]");
		System.out.println(builder.toString());
		
	}

}