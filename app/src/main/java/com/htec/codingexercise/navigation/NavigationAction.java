package com.htec.codingexercise.navigation;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.htec.codingexercise.animation.AnimationUtils;

/**
 * Holds parameters necessary for fragment transaction execution.
 */
class NavigationAction {

    public Class<? extends Fragment> fragment;
    public boolean isDialog;
    public boolean addToBackStack;
    public Bundle arguments;
    public AnimationUtils.Transition animationType = AnimationUtils.Transition.RIGHT_TO_LEFT;
}
