package org.example.exception;

public class userException extends  Exception{
    public userException() {

        super("this username is already used");
    }
}