package exercises.tdd.stubs;

/**
 * Session of a user.
 */
public interface ISession {
    /**
     * Returns the name of the authenticated user.
     *
     * @return the name of the authenticated user.
     */
    String getUserName();
    
    /**
     * Returns whether the user has been successfully authenticated.
     *
     * @return <code>true</code> if the user has been successfully
     *         authenticated, <code>false</code> otherwise.
     */
    boolean isAuthenticated();
    
    /**
     * Returns whether the user needs to change his password.
     *
     * @return <code>true</code> if the user needs to change the password,
     *         <code>false</code> otherwise.
     */
    boolean isPasswordExpired();
}

