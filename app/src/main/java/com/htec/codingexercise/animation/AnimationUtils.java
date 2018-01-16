package com.htec.codingexercise.animation;

import android.support.v4.app.FragmentTransaction;

import com.htec.codingexercise.R;

/**
 * Provides utils methods for fragment animations
 */

public class AnimationUtils {

    /**
     * Supported animation types
     */
    public enum Transition {
        /**
         * No animation
         */
        NONE,
        /**
         * Forward animation
         */
        LEFT_TO_RIGHT,
        /**
         * Back animation
         */
        RIGHT_TO_LEFT,
        /**
         * Simple fade in animation
         */
        FADE,
    }

    /**
     * Add transaction animation while changing fragments.
     *
     * @param transaction    FragmentTransaction
     * @param transitionType Animation type {@link Transition }
     * @return
     */
    public static FragmentTransaction applyFragmentTransactionAnimation(FragmentTransaction transaction, Transition transitionType) {

        switch (transitionType) {

            case RIGHT_TO_LEFT:
                transaction.setCustomAnimations(R.anim.slide_left_enter,
                        R.anim.slide_left_exit,
                        R.anim.slide_right_enter,
                        R.anim.slide_right_exit);
                break;

            case LEFT_TO_RIGHT:
                transaction.setCustomAnimations(R.anim.slide_right_enter,
                        R.anim.slide_right_exit,
                        R.anim.slide_left_enter,
                        R.anim.slide_left_exit);
                break;

            case FADE:
                transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
                break;

            case NONE:
                //return transaction;
        }

        return transaction;
    }
}
