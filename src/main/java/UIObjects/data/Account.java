package UIObjects.data;

public enum Account {

    STANDARD_USER("standard_user", "secret_sauce"),
    LOCKED_USER("locked_out_user", "secret_sauce"),
    STANDARD_USER_WITH_WRONG_PASS("standard_user", "wrong_pass");
    // Other accounts might be placed here

    private String login;
    private String password;

    Account(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
