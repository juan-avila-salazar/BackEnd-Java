package com.ej7.crudvalidation.exceptions;

public class UnprocessableEntityException extends Exception{
    public UnprocessableEntityException(String customError){
        super(customError);
    }
}
