package org.example.exception;

public class UserException extends  Exception{
    public UserException() {

        super("this username is already used");
    }
}