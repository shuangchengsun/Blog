package com.alan.blog.Exception;

public class TagFormatErrorException extends RuntimeException{

    public TagFormatErrorException() {
        super();
    }

    public TagFormatErrorException(String message) {
        super(message);
    }

    public TagFormatErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
