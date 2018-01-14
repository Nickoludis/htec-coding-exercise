package com.htec.codingexercise.dialog;

import com.htec.codingexercise.dialog.messaging.DialogActionListener;

public interface DialogManager {

    void noInternetDialog(DialogActionListener leftButtonListener, DialogActionListener rightButtonListener);
}
