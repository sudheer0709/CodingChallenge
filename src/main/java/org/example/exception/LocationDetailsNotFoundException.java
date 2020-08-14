package org.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class LocationDetailsNotFoundException extends RuntimeException{

    public LocationDetailsNotFoundException(String message){
        super(message);
    }
}
