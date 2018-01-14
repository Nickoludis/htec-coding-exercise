package com.htec.codingexercise.dialog.messaging;

import android.os.Handler;
import android.os.Message;

import com.htec.codingexercise.utils.Logger;


public class DialogActionListenerLink implements Handler.Callback {

    public static final String WTF = "!!!!!something went wrong!!!!";

    private final DialogActionListener callback;

    public DialogActionListenerLink(DialogActionListener callback) {
        this.callback = callback;
    }

    @Override
    public boolean handleMessage(Message msg) {
        if (msg.what == DialogActionListener.ACTION) {
            if (callback != null) {
                callback.onClick();
            } else {
                Logger.d(DialogActionListenerLink.class, "************** WeakReference RELEASED **************");
            }
        } else {
            throw new RuntimeException(WTF);
        }
        return true;
    }

}
