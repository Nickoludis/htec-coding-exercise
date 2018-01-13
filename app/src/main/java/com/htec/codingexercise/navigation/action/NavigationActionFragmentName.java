package com.htec.codingexercise.navigation.action;

import android.support.v4.app.Fragment;

/**
 * Classes implementing this interface allow to navigate to a fragment by passing its class name
 */
public interface NavigationActionFragmentName {

    NavigationActionAddToBackStack fragment(Class<? extends Fragment> fragment);
}
