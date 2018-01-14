package com.htec.codingexercise.dialog.di;

import android.app.Activity;

import com.htec.codingexercise.annotation.PerActivity;
import com.htec.codingexercise.dialog.DialogManager;
import com.htec.codingexercise.dialog.DialogManagerImp;
import com.htec.codingexercise.navigation.NavigationController;
import com.htec.codingexercise.utils.ResourceGetter;
import com.htec.codingexercise.utils.ResourceGetterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class ModuleDialogManager {

    private Activity activity;

    public ModuleDialogManager(Activity activity) {
        this.activity = activity;
    }

    @PerActivity
    @Provides
    public DialogManager provideDialogManager(NavigationController navigationController, ResourceGetter resourceGetter) {
        return new DialogManagerImp(navigationController, resourceGetter);
    }

    @PerActivity
    @Provides
    public ResourceGetter providesResourceGetter() {
        return new ResourceGetterImpl(activity);
    }
}
