package com.htec.codingexercise.navigation;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

/**
 * Defines all essential fragment transaction methods.
 */
public interface FragmentTransactionExecutor {

    void executeNavigation(@NonNull NavigationAction action);

    void clearFragmentManagerBackStack(@NonNull Class<? extends Fragment> fragment);

    String getCurrentFragmentName();

    /**
     * Handles user back press event.
     */
    boolean onBackPress();
}
