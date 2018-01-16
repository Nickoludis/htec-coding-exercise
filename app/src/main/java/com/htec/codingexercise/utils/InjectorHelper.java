package com.htec.codingexercise.utils;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.htec.codingexercise.dialog.di.ModuleDialogManager;
import com.htec.codingexercise.errorhandler.di.ModuleErrorHandler;
import com.htec.codingexercise.navigation.di.ModuleNavigationController;
import com.htec.codingexercise.ui.activity.MainActivity;
import com.htec.codingexercise.ui.activity.di.ComponentActivity;
import com.htec.codingexercise.ui.fragment.details.FragmentDetails;
import com.htec.codingexercise.ui.fragment.details.ModuleDetails;
import com.htec.codingexercise.ui.fragment.list.FragmentJsonList;
import com.htec.codingexercise.ui.fragment.list.di.ModuleJsonList;
import com.htec.codingexercise.ui.fragment.list.dto.ListElement;

import static com.htec.codingexercise.ui.fragment.Constants.DETAILS;

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

    public static void inject(FragmentDetails fragment) {
        Bundle details = fragment.getArguments();
        ListElement transactionDetails = details.getParcelable(DETAILS);
        DIUtils.getComponentActivity(fragment)
                .get(new ModuleDetails(fragment, transactionDetails))
                .inject(fragment);
    }
}
