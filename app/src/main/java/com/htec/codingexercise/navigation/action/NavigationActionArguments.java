package com.htec.codingexercise.navigation.action;

import android.os.Bundle;

import com.htec.codingexercise.navigation.NavigationActionBuilder;

/**
 * Represents parameter in fragment transaction operation.
 */
public interface NavigationActionArguments {

    /**
     * Passes arguments to be passed to fragment.
     *
     * @param arguments Bundle instance
     * @return NavigationActionBuilder instance
     */
    NavigationActionBuilder arguments(Bundle arguments);
}
