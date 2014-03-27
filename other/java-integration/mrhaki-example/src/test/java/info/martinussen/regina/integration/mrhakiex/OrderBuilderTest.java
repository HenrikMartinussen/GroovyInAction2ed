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
		testBuilder = null;
	}

	@Test 
	public void testConstructionAndInitialState() {
		assertNotNull(testBuilder);
		assertFalse(testBuilder.isInitialized());
		assertFalse(testBuilder.isReady());
	}

	@Test (expected = IllegalStateException.class)
	public void testCannotInitializeBeforeSettingOrderNumber() {
		assertNotNull(testBuilder);
		assertFalse(testBuilder.isInitialized());
		assertFalse(testBuilder.isReady());
		testBuilder.init();
	}

	@Test (expected = IllegalStateException.class)
	public void testCannotBuildOrderWOOrderlines() {
		assertFalse(testBuilder.isInitialized());
		testBuilder.setOrderNumber("4711");
		assertFalse(testBuilder.isInitialized());
		testBuilder.init();
		assertTrue(testBuilder.isInitialized());
		testBuilder.buildOrder();
	}

	@Test (expected = IllegalStateException.class)
	public void testOrderCannotAddIncompleteOrderline() {
		assertFalse(testBuilder.isInitialized());
		assertFalse(testBuilder.isReady());
		testBuilder.setOrderNumber("4711");
		assertFalse(testBuilder.isInitialized());
		assertFalse(testBuilder.isReady());
		testBuilder.init();
		assertTrue(testBuilder.isInitialized());
		assertFalse(testBuilder.isReady());
		testBuilder.setArticleNumber("Art001");
		testBuilder.addOrderLine();
	}

	@Test 
	public void testOrderWOneOrderline() {
		assertFalse(testBuilder.isInitialized());
		assertFalse(testBuilder.isReady());
		testBuilder.setOrderNumber("4711");
		assertFalse(testBuilder.isInitialized());
		assertFalse(testBuilder.isReady());
		testBuilder.init();
		assertTrue(testBuilder.isInitialized());
		assertFalse(testBuilder.isReady());
		testBuilder.setLineNumber(1);
		testBuilder.setArticleNumber("Art001");
		testBuilder.setQuantity(42.0);
		testBuilder.addOrderLine();
		assertFalse(testBuilder.isReady());
		testBuilder.buildOrder();
		assertTrue(testBuilder.isReady());
		assertEquals("4711", testBuilder.getOrderNumber());
		assertEquals(1, testBuilder.getOrderLines().size());
		assertEquals("42.0", testBuilder.getOrderLines().get(0).get("quantity"));
		assertEquals("Art001", testBuilder.getOrderLines().get(0).get("articleNumber"));
	}
	
	@Test 
	public void testOrderWTwoOrderlines() {
		assertFalse(testBuilder.isInitialized());
		assertFalse(testBuilder.isReady());
		testBuilder.setOrderNumber("4711");
		assertFalse(testBuilder.isInitialized());
		assertFalse(testBuilder.isReady());
		testBuilder.init();
		assertTrue(testBuilder.isInitialized());
		assertFalse(testBuilder.isReady());
		testBuilder.setLineNumber(1);
		testBuilder.setArticleNumber("Art001");
		testBuilder.setQuantity(42.0);
		testBuilder.addOrderLine();
		testBuilder.setLineNumber(2);
		testBuilder.setArticleNumber("Art002");
		testBuilder.setQuantity(43.0);
		testBuilder.addOrderLine();
		assertFalse(testBuilder.isReady());
		testBuilder.buildOrder();
		assertTrue(testBuilder.isReady());
		assertEquals("4711", testBuilder.getOrderNumber());
		assertEquals(2, testBuilder.getOrderLines().size());
		assertEquals("42.0", testBuilder.getOrderLines().get(0).get("quantity"));
		assertEquals("Art001", testBuilder.getOrderLines().get(0).get("articleNumber"));
		assertEquals("43.0", testBuilder.getOrderLines().get(1).get("quantity"));
		assertEquals("Art002", testBuilder.getOrderLines().get(1).get("articleNumber"));
	}
	
	@Test (expected = IllegalStateException.class) 
	public void testCannotAddOrderlineTwice() {
		assertFalse(testBuilder.isInitialized());
		assertFalse(testBuilder.isReady());
		testBuilder.setOrderNumber("4711");
		assertFalse(testBuilder.isInitialized());
		assertFalse(testBuilder.isReady());
		testBuilder.init();
		assertTrue(testBuilder.isInitialized());
		assertFalse(testBuilder.isReady());
		testBuilder.setLineNumber(1);
		testBuilder.setArticleNumber("Art001");
		testBuilder.setQuantity(42.0);
		testBuilder.addOrderLine();
		testBuilder.addOrderLine();
	}

	@Test (expected = IllegalStateException.class)
	public void testCannotBuildOrderTwice() {
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
	}

}
