package com.htec.codingexercise.ui.fragment.list.di;

import com.htec.codingexercise.annotation.PerActivity;
import com.htec.codingexercise.ui.fragment.list.FragmentJsonList;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = {ModuleJsonList.class})
public interface ComponentJsonList {
    void inject(FragmentJsonList fragment);
}