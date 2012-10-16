package stubs;

import junit.framework.TestCase;
import stubs.ExchangeRateService.Currency;

/**
 * Tests the class {@link EuroCalculator}.
 */
public class EuroCalculatorTest extends TestCase {
    private static final double EPSILON = 0.001;
    
    /**
     * Tests the conversion from EUR to EUR.
     */
    public void testEuroToEuroConversion() {
        EuroCalculator euroCalculator = new EuroCalculator();
        
        assertEquals("Falsche Umrechnung", 15.0, euroCalculator.calculate(15.0, Currency.EUR), EPSILON);
        assertEquals("Falsche Umrechnung", 1.0, euroCalculator.calculate(1.0, Currency.EUR), EPSILON);
    }
    
    /**
     * Tests the conversion from USD to EUR.
     */
    public void testDollarToEuroConversion() {
        EuroCalculator euroCalculator = new EuroCalculator();
        
        assertEquals("Falsche Umrechnung", 10.0, euroCalculator.calculate(15.0, Currency.USD), EPSILON);
        assertEquals("Falsche Umrechnung", 1.0, euroCalculator.calculate(1.5, Currency.USD), EPSILON);
    }
}

