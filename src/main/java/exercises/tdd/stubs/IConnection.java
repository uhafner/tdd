package exercises.tdd.stubs;

/**
 * Creates user sessions.
 */
public interface IConnection {
    /**
     * Authenticates the specified user.
     *
     * @param user
     *            the user name
     * @param password
     *            password of the user
     * @return returns the session object
     * @throws IllegalStateException
     *             if the system cannot handle the authentication due to a
     *             technical problemF
     */
    ISession authenticate(String user, String password);
}

