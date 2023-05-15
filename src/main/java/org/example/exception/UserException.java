package org.example.exception;

public class UserException extends  Exception{
    public UserException() {

        super("Ce nom est deja utilise ");
    }
}