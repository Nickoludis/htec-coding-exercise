package com.htec.codingexercise.navigation.di;

import com.htec.codingexercise.annotation.PerActivity;
import com.htec.codingexercise.navigation.FragmentTransactionExecutorImpl;
import com.htec.codingexercise.navigation.NavigationController;
import com.htec.codingexercise.navigation.NavigationControllerImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class ModuleNavigationController {

    FragmentTransactionExecutorImpl fragmentTransactionExecutor;

    public ModuleNavigationController(FragmentTransactionExecutorImpl fragmentTransactionExecutor){
        this.fragmentTransactionExecutor = fragmentTransactionExecutor;
    }

    @PerActivity
    @Provides
    public NavigationController provideErrorHandler() {
        return new NavigationControllerImpl(fragmentTransactionExecutor);
    }
}
