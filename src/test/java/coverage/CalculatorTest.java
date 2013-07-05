package coverage;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the class {@link Calculator}.
 */
public class CalculatorTest {
    /**
     * Ruft Konstruktor auf.
     */
    public void testNothing() {
        new Calculator();
    }

    /**
     * Berechnet das Maximium mindestens zweier Zahlen.
     */
    @Test
    public void testFindMaximumOfSeveralValues() {
        Calculator calculator = new Calculator();

        assertEquals("Wrong maximum value", 2, calculator.max(new int[] {1, 2}));
        assertEquals("Wrong maximum value", 3, calculator.max(new int[] {1, 2, 3}));
        assertEquals("Wrong maximum value", 3, calculator.max(new int[] {3, 2, 1}));
        assertEquals("Wrong maximum value", 3, calculator.max(new int[] {3, 2, 1, 3}));

        assertEquals("Wrong maximum value", -1, calculator.max(new int[] {-3, -2, -1}));
    }

    /**
     * Prüft, dass kein leeres Array übergeben werden kann.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyArrayThrowsException() {
        Calculator calculator = new Calculator();

        calculator.max(new int[0]);
    }

    /**
     * Falls <code>null</code> übergeben wird, soll eine {@link NullPointerException} geworfen werden.
     */
    @Test(expected = NullPointerException.class)
    public void testNullArrayThrowsException() {
        Calculator calculator = new Calculator();

        calculator.max(null);
    }
}

