package com.htec.codingexercise;

import com.htec.codingexercise.ui.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Singleton
@Module
public class ModuleApp {

    private App application;

    /**
     * @param app Application instance
     */
    public ModuleApp(App app) {
        application = app;
    }

    @Provides
    @Singleton
    App providesApplication() {
        return application;
    }
}
