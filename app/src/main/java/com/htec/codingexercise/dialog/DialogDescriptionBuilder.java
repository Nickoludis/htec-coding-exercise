package com.htec.codingexercise.dialog;

import android.app.Dialog;
import android.os.Messenger;

import java.util.ArrayList;

/**
 * Simple builder class which helps during process of data preparation for dialog creation.
 */
public class DialogDescriptionBuilder {
    private boolean cancelable;
    private Messenger onCancelListener;
    private Messenger onDismissListener;
    private int id;
    private DialogText title;
    private String tag = Dialog.class.getCanonicalName();
    private ArrayList<DialogText> content = new ArrayList<>();
    private ArrayList<DialogButton> buttons = new ArrayList<>();

    public DialogDescriptionBuilder setCancelable(boolean cancelable) {
        this.cancelable = cancelable;
        return this;
    }

    public DialogDescriptionBuilder setOnCancelListener(Messenger onCancelListener) {
        this.onCancelListener = onCancelListener;
        return this;
    }

    public DialogDescriptionBuilder setOnDismissListener(Messenger onDismissListener) {
        this.onDismissListener = onDismissListener;
        return this;
    }

    public DialogDescriptionBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public DialogDescriptionBuilder setTitle(DialogText title) {
        this.title = title;
        return this;
    }

    public DialogDescriptionBuilder setContent(ArrayList<DialogText> content) {
        this.content = content;
        return this;
    }

    public DialogDescriptionBuilder setButtons(ArrayList<DialogButton> buttons) {
        this.buttons = buttons;
        return this;
    }

    public DialogDescriptionBuilder setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public DialogDescription createDialogDescription() {
        return new DialogDescription(cancelable, onCancelListener, onDismissListener, id, title, content, buttons, tag);
    }
}