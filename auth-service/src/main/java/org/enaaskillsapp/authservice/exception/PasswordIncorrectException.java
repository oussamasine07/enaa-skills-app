package org.enaaskillsapp.authservice.exception;

public class PasswordIncorrectException extends RuntimeException {

    public PasswordIncorrectException( String messge ) {
        super(messge);
    }

}
