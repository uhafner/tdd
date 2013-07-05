package edu.hm.hafner.tdd;

/**
 * Konvertiert Währungen in den Euro.
 *
 * @author Ulli Hafner
 */
public class EuroRechner {
    private final YahooCurrencyService yahooCurrencyService;

    /**
     * Creates a new instance of {@link EuroRechner}.
     */
    public EuroRechner() {
        this(new YahooCurrencyService());
    }

    /**
     * Creates a new instance of {@link EuroRechner}.
     *
     * @param yahooCurrencyService
     *            der Währungsservice
     */
    public EuroRechner(final YahooCurrencyService yahooCurrencyService) {
        this.yahooCurrencyService = yahooCurrencyService;
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
        return yahooCurrencyService.getRate(Currency.EUR, currency);
    }
}
