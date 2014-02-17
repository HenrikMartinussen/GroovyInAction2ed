package info.martinussen.regina.misc.currency;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import groovy.mock.interceptor.*

class SterlingCurrencyConverterTest {
	
	CurrencyConverter testConverter

	@After
	public void tearDown() throws Exception {
		testConverter = null
	}

	@Test
	public void testConvertFromSterling() {
		//Mocking using Map coercion - http://groovy.codehaus.org/Groovy+Mocks
		def service = [retrieveRate:{new ExchangeRate(1.671, 0.598)}] as ExchangeRateService
		testConverter = new SterlingCurrencyConverter(service)
		double convertedAmount = testConverter.convertFromSterling(10.0, Currency.USD)
		assertEquals(16.71, convertedAmount, 0.001)
	}
	
	@Test
	public void testConvertFromSterling2(){
		//Mocking using Closure coercion - http://groovy.codehaus.org/Groovy+Mocks
		def service = {new ExchangeRate(1.671, 0.598)} as ExchangeRateService
		testConverter = new SterlingCurrencyConverter(service)
		double convertedAmount = testConverter.convertFromSterling(20, Currency.USD)
		assertEquals(33.42, convertedAmount, 0.001)
	}
	
	class DummyExchangeRateService implements ExchangeRateService {
		ExchangeRate retrieveRate(Currency currency){}
	}
	@Test
	public void testConvertFromSterling3(){
		//Mocking using MockFor - http://groovy.codehaus.org/Groovy+Mocks
		def mockContextClass = new MockFor(DummyExchangeRateService)
		mockContextClass.demand.retrieveRate { new ExchangeRate(1.671, 0.598) }
		mockContextClass.use {
			def dummyService = new DummyExchangeRateService()
			testConverter = new SterlingCurrencyConverter(dummyService)
			double convertedAmount = testConverter.convertFromSterling(30.0, Currency.USD)
			assertEquals(50.13, convertedAmount, 0.001)
		}
	}
	
	@Test
	public void testConvertFromSterling4(){
		//Instance-style MockFor - http://groovy.codehaus.org/Groovy+Mocks
		def mockContext = new MockFor(ExchangeRateService)
		mockContext.demand.retrieveRate {new ExchangeRate(1.671, 0.598)}
		def mockService = mockContext.proxyInstance()
		testConverter = new SterlingCurrencyConverter(mockService)
		double convertedAmount = testConverter.convertFromSterling(40, Currency.USD)
		assertEquals(66.84, convertedAmount, 0.001)
	}

	@Test
	public void testConvertToSterling() {
		//Mocking using Map coercion - http://groovy.codehaus.org/Groovy+Mocks
		def service = [retrieveRate:{new ExchangeRate(1.671, 0.598)}] as ExchangeRateService
		testConverter = new SterlingCurrencyConverter(service)
		double convertedAmount = testConverter.convertToSterling(10.0, Currency.USD)
		assertEquals(5.98, convertedAmount, 0.001)
	}

}
