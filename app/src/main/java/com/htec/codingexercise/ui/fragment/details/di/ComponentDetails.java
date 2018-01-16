package com.htec.codingexercise.ui.fragment.details.di;

import com.htec.codingexercise.annotation.PerActivity;
import com.htec.codingexercise.ui.fragment.details.FragmentDetails;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = {ModuleDetails.class})
public interface ComponentDetails {
    void inject(FragmentDetails fragment);
}