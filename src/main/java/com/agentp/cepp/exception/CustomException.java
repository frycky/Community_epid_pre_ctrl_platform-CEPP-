package com.agentp.cepp.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException{
    private Integer code;
    public CustomException(Integer code,String msg){
        super(msg);
        this.code = code;
    }

    public CustomException(String message) {
        super(message);
        this.code = 500;
    }
}
