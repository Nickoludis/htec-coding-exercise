package com.htec.codingexercise.utils;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.htec.codingexercise.dialog.di.ModuleDialogManager;
import com.htec.codingexercise.errorhandler.di.ModuleErrorHandler;
import com.htec.codingexercise.navigation.di.ModuleNavigationController;
import com.htec.codingexercise.ui.activity.MainActivity;
import com.htec.codingexercise.ui.activity.di.ComponentActivity;
import com.htec.codingexercise.ui.fragment.list.FragmentJsonList;
import com.htec.codingexercise.ui.fragment.list.di.ModuleJsonList;

public class InjectorHelper {

    public static ComponentActivity inject(MainActivity activity, @IdRes int layoutId, @NonNull FragmentManager fragmentManager) {
        return DIUtils.getComponentApp(activity)
                .get(new ModuleErrorHandler(activity), new ModuleNavigationController(layoutId, fragmentManager), new ModuleDialogManager(activity));
    }

    public static void inject(MainActivity activity) {
        DIUtils.getComponentActivity(activity)
                .get()
                .inject(activity);
    }

    public static void inject(FragmentJsonList fragment) {
        DIUtils.getComponentActivity(fragment)
                .get(new ModuleJsonList(fragment))
                .inject(fragment);
    }
}
