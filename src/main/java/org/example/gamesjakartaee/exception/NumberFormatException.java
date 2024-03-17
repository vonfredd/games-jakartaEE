package org.example.gamesjakartaee.exception;

public class NumberFormatException extends java.lang.NumberFormatException {
    public NumberFormatException(){
        super();
    }

    public NumberFormatException(String message){
        super("NumberFormatException : " + message);
    }
}
