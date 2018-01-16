package com.htec.codingexercise;

import com.htec.codingexercise.dialog.di.ModuleDialogManager;
import com.htec.codingexercise.errorhandler.di.ModuleErrorHandler;
import com.htec.codingexercise.navigation.di.ModuleNavigationController;
import com.htec.codingexercise.network.di.ModuleNetworkManager;
import com.htec.codingexercise.network.http.ModuleHTTPClient;
import com.htec.codingexercise.ui.activity.di.ComponentActivity;
import com.htec.codingexercise.utils.rxutils.ModuleScheduler;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

import static com.htec.codingexercise.network.http.Constants.RETROFIT_API;


/**
 * The component which lifetime is the life of the Application
 */

@Singleton
@Component(modules = {ModuleApp.class, ModuleNetworkManager.class, ModuleScheduler.class, ModuleHTTPClient.class})
public interface ComponentApp {

    @Named(RETROFIT_API)
    Retrofit retrofitGames();

    @Named(RETROFIT_API)
    OkHttpClient okHttpClientGames();

    ComponentActivity get(ModuleErrorHandler moduleErrorHandler, ModuleNavigationController moduleNavigationController, ModuleDialogManager moduleDialogManager);
}
