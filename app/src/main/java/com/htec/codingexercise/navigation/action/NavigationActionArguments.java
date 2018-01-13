package com.htec.codingexercise.navigation.action;

import android.os.Bundle;

import com.htec.codingexercise.navigation.NavigationActionBuilder;

/**
 * Classes implementing this interface allow to navigate to a pass arguments to fragment
 */
public interface NavigationActionArguments {

    NavigationActionBuilder arguments(Bundle arguments);
}
