package org.example.exception;

public class PasswordException extends Exception {
    public PasswordException() {
        super("Password or confirm password is not valid");
    }
}
