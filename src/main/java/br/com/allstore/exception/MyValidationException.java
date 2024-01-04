package br.com.allstore.exception;

public class MyValidationException extends RuntimeException{

    public MyValidationException(String message){
        super(message);
    }
}
