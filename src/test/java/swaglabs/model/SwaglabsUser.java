package swaglabs.model;

public enum SwaglabsUser {
    STANDARD_USER("standard_user", "secret_sauce");

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    private final String userName;
    private final String password;

    SwaglabsUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
