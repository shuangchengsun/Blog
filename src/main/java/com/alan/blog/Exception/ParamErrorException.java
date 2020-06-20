package com.alan.blog.Exception;

public class ParamErrorException extends RuntimeException {
    public ParamErrorException() {
        super();
    }

    public ParamErrorException(String message) {
        super(message);
    }
}
