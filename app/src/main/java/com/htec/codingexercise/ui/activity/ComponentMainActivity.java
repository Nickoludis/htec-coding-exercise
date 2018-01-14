package com.htec.codingexercise.ui.activity;

import com.htec.codingexercise.annotation.PerActivity;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = {ModuleMainActivity.class})
public interface ComponentMainActivity {

    void inject(MainActivity mainActivity);
}
