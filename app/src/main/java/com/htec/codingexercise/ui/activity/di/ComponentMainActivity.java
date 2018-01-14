package com.htec.codingexercise.ui.activity.di;

import com.htec.codingexercise.annotation.PerActivity;
import com.htec.codingexercise.dialog.di.ModuleDialogManager;
import com.htec.codingexercise.navigation.di.ModuleNavigationController;
import com.htec.codingexercise.ui.activity.MainActivity;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = {ModuleNavigationController.class, ModuleDialogManager.class})
public interface ComponentMainActivity {

    void inject(MainActivity mainActivity);
}
