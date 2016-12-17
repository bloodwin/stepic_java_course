package accounts;

/**
 * @author Anna Bloodwina
 * @version 1.0.201612152039
 */
public class UserProfile {
    private String login;
    private String password;
    private String email;

    public UserProfile(String login, String pass, String email) {
        this.login = login;
        this.password = pass;
        this.email = email;
    }
    public UserProfile(String login) {
        this.login = login;
        this.password = login;
        this.email = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
