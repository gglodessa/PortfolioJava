package UIObjects.data;

public enum Account {

    STANDARD_USER("standard_user", "secret_sauce");
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
