package com.htec.codingexercise.ui.activity.di;


import com.htec.codingexercise.annotation.PerActivity;
import com.htec.codingexercise.dialog.di.ModuleDialogManager;
import com.htec.codingexercise.errorhandler.di.ModuleErrorHandler;
import com.htec.codingexercise.navigation.di.ModuleNavigationController;
import com.htec.codingexercise.ui.fragment.list.di.ComponentJsonList;
import com.htec.codingexercise.ui.fragment.list.di.ModuleJsonList;

import dagger.Subcomponent;


@PerActivity
@Subcomponent(modules = {ModuleErrorHandler.class, ModuleNavigationController.class, ModuleDialogManager.class})
public interface ComponentActivity {

//    ErrorHandler errorHandler();
//
//    NavigationController navigationController();

    ComponentMainActivity get();

    ComponentJsonList get(ModuleJsonList module);
}
