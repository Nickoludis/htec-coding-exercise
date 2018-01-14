package com.htec.codingexercise.error.di;

import android.app.Activity;

import com.htec.codingexercise.annotation.PerActivity;
import com.htec.codingexercise.error.ErrorHandler;
import com.htec.codingexercise.error.ErrorHandlerImp;
import com.htec.codingexercise.network.NetworkManager;

import dagger.Module;
import dagger.Provides;

@Module
public class ModuleErrorHandler {

    private final Activity context;

    public ModuleErrorHandler(Activity context) {
        this.context = context;
    }

    @PerActivity
    @Provides
    public ErrorHandler provideErrorHandler(NetworkManager networkManager) {
        //TODO: Pass dialog manager
        return new ErrorHandlerImp(context, networkManager /*, dialog manager */);
    }
}