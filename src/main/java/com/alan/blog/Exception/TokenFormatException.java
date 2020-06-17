package com.alan.blog.Exception;

public class TokenFormatException extends RuntimeException{
    public TokenFormatException() {
    }

    public TokenFormatException(String message) {
        super(message);
    }

    public TokenFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
