package edu.hm.hafner.tdd;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.hm.hafner.tdd.EuroConverter.Currency;

/**
 * Konvertiert Beträge aus verschiedenen Währungen in Euro.
 *
 * @author Ulli Hafner
 */
public class EuroConverterTest {
    /** Delta für double Gleichheit. */
    private static final double DELTA = 0.0001;

    /**
     * Überprüfe, dass die 1:1 Konversion von Euro nach Euro funktioniert.
     */
    @Test
    public void ueberpruefe1zu1Konversion() {
        // Given
        EuroConverter euroConverter = new EuroConverter();

        uberpruefeEuro(euroConverter, 20.0);
        uberpruefeEuro(euroConverter, 1.0);
    }

    private void uberpruefeEuro(final EuroConverter euroConverter, final double eingabe) {
        // When
        double resultat = euroConverter.convertToEuro(eingabe, Currency.EUR);

        // Then
        assertEquals("Euro conversion von Euro aus:", eingabe, resultat, DELTA);
    }

    /**
     * Überprüfe, dass ein Euro 1.20 Franken ist.
     */
    @Test
    public void ueberpruefeFrankenConversion() {
        // Given
        EuroConverter euroConverter = new EuroConverter();

        // When
        double resultat = euroConverter.convertToEuro(6, Currency.CHF);

        // Then
        assertEquals("Euro Conversion vom Franken aus:", 5, resultat, DELTA);
    }
}
