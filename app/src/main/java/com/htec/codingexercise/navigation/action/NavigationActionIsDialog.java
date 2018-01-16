package com.htec.codingexercise.navigation.action;

import com.htec.codingexercise.navigation.NavigationActionBuilder;

/**
 * Represents parameter in fragment transaction operation.
 */
public interface NavigationActionIsDialog {

    /**
     * Receives boolean value which defines whether fragment is dialog or not.
     *
     * @param isDialog true | false
     * @return NavigationActionBuilder instance
     */
    NavigationActionBuilder isDialog(boolean isDialog);
}
