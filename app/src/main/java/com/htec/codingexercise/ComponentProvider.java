package com.htec.codingexercise;

public interface ComponentProvider {
    <T> T component(Class<T> type);
}