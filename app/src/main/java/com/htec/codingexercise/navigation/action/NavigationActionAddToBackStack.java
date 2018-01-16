package com.htec.codingexercise.navigation.action;

/**
 * Represents parameter in fragment transaction operation.
 */
public interface NavigationActionAddToBackStack {

    /**
     * Receives boolean value which defines whether transaction should be added to fragment back stack or not.
     *
     * @param addToBackStack true | false
     * @return NavigationActionIsDialog as next parameter to be set in builder chain
     */
    NavigationActionIsDialog addToBackStack(boolean addToBackStack);
}
