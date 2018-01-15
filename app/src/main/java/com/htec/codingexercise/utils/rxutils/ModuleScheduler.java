package com.htec.codingexercise.utils.rxutils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ModuleScheduler {

    @Singleton
    @Provides
    public MSchedulers provideErrorHandler() {
        return new MSchedulersImp();
    }
}
