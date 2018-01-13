package com.htec.codingexercise.utils;

import android.util.Log;

import com.htec.codingexercise.BuildConfig;

/**
 * Logger utility class
 */
public class Logger {

    private static final String DEFAULT_ERROR_MESSAGE = "ERROR!";

    private Logger() {
    }

    /**
     * Logs an error
     */
    @SuppressWarnings("checkstyle:methodname")
    public static void e(Class class2Log, String message) {
        Log.e(class2Log.getSimpleName(), deNullMessage(message));
    }

    /**
     * Logs an error
     */
    @SuppressWarnings("checkstyle:methodname")
    public static void e(Class class2Log, String message, Throwable tr) {
        Log.e(class2Log.getSimpleName(), deNullMessage(message), tr);
    }

    /**
     * Logs a debug line
     */
    @SuppressWarnings("checkstyle:methodname")
    public static void d(Class class2Log, String message) {
        if (BuildConfig.DEBUG) {
            Log.d(class2Log.getSimpleName(), deNullMessage(message));
        }
    }

    /**
     * Logs a debug line
     */
    @SuppressWarnings("checkstyle:methodname")
    public static void d(Class class2Log, String message, Throwable tr) {
        if (BuildConfig.DEBUG) {
            Log.d(class2Log.getSimpleName(), deNullMessage(message), tr);
        }
    }

    /**
     * Logs a verbose level line
     */
    @SuppressWarnings("checkstyle:methodname")
    public static void v(Class class2Log, String message) {
        if (BuildConfig.DEBUG) {
            Log.v(class2Log.getSimpleName(), deNullMessage(message));
        }
    }

    /**
     * Logs a verbose level line
     */
    @SuppressWarnings("checkstyle:methodname")
    public static void v(Class class2Log, String message, Throwable tr) {
        if (BuildConfig.DEBUG) {
            Log.v(class2Log.getSimpleName(), deNullMessage(message), tr);
        }
    }

    /**
     * Logs a warning line
     */
    @SuppressWarnings("checkstyle:methodname")
    public static void w(Class class2Log, String message) {
        Log.w(class2Log.getSimpleName(), deNullMessage(message));
    }

    /**
     * Logs a warning line
     */
    @SuppressWarnings("checkstyle:methodname")
    public static void w(Class class2Log, String message, Throwable tr) {
        Log.w(class2Log.getSimpleName(), deNullMessage(message), tr);
    }

    /**
     * Logs an info line
     */
    @SuppressWarnings("checkstyle:methodname")
    public static void i(Class class2Log, String message) {
        Log.i(class2Log.getSimpleName(), deNullMessage(message));
    }

    /**
     * Logs an info line
     */
    @SuppressWarnings("checkstyle:methodname")
    public static void i(Class class2Log, String message, Throwable tr) {
        Log.i(class2Log.getSimpleName(), deNullMessage(message), tr);
    }

    @SuppressWarnings("checkstyle:methodname")
    private static String deNullMessage(String message) {
        return message != null ? message : DEFAULT_ERROR_MESSAGE;
    }
}
