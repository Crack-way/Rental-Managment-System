package com.rentmangementsystem.property.exception;

public class PropertyDoesNotExistException extends  RuntimeException{


    public PropertyDoesNotExistException(String str){

        super(str);
    }
}
