package com.htec.codingexercise.ui.fragment.details;

import com.htec.codingexercise.annotation.PerActivity;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = {ModuleDetails.class})
public interface ComponentDetails {
    void inject(FragmentDetails fragment);
}