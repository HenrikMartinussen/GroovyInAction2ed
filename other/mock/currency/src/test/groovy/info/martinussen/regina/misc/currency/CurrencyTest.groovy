package info.martinussen.regina.misc.currency

import org.junit.Test
import org.junit.Before
import org.junit.After
import static org.junit.Assert.assertEquals

class CurrencyTest {

  def currency
  
  @After
  void tearDown(){
    currency = null
  }

  @Test
  void toStringIsWorking(){
//    assert Currency.EUR.toString() == 'EUR'
    def currency = Currency.USD
    assert currency.toString() == 'USD'
  }
}