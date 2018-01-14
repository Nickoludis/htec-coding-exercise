package com.htec.codingexercise;

import com.htec.codingexercise.dialog.di.ModuleDialogManager;
import com.htec.codingexercise.errorhandler.di.ModuleErrorHandler;
import com.htec.codingexercise.network.di.ModuleNetworkManager;
import com.htec.codingexercise.ui.activity.di.ComponentActivity;
import com.htec.codingexercise.navigation.di.ModuleNavigationController;

import javax.inject.Singleton;

import dagger.Component;


/**
 * The component which lifetime is the life of the Application
 */

@Singleton
@Component(modules = {ModuleApp.class, ModuleNetworkManager.class})
public interface ComponentApp {

//    App application();
//
//    NetworkManager networkManager();

    ComponentActivity get(ModuleErrorHandler moduleErrorHandler, ModuleNavigationController moduleNavigationController, ModuleDialogManager moduleDialogManager);
}
