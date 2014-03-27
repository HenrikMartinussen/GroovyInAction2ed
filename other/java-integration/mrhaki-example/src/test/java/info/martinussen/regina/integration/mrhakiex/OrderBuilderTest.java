package info.martinussen.regina.integration.mrhakiex;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrderBuilderTest {

	OrderBuilder testBuilder = null;
	
	@Before
	public void setUp(){
		testBuilder = new OrderBuilder();
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertFalse(testBuilder.isInitialized());
		testBuilder.setOrderNumber("4711");
		assertFalse(testBuilder.isInitialized());
		testBuilder.init();
		assertTrue(testBuilder.isInitialized());
		testBuilder.setLineNumber(1);
		testBuilder.setArticleNumber("Art001");
		testBuilder.setQuantity(42.0);
		testBuilder.addOrderLine();
		testBuilder.buildOrder();
		testBuilder.buildOrder();
		assertNotNull(testBuilder.getOrderNumber());
		assertNotNull(testBuilder.getOrderLines());
		assertEquals(1, testBuilder.getOrderLines().size());
	}

}
