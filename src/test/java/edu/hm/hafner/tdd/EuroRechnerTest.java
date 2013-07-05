package edu.hm.hafner.tdd;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

/**
 * Konvertiert Beträge aus verschiedenen Währungen in Euro.
 *
 * @author Ulli Hafner
 */
public class EuroRechnerTest {
    /** Delta für double Gleichheit. */
    private static final double DELTA = 0.0001;

    /**
     * Überprüfe, dass die 1:1 Konversion von Euro nach Euro funktioniert.
     */
    @Test
    public void ueberpruefe1zu1Konversion() {
        // Given
        EuroRechner euroConverter = new EuroRechner(new YahooCurrencyService() {
            @Override
            public double getRate(final Currency fromCurrency, final Currency toCurrency) {
                return 1;
            }
        });

        uberpruefeEuro(euroConverter, 20.0);
        uberpruefeEuro(euroConverter, 1.0);
    }

    private void uberpruefeEuro(final EuroRechner euroConverter, final double eingabe) {
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
        YahooCurrencyService currencyService = mock(YahooCurrencyService.class);
        when(currencyService.getRate(Currency.EUR, Currency.CHF)).thenReturn(5 / 6.0);
        when(currencyService.getRate(any(Currency.class), any(Currency.class))).thenReturn(5 / 6.0);
        EuroRechner euroConverter = new EuroRechner(currencyService);

        // When
        double resultat = euroConverter.convertToEuro(6, Currency.CHF);

        // Then
        assertEquals("Euro Conversion vom Franken aus:", 5, resultat, DELTA);
    }
}
