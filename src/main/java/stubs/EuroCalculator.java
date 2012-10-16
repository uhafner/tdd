package stubs;

import stubs.ExchangeRateService.Currency;

/**
 * Währungsrechner in Euro.
 */
public class EuroCalculator {
    private final ExchangeRateService webService = new YahooExchangeRateService();
    
    /**
     * Rechnet den gegebenen Betrag in Euro um.
     *
     * @param amount
     *            Betrag
     * @param currency
     *            Währung
     * @return Euro Betrag
     */
    public double calculate(final double amount, final Currency currency) {
        return amount * webService.getRate(currency, Currency.EUR);
    }
    
    /**
     * Gets exchange rates from Yahoo.
     */
    private static class YahooExchangeRateService implements ExchangeRateService {
        @Override
        public double getRate(final Currency from, final Currency to) {
            // calls web service
            return 0;
        }
    }
}

