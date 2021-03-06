package com.alodiga.wallet.common.exception;

import org.apache.log4j.Logger;

public class EmptyListException extends Exception {

    private static final long serialVersionUID = 1L;

    public EmptyListException(String message) {
        super(message);
    }

    public EmptyListException(Logger logger, String message, Exception e) {
        super(message, e);
        logger.error(message, e);
    }

    public EmptyListException(String message, StackTraceElement[] stackTrace) {
        super(message);
        setStackTrace(stackTrace);
    }
}
