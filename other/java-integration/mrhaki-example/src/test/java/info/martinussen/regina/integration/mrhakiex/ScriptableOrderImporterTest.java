package info.martinussen.regina.integration.mrhakiex;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.codehaus.groovy.control.CompilationFailedException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ScriptableOrderImporterTest {

	ScriptableOrderImporter myImporter = null;
	
	@Before
	public void setUp() throws Exception {
		myImporter = new ScriptableOrderImporter();
	}

	@After
	public void tearDown() throws Exception {
		myImporter = null;
	}

	@Test
	public void testImportFile() throws CompilationFailedException, InstantiationException, IllegalAccessException, IOException, URISyntaxException {
		File orderFile = new File(this.getClass().getResource("/transferorder.csv").toURI());

		OrderBuilder builder = myImporter.importFile(orderFile); 
		assertEquals("4711", builder.getOrderNumber());
		assertEquals(2, builder.getOrderLines().size());
		
		assertEquals("1", builder.getOrderLines().get(0).get("lineNumber"));
		assertEquals("VOE449675", builder.getOrderLines().get(0).get("articleNumber"));
		assertEquals("50.0", builder.getOrderLines().get(0).get("quantity"));

		assertEquals("2", builder.getOrderLines().get(1).get("lineNumber"));
		assertEquals("VOE997581", builder.getOrderLines().get(1).get("articleNumber"));
		assertEquals("24.0", builder.getOrderLines().get(1).get("quantity"));
	}

}
