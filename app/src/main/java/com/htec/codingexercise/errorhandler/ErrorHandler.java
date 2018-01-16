package com.htec.codingexercise.errorhandler;

public interface ErrorHandler {

    /**
     * Should check and react on passed error object.
     */
    void error(Throwable error);
}
