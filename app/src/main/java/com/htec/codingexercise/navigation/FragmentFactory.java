package com.htec.codingexercise.navigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.htec.codingexercise.utils.Logger;

import static java.lang.Class.forName;


/**
 * Class that instantiate Fragments
 */
public class FragmentFactory {

    private static final String TAG = "FragmentFactory";
    private static FragmentFactory ourInstance = new FragmentFactory();

    public static FragmentFactory getInstance() {
        return ourInstance;
    }

    private FragmentFactory() {
    }

    /**
     * Instantiates fragment for the provided class name.
     *
     * @param fragment  Class name
     * @param arguments Optional additional fragment arguments
     * @return Fragment instance
     */
    public Fragment instantiateFragment(String fragment, @Nullable Bundle arguments) {
        try {
            Fragment f = (Fragment) forName(fragment).newInstance();
            if (arguments != null) {
                f.setArguments(arguments);
            }
            return f;
        } catch (Exception e) {
            Logger.e(getClass(), "Error creating fragment:", e);
        }
        return null;
    }
}
