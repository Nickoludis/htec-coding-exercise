package com.htec.codingexercise.dialog;

import android.support.annotation.StringRes;

import com.htec.codingexercise.dialog.messaging.DialogActionListener;


public interface DialogManager {

    /**
     * Generates dialog with information regarding lost internet connection and option to go directly into
     * Android WiFi settings.
     *
     * @param leftButtonListener action to be executed on left button press
     * @param rightButtonListener action to be executed on right button press
     */
    void noInternetDialog(DialogActionListener leftButtonListener, DialogActionListener rightButtonListener);

    /**
     * Generates dialog with generic error message.
     *
     * @param errorTitle error name
     * @param errorDescription error description
     * @param buttonListener action to be executed on dialog's button press
     */
    void errorDialog(@StringRes int errorTitle, @StringRes int errorDescription, DialogActionListener buttonListener);
}
