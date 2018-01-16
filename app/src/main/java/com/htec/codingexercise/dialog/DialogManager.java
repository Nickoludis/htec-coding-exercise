package com.htec.codingexercise.dialog;

import android.support.annotation.StringRes;

import com.htec.codingexercise.dialog.messaging.DialogActionListener;

public interface DialogManager {

    void noInternetDialog(DialogActionListener leftButtonListener, DialogActionListener rightButtonListener);

    void errorDialog(@StringRes int errorTitle, @StringRes int errorDescription, DialogActionListener buttonListener);
}
