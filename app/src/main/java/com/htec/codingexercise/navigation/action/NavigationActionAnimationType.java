package com.htec.codingexercise.navigation.action;


import android.support.annotation.NonNull;

import com.htec.codingexercise.animation.AnimationUtils;
import com.htec.codingexercise.navigation.NavigationActionBuilder;

/**
 * Represents parameter in fragment transaction operation.
 */
public interface NavigationActionAnimationType {

    /**
     * Set animation type to be executed during fragment transaction.
     *
     * @param animationType type of animation
     * @return NavigationActionBuilder instance
     */
    NavigationActionBuilder animation(@NonNull AnimationUtils.Transition animationType);
}
