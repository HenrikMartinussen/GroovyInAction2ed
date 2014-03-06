package info.martinussen.regina.integration.mrhakiex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.codehaus.groovy.control.CompilationFailedException;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

public class SimpleScriptableOrderImporter{

	public static void main (String[] args) throws CompilationFailedException, IOException, InstantiationException, IllegalAccessException{
		final GroovyClassLoader classLoader = new GroovyClassLoader();
		Class groovyClass = classLoader.parseClass(new File("src/main/resources/SimpleScript.groovy"));
		GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();
		
		
		
		BufferedReader br = new BufferedReader(new FileReader(new File("src/test/resources/transferorder.csv")));
		String line;
		int lineCounter = 0;
		while ((line = br.readLine()) != null) {
			Map<String, String> output = (Map<String, String>) groovyObject.invokeMethod("parseLine", new Object[] {new Integer(lineCounter), line});
			lineCounter++;
			if (output.size() > 0){
				printOrderLine(output);
			}
		}
		br.close();
//		classLoader.close();
	}
	
	private static void printOrderLine(Map orderLine){
		StringBuilder builder = new StringBuilder();
		builder.append("OrderLine[");
		builder.append("OrderNumber:");
		builder.append(orderLine.get("orderNumber"));
		builder.append(", ");
		builder.append("LineNumber:");
		builder.append(orderLine.get("lineNumber"));
		builder.append(", ");
		builder.append("ArticleNumber:");
		builder.append(orderLine.get("articleNumber"));
		builder.append(", ");
		builder.append("Quantity:");
		builder.append(orderLine.get("quantity"));
		builder.append("]");
		System.out.println(builder.toString());
		
	}

}