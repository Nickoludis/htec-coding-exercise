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

    private static FragmentFactory ourInstance = new FragmentFactory();

    public static FragmentFactory getInstance() {
        return ourInstance;
    }

    /**
     * Instantiates fragment for the provided class name.
     *
     * @param fragment  Fragment class name
     * @param arguments Optional fragment arguments
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
