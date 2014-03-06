package info.martinussen.regina.integration.mrhakiex;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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
		System.out.println("Ordernumber:" + orderBuilder.getOrderNumber());
		List<Map<String,String>> orderlines = orderBuilder.getOrderLines();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < orderlines.size(); i++){

			builder.append("OrderLine[" + i + "][");
			builder.append("LineNumber:");
			builder.append(orderlines.get(i).get("lineNumber"));
			builder.append(", ");
			builder.append("ArticleNumber:");
			builder.append(orderlines.get(i).get("articleNumber"));
			builder.append(", ");
			builder.append("Quantity:");
			builder.append(orderlines.get(i).get("quantity"));
			builder.append("]");
			System.out.println(builder.toString());
			builder.setLength(0);
		}

	}

}