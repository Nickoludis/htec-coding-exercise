package com.htec.codingexercise.navigation.di;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.htec.codingexercise.annotation.PerActivity;
import com.htec.codingexercise.navigation.FragmentTransactionExecutorImpl;
import com.htec.codingexercise.navigation.NavigationController;
import com.htec.codingexercise.navigation.NavigationControllerImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class ModuleNavigationController {

    @IdRes
    private final int layoutId;
    @NonNull
    private final FragmentManager fragmentManager;

    public ModuleNavigationController(@IdRes int layoutId, @NonNull FragmentManager fragmentManager) {
        this.layoutId = layoutId;
        this.fragmentManager = fragmentManager;
    }

    @PerActivity
    @Provides
    public NavigationController provideNavigationController() {
        return new NavigationControllerImpl(new FragmentTransactionExecutorImpl(layoutId, fragmentManager));
    }
}
