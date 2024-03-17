package org.example.gamesjakartaee.exception;

public class NotFoundException extends jakarta.ws.rs.NotFoundException {
    public NotFoundException(){
        super();
    }

    public NotFoundException(String message){
        super("NotFoundException : " + message);
    }
}
