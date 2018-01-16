package com.htec.codingexercise.navigation.action;

import android.support.v4.app.Fragment;

/**
 * Represents parameter in fragment transaction operation.
 */
public interface NavigationActionFragmentName {

    /**
     * Receives fragment class name as parameter.
     *
     * @param fragment fragment class name
     * @return NavigationActionAddToBackStack as next parameter to be set in builder chain
     */
    NavigationActionAddToBackStack fragment(Class<? extends Fragment> fragment);
}
