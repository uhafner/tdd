package stubs;

/**
 * Provides exchange rates.
 */
public interface ExchangeRateService {
    public enum Currency {
        EUR, USD, SFR
    }
    
    /**
     * Returns the current exchange rate.
     *
     * @param from
     *            original currency
     * @param to
     *            target currency
     * @return the exchange rate
     */
    double getRate(Currency from, Currency to);
}
