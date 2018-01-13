package com.htec.codingexercise.navigation.action;


import android.support.annotation.NonNull;

import com.htec.codingexercise.animation.AnimationUtils;
import com.htec.codingexercise.navigation.NavigationActionBuilder;

/**
 * Interface for navigation action builder. Classes implementing this support definition of an animation in the navigation action
 */
public interface NavigationActionAnimationType {
    /**
     * Set animation type to be executed during fragment transaction.
     *
     * @param animationType type of animation
     * @return next method from builder chain
     */
    NavigationActionBuilder animation(@NonNull AnimationUtils.Transition animationType);
}
