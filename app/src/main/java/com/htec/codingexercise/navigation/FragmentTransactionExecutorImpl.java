package com.htec.codingexercise.navigation;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.htec.codingexercise.animation.AnimationUtils;
import com.htec.codingexercise.utils.Logger;

/**
 * Helper class to perform actual fragment navigation transactions
 */
public class FragmentTransactionExecutorImpl implements FragmentTransactionExecutor {

    private FragmentManager fragmentManager;
    private int fragmentContainer;

    public FragmentTransactionExecutorImpl(@IdRes int layoutId, @NonNull FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
        this.fragmentContainer = layoutId;
    }

    /**
     * Executes fragment transaction with provided parameters such as animation type or add to back stack flag.
     *
     * @param action defines additional parameters {@link NavigationAction}
     */
    @Override
    public void executeNavigation(NavigationAction action) {

        if (fragmentManager != null) {

            if (action.fragment.equals(getCurrentFragmentName())) {
                return;
            }

            Fragment mFragment = FragmentFactory.getInstance().instantiateFragment(action.fragment.getCanonicalName(), action.arguments);

            if (mFragment == null) {
                return;
            }

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            // Apply proper transaction animation if there is provided one
            if (action.animationType != null) {
                AnimationUtils.applyFragmentTransactionAnimation(fragmentTransaction, action.animationType);
            }

            if (action.isDialog && mFragment instanceof DialogFragment) {

                DialogFragment df = (DialogFragment) mFragment;
                df.show(fragmentTransaction, action.fragment.getCanonicalName());
                fragmentManager.executePendingTransactions();

            } else {

                if (action.addToBackStack) {
                    fragmentTransaction.addToBackStack(action.fragment.getCanonicalName());
                }

                try {
                    fragmentTransaction.add(fragmentContainer, mFragment, action.fragment.getCanonicalName());
                    fragmentTransaction.commit();
                } catch (IllegalStateException e) {
                    Logger.e(FragmentTransactionExecutor.class, "Error executing navigation", e);
                    throw e;
                }
            }
        }
    }

    /**
     * Clears android's fragments back stack until given fragment name ( including that fragment ).
     *
     * @param fragment
     */
    @Override
    public void clearFragmentManagerBackStack(Class<? extends android.support.v4.app.Fragment> fragment) {
        if (null == fragment || null == fragmentManager) {
            return;
        }
        for (int i = fragmentManager.getBackStackEntryCount() - 1; i > 0; i--) {
            if (fragmentManager.getBackStackEntryAt(i).getName().equals(fragment.getCanonicalName())) {
                fragmentManager.popBackStack();
                return;
            }
            fragmentManager.popBackStack();
        }
    }

    /**
     * Returns the class name of the currently visible fragment.
     *
     * @return fragment name
     */
    @Override
    public String getCurrentFragmentName() {
        return getFragmentName(0);
    }

    /**
     * Handles user back action.
     *
     * @return if there is only one fragment on the stack returns false
     */
    @Override
    public boolean onBackPress() {
        if (fragmentManager.getBackStackEntryCount() == 1) {
            return false;
        }
        return true;
    }

    //***************************************//
    //*********** PRIVATE METHODS ***********//
    //***************************************//

    private String getFragmentName(int position) {
        String fragmentName = "";
        try {
            int backStackEntryCount = fragmentManager.getBackStackEntryCount();
            if (backStackEntryCount != 0) {
                fragmentName = fragmentManager.getBackStackEntryAt(backStackEntryCount - (1 + position)).getName();
            }
        } catch (IndexOutOfBoundsException e) {
            Logger.e(getClass(), "&&& Unable to find fragment &&&", e);
        }
        return fragmentName;
    }
}
