package info.martinussen.regina.misc.currency
interface CurrencyConverter {
    
	double convertFromSterling(double amount, Currency toCurrency) 
	   throws InvalidAmountException
	
	double convertToSterling(double amount, Currency fromCurrency) 
	   throws InvalidAmountException
}