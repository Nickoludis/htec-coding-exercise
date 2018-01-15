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

    boolean onBackPress();
}
