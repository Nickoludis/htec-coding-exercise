package com.htec.codingexercise.utils;

import android.app.Activity;

import com.htec.codingexercise.ComponentApp;
import com.htec.codingexercise.ComponentProvider;
import com.htec.codingexercise.ui.activity.di.ComponentActivity;

public class DIUtils {

    public static ComponentActivity getComponentActivity(android.support.v4.app.Fragment fragment) {
        ComponentProvider componentProvider = (ComponentProvider) fragment.getActivity();
        return componentProvider.component(ComponentActivity.class);
    }

    public static ComponentActivity getComponentActivity(Activity activity) {
        ComponentProvider componentProvider = (ComponentProvider) activity;
        return componentProvider.component(ComponentActivity.class);
    }

    public static ComponentApp getComponentApp(Activity activity) {
        ComponentProvider componentProvider = (ComponentProvider) activity;
        return componentProvider.component(ComponentApp.class);
    }
}
