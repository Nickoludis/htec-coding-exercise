package com.htec.codingexercise.navigation;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.htec.codingexercise.navigation.action.NavigationActionAddToBackStack;

public class NavigationControllerImpl implements NavigationController {

    protected NavigationActionBuilder navigationActionBuilder;
    private FragmentTransactionExecutorImpl fragmentTransactionExecutor;

    public NavigationControllerImpl(FragmentTransactionExecutorImpl fragmentTransactionExecutor) {
        this.fragmentTransactionExecutor = fragmentTransactionExecutor;
        this.navigationActionBuilder = new NavigationActionBuilder(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NavigationActionAddToBackStack loadPage(@NonNull Class<? extends Fragment> fragmentName) {
        return navigationActionBuilder.fragment(fragmentName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void performNavigation(NavigationAction action) {
        fragmentTransactionExecutor.executeNavigation(action);
    }

    @Override
    public void showDialog() {
        // TODO : Implement dialog manager
    }
}
