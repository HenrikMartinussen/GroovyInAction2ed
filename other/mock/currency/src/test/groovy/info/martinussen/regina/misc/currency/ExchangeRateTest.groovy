package info.martinussen.regina.misc.currency

import org.junit.Test
import org.junit.Before
import org.junit.After
import static org.junit.Assert.assertEquals

class ExchangeRateTest {

  def exchangeRate
  
  @After
  void tearDown(){
    exchangeRate = null
  }

  @Test
  void constructorIsWorking(){
    exchangeRate = new ExchangeRate(2.5, 1.0)
    assert exchangeRate.fromRate == 2.5
	assert exchangeRate.toRate == 1.0
  }
}