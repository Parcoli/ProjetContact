package org.example.signup;

public class SignUpData {

    private String username;

    private String password;
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return confirmPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.confirmPassword = matchingPassword;
    }
}
