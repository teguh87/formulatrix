package com.example.formulatrix.utils;

public class IllegalOperationException extends Exception {
    public static final long serialVersionUID = 1L;

    public IllegalOperationException(String ex){
        super(ex);
    }
}