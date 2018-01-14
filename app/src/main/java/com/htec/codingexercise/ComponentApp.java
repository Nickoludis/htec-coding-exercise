package com.htec.codingexercise;

import com.htec.codingexercise.error.di.ModuleErrorHandler;
import com.htec.codingexercise.network.NetworkManager;
import com.htec.codingexercise.network.di.ModuleNetworkManager;
import com.htec.codingexercise.ui.App;
import com.htec.codingexercise.ui.activity.ComponentActivity;

import javax.inject.Singleton;

import dagger.Component;


/**
 * The component which lifetime is the life of the Application
 */

@Singleton
@Component(modules = {ModuleApp.class, ModuleNetworkManager.class})
public interface ComponentApp {

    App application();

    NetworkManager networkManager();

    ComponentActivity get(ModuleErrorHandler handler);
}
