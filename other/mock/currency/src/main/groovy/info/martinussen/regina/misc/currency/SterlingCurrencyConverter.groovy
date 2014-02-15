package info.martinussen.regina.misc.currency

class SterlingCurrencyConverter implements CurrencyConverter{

	ExchangeRateService exchangeRateService
	
	public SterlingCurrencyConverter(ExchangeRateService exchangeRateService){
		this.exchangeRateService = exchangeRateService
	}
	
	private double convert(double amount, double rate) throws InvalidAmountException {
		if (amount < 0) {
			throw new InvalidAmountException("amount must be non-negative")
		}
		return amount * rate
	}
	
	@Override
	public double convertFromSterling(double amount, Currency toCurrency)
			throws InvalidAmountException {
		return convert(amount, exchangeRateService.retrieveRate(toCurrency).fromRate)
	}

	@Override
	public double convertToSterling(double amount, Currency fromCurrency)
			throws InvalidAmountException {
		 return convert(amount, exchangeRateService.retrieveRate(fromCurrency).toRate)
	}

}
