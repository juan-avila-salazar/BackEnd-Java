package com.ej7.crudvalidation.exceptions;

public class EntityNotFoundException extends Exception{
    public EntityNotFoundException(String customError){
        super(customError);
    }
}
