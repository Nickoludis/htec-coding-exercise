package com.htec.codingexercise.navigation;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.htec.codingexercise.animation.AnimationUtils;
import com.htec.codingexercise.navigation.action.NavigationActionAddToBackStack;
import com.htec.codingexercise.navigation.action.NavigationActionAnimationType;
import com.htec.codingexercise.navigation.action.NavigationActionArguments;
import com.htec.codingexercise.navigation.action.NavigationActionExecute;
import com.htec.codingexercise.navigation.action.NavigationActionFragmentName;
import com.htec.codingexercise.navigation.action.NavigationActionIsDialog;

/**
 * Simple builder class which provides fluent way of preparing data for fragment transaction.
 */
public class NavigationActionBuilder implements NavigationActionFragmentName,
        NavigationActionAddToBackStack,
        NavigationActionIsDialog,
        NavigationActionAnimationType,
        NavigationActionArguments,
        NavigationActionExecute {

    private NavigationAction navigationAction = new NavigationAction();
    private NavigationController navigationController;

    public NavigationActionBuilder(NavigationController navigationController) {
        this.navigationController = navigationController;
    }

    @Override
    public NavigationActionAddToBackStack fragment(final Class<? extends Fragment> fragment) {
        navigationAction.fragment = fragment;
        return this;
    }

    @Override
    public NavigationActionIsDialog addToBackStack(boolean addToBackStack) {
        navigationAction.addToBackStack = addToBackStack;
        return this;
    }

    @Override
    public NavigationActionBuilder isDialog(boolean isDialog) {
        return this;
    }

    @Override
    public NavigationActionBuilder animation(final AnimationUtils.Transition animationType) {
        navigationAction.animationType = animationType;
        return this;
    }

    @Override
    public NavigationActionBuilder arguments(Bundle arguments) {
        navigationAction.arguments = arguments;
        return this;
    }

    @Override
    public void load() {
        navigationController.performNavigation(navigationAction);
    }
}
