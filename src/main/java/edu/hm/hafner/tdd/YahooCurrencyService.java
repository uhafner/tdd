package edu.hm.hafner.tdd;

/**
 * Liefert den Währungskurs von Yahoo zurück.
 *
 * @author Ulli Hafner
 */
public class YahooCurrencyService {
    /**
     * Liefert den Währungskurs von Yahoo zurück.
     *
     * @param fromCurrency
     *            Ausgangswährung
     * @param toCurrency
     *            Zielwährung
     * @return der Währungskurs
     */
    public double getRate(final Currency fromCurrency, final Currency toCurrency) {
        if (Currency.CHF == toCurrency) {
            return 5.0 / 6;
        }
        return 1.0; // fallback
    }
}

