package com.htec.codingexercise.navigation;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.htec.codingexercise.navigation.action.NavigationActionAddToBackStack;

public interface NavigationController {

    /**
     * Loads page with provided name
     *
     * @param fragmentName : Fragment class name
     */
    NavigationActionAddToBackStack loadPage(@NonNull Class<? extends Fragment> fragmentName);

    /**
     * Executes fragment transaction with provided parameters such as animation type or add to back stack flag.
     *
     * @param action defines additional parameters {@link NavigationAction}
     */
    void performNavigation(NavigationAction action);

    boolean canGoBack();
}
