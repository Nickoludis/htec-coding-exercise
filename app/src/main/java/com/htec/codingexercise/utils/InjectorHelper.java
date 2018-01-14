package com.htec.codingexercise.utils;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.htec.codingexercise.error.di.ModuleErrorHandler;
import com.htec.codingexercise.ui.activity.ComponentActivity;
import com.htec.codingexercise.ui.activity.MainActivity;
import com.htec.codingexercise.ui.activity.ModuleMainActivity;

public class InjectorHelper {

    public static void inject(MainActivity activity, @IdRes int layoutId, @NonNull FragmentManager fragmentManager) {
        DIUtils.getComponentActivity(activity)
                .get(new ModuleMainActivity(layoutId, fragmentManager))
                .inject(activity);
    }

    public static ComponentActivity inject(MainActivity activity) {
        return DIUtils.getComponentApp(activity)
                .get(new ModuleErrorHandler(activity));
    }
}
