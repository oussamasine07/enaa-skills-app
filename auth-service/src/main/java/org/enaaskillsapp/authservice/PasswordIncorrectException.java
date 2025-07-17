package org.enaaskillsapp.authservice;

public class PasswordIncorrectException extends RuntimeException {

    public PasswordIncorrectException( String messge ) {
        super(messge);
    }

}
