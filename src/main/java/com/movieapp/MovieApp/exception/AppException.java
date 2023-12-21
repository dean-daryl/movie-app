package com.movieapp.MovieApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AppException extends  RuntimeException{
    public AppException(String message){
        super(message);
    }
}
