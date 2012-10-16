package coverage;
import junit.framework.TestCase;

/**
 * Tests the class {@link Calculator}.
 */
public class CalculatorTest extends TestCase {
    /**
     * Ruft Konstruktor auf.
     */
    public void testNothing() {
        new Calculator();
    }
    
    /**
     * Berechnet das Maximium mindestens zweier Zahlen.
     */
    public void ttestFindMaximumOfSeveralValues() {
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
    public void ttestEmptyArrayThrowsException() {
        Calculator calculator = new Calculator();
        
        boolean isTrown = false;
        try {
            calculator.max(new int[0]);
        }
        catch (IllegalArgumentException exception) {
            isTrown = true;
        }
        assertTrue("No exception is thrown", isTrown);
    }
    
    /**
     * Falls <code>null</code> übergeben wird, soll eine {@link NullPointerException} geworfen werden.
     */
    public void ttestNullArrayThrowsException() {
        Calculator calculator = new Calculator();
        
        boolean isTrown = false;
        try {
            calculator.max(null);
        }
        catch (NullPointerException exception) {
            isTrown = true;
        }
        assertTrue("No exception is thrown", isTrown);
    }
}

