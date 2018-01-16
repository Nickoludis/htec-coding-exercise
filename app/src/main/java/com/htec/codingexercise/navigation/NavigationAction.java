package com.htec.codingexercise.navigation;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.htec.codingexercise.animation.AnimationUtils;

/**
 * Holds parameters necessary for fragment transaction execution.
 */
class NavigationAction {

    /**
     * Fragment name
     */
    public Class<? extends Fragment> fragment;

    /**
     * Is fragment instance of {@code {@link android.support.v4.app.DialogFragment}}
     */
    public boolean isDialog;

    /**
     * Should fragment be added to the back stack
     */
    public boolean addToBackStack;

    /**
     * Additional parameters to be passed to the fragment
     */
    public Bundle arguments;

    /**
     * Animation to be performed during transaction
     */
    public AnimationUtils.Transition animationType = AnimationUtils.Transition.RIGHT_TO_LEFT;
}
