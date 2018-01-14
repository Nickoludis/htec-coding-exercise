package com.htec.codingexercise.errorhandler.di;

import android.app.Activity;

import com.htec.codingexercise.annotation.PerActivity;
import com.htec.codingexercise.dialog.DialogManager;
import com.htec.codingexercise.errorhandler.ErrorHandler;
import com.htec.codingexercise.errorhandler.ErrorHandlerImp;
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
    public ErrorHandler provideErrorHandler(NetworkManager networkManager, DialogManager dialogManager) {
        return new ErrorHandlerImp(context, networkManager, dialogManager);
    }
}