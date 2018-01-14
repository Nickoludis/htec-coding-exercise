package com.htec.codingexercise.ui.activity;


import com.htec.codingexercise.annotation.PerActivity;
import com.htec.codingexercise.error.ErrorHandler;
import com.htec.codingexercise.error.di.ModuleErrorHandler;

import dagger.Subcomponent;


@PerActivity
@Subcomponent(modules = {ModuleErrorHandler.class})
public interface ComponentActivity {

    ErrorHandler errorHandler();

    ComponentMainActivity get(ModuleMainActivity module);
}
