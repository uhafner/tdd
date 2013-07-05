package stubs;

/**
 * Provides exchange rates.
 */
public interface ExchangeRateService {
    /**
     * Unterstützte Währungen.
     */
    public enum Currency {
        /** Euro. */
        EUR,

        /** Schweizer Franken. */
        CHF,

        /** US Dollar. */
        USD,
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
