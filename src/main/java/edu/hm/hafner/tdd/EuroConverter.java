package edu.hm.hafner.tdd;

/**
 * Konvertiert Währungen in den Euro.
 *
 * @author Ulli Hafner
 */
public class EuroConverter {
    /**
     * Unterstützte Währungen.
     */
    enum Currency {
        /** Euro. */
        EUR,

        /** Schweizer Franken. */
        CHF,
    }

    /**
     * Konvertiert den gegebenen Wert in der gegebenen Währung in Euro.
     *
     * @param value
     *            der Wert
     * @param currency
     *            die Währung
     * @return der Wert in Euro
     */
    public double convertToEuro(final double value, final Currency currency) {
        return value * getRate(currency);
    }

    /**
     * Liefert den Währungskurs bezüglich des Euro zurück.
     *
     * @param currency
     *            die Währung
     * @return der Währungskurs
     */
    private double getRate(final Currency currency) {
        if (Currency.CHF == currency) {
            return 5.0 / 6;
        }
        return 1.0; // fallback
    }
}
