package coverage;

/**
 * Stellt einfache Berechnungen zur Verfügung.
 */
public class Calculator {
    /**
     * Bestimmt das Maximum der übergebenen Werte.
     *
     * @param values die zu testenden Werte
     * @return das maximum
     * @throws IllegalArgumentException falls das array {@code values} leer ist
     */
    public int max(final int[] values) {
        if (values.length == 0) {
            throw new IllegalArgumentException("input must not be empty.");
        }
        int value = Integer.MIN_VALUE;
        
        for (int i : values) {
            value = Math.max(value, i);
        }
        return value;
    }
}

