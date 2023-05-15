package org.example.exception;

public class PasswordException extends Exception {
    public PasswordException() {
        super("Mot de passe ou confirmation non valide");
    }
}
