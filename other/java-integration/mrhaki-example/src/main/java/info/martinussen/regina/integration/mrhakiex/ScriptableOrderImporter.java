package info.martinussen.regina.integration.mrhakiex;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.codehaus.groovy.control.CompilationFailedException;

public class ScriptableOrderImporter{

	Properties prop = null;
	String scriptFileName  = null;
	
	public ScriptableOrderImporter() throws IOException{
		prop = new Properties();
		String propertyFileName = "ScriptableOrderImporter.properties";
		InputStream input = this.getClass().getClassLoader().getResourceAsStream(propertyFileName);
		if (input == null){
            System.out.println("Sorry, unable to find " + propertyFileName);
		}
		prop.load(input);
		scriptFileName = prop.getProperty("scriptFileName");
	}
	
	public OrderBuilder importFile (File file) throws CompilationFailedException, IOException, InstantiationException, IllegalAccessException{
		final GroovyClassLoader classLoader = new GroovyClassLoader();
		Class groovyClass = classLoader.parseClass(new File(scriptFileName));
		GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();
		OrderBuilder builder = (OrderBuilder) groovyObject.invokeMethod("importFile", new Object[] {new OrderBuilder(), file});
		
		return builder;
	}

	public static void main(String[] args) throws IOException, CompilationFailedException, InstantiationException, IllegalAccessException{
		ScriptableOrderImporter myImporter = new ScriptableOrderImporter();
		OrderBuilder builder = myImporter.importFile(new File("src/test/resources/transferorder.csv"));
		printOrder(builder);
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