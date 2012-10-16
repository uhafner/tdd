package exercises.coverage;

/**
 * <p>
 * Operations on {@link java.lang.String} that are <code>null</code> safe.
 * </p>
 */
public class StringUtils {
    /**
     * <code>\u000a</code> linefeed LF ('\n').
     *
     * @see <a
     *      href="http://java.sun.com/docs/books/jls/third_edition/html/lexical.html#101089">JLF:
     *      Escape Sequences for Character and String Literals</a>
     * @since 2.2
     */
    public static final char LF = '\n';
    
    /**
     * <code>\u000d</code> carriage return CR ('\r').
     *
     * @see <a
     *      href="http://java.sun.com/docs/books/jls/third_edition/html/lexical.html#101089">JLF:
     *      Escape Sequences for Character and String Literals</a>
     * @since 2.2
     */
    public static final char CR = '\r';
    
    /**
     * <p>
     * Removes one newline from end of a String if it's there, otherwise leave
     * it alone. A newline is &quot;<code>\n</code>&quot;, &quot;<code>\r</code>
     * &quot;, or &quot;<code>\r\n</code>&quot;.
     * </p>
     *
     * @param str
     *            the String to chomp a newline from, may be null
     * @return String without newline, <code>null</code> if null String input
     */
    public static String chomp(final String str) {
        if (isEmpty(str)) {
            return str;
        }
        
        if (str.length() == 1) {
            char ch = str.charAt(0);
            if (ch == CR || ch == LF) {
                return "";
            }
            return str;
        }
        
        int lastIdx = str.length() - 1;
        char last = str.charAt(lastIdx);
        
        if (last == LF) {
            if (str.charAt(lastIdx - 1) == CR) {
                lastIdx--;
            }
        }
        else if (last != CR) {
            lastIdx++;
        }
        return str.substring(0, lastIdx);
    }
    
    /**
     * <p>
     * Deletes all whitespaces from a String as defined by
     * {@link Character#isWhitespace(char)}.
     * </p>
     *
     * @param str
     *            the String to delete whitespace from, may be null
     * @return the String without whitespaces, <code>null</code> if null String
     *         input
     */
    public static String deleteWhitespace(final String str) {
        if (isEmpty(str)) {
            return str;
        }
        int sz = str.length();
        char[] chs = new char[sz];
        int count = 0;
        for (int i = 0; i < sz; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                chs[count++] = str.charAt(i);
            }
        }
        if (count == sz) {
            return str;
        }
        return new String(chs, 0, count);
    }
    
    /**
     * <p>
     * Checks if a String is empty ("") or null.
     * </p>
     *
     * @param str
     *            the String to check, may be null
     * @return <code>true</code> if the String is empty or null
     */
    public static boolean isEmpty(final String str) {
        return str == null || str.length() == 0;
    }
}
