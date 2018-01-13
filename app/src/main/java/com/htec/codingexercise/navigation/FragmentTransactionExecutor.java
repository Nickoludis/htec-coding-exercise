/*
 * © 2017. Amazon.com, Inc. or its affiliates. All Rights Reserved.
 */

package com.htec.codingexercise.navigation;


import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

/**
 * Interface to implement to provide component that handles fragment navigation
 */
public interface FragmentTransactionExecutor {

    void executeNavigation(@NonNull NavigationAction action);

    void clearFragmentManagerBackStack(@NonNull Class<? extends Fragment> fragment);

    void popBackStack();

    String getCurrentFragmentName();

    boolean canGoBack();

//    /**
//     * Presents dialog as overlay on the screen
//     *
//     * @param dialog {@link OzDialog}
//     * @param tag tag name
//     */
//    void showDialog(OzDialog dialog, String tag);
}
