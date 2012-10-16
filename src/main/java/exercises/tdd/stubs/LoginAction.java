package exercises.tdd.stubs;

/**
 * Authenticates a user.
 */
public class LoginAction {
    static final String AUTHENTICATION_CANCELED = "Authentication canceled due to a server error.";
    static final String WRONG_USER_NAME_OR_PASSWORD = "Wrong user name or password.";
    
    private final IConnection connection = new DatabaseConnection();
    
    private final String password;
    private final String user;
    
    private String details;
    private String message;
    private boolean canCloseDialog;
    
    private ISession session;
    
    /**
     * Creates a new instance of {@link LoginAction}.
     *
     * @param user
     *            user name
     * @param password
     *            password
     */
    public LoginAction(final String user, final String password) {
        this.password = password;
        this.user = user;
    }
    
    /**
     * Runs this action.
     */
    public void run() {
        try {
            session = connection.authenticate(user, password);
            if (session.isAuthenticated()) {
                canCloseDialog = true;
            }
            else {
                message = WRONG_USER_NAME_OR_PASSWORD;
            }
        }
        catch (IllegalStateException exception) {
            message = AUTHENTICATION_CANCELED;
            details = exception.getMessage();
        }
    }
    
    /**
     * Returns the session.
     *
     * @return the session
     */
    public ISession getSession() {
        return session;
    }
    
    /**
     * Returns the message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }
    
    /**
     * Returns the details.
     *
     * @return the details
     */
    public String getDetails() {
        return details;
    }
    
    /**
     * Returns whether the user has been successfully authenticated.
     *
     * @return the canCloseDialog
     */
    public boolean isSuccessfullyAuthenticated() {
        return canCloseDialog;
    }
    
    private static class DatabaseConnection implements IConnection {
        @Override
        public ISession authenticate(final String user, final String password) {
            return new ISession() {
                @Override
                public boolean isPasswordExpired() {
                    return false;
                }
                
                @Override
                public boolean isAuthenticated() {
                    return true;
                }
                
                @Override
                public String getUserName() {
                    return user;
                }
            };
        }
        
    }
}

