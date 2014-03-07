package info.martinussen.regina.integration.mrhakiex;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;

import org.codehaus.groovy.control.CompilationFailedException;

public class SimpleScriptableOrderImporter{

	public static void main (String[] args) throws CompilationFailedException, IOException, InstantiationException, IllegalAccessException{
		String scriptFileName = "src/main/resources/SimpleScript.groovy";
		
		final GroovyClassLoader classLoader = new GroovyClassLoader();
		Class groovyClass = classLoader.parseClass(new File(scriptFileName));
		GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();
		
		
		String orderFileName = "src/test/resources/transferorder.csv";
		BufferedReader br = new BufferedReader(new FileReader(new File(orderFileName)));
		System.out.println(count(orderFileName));
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
	
	private static int count(String filename) {
	    InputStream is  = null; 
	    Reader r = null;
	    BufferedReader br = null;
	    int count = 0;
	    try{
	    	String s;
	    	is = new FileInputStream(filename);
	    	r = new InputStreamReader(is, "UTF-8");
	    	br = new BufferedReader(r);
	    	while ((s = br.readLine()) != null) {
	            System.out.println(s);
	            count++;
	        }
	    } catch (Exception e) {
	    	throw new RuntimeException(e);
	    } finally {
	    	if (br != null) { try { br.close(); } catch(Throwable t) { /* ensure close happens */ } }
	        if (r != null) { try { r.close(); } catch(Throwable t) { /* ensure close happens */ } }
	        if (is != null) { try { is.close(); } catch(Throwable t) { /* ensure close happens */ } }
	    }
	    return count;
	}

	
	private static void printOrderLine(Map<String, String> orderLine){
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