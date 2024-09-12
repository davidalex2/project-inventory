package com.algoriant.userDetail.model;

public class ImsException extends Exception {
    public ImsException() {
    }

    public ImsException(String message) {
        super(message);
    }

    public ImsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ImsException(Throwable cause) {
        super(cause);
    }

    public ImsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
