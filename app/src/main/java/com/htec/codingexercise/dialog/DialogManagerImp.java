package com.htec.codingexercise.dialog;

import android.os.Bundle;
import android.os.Handler;
import android.os.Messenger;
import android.support.annotation.StringRes;

import com.htec.codingexercise.BuildConfig;
import com.htec.codingexercise.R;
import com.htec.codingexercise.animation.AnimationUtils;
import com.htec.codingexercise.dialog.messaging.DialogActionListener;
import com.htec.codingexercise.dialog.messaging.DialogActionListenerLink;
import com.htec.codingexercise.navigation.NavigationController;
import com.htec.codingexercise.ui.widget.CustomButton;
import com.htec.codingexercise.ui.widget.CustomFonts;
import com.htec.codingexercise.utils.ResourceGetter;

import java.util.ArrayList;


public class DialogManagerImp implements DialogManager {

    public static final String DIALOG_DESCRIPTION = BuildConfig.APPLICATION_ID + ".DIALOG_DESCRIPTION";

    private final NavigationController navigationController;
    private ResourceGetter resourceGetter;

    public DialogManagerImp(NavigationController navigationController, ResourceGetter resourceGetter) {
        this.navigationController = navigationController;
        this.resourceGetter = resourceGetter;
    }

    @Override
    public void noInternetDialog(DialogActionListener leftButtonListener, DialogActionListener rightButtonListener) {

        Messenger messengerLeft = null;
        Messenger messengerRight = null;

        if (leftButtonListener != null) {
            messengerLeft = new Messenger(new Handler(new DialogActionListenerLink(leftButtonListener)));
        }
        if (rightButtonListener != null) {
            messengerRight = new Messenger(new Handler(new DialogActionListenerLink(rightButtonListener)));
        }

        DialogText title = new DialogText(resourceGetter.getString(R.string.no_internet_title), R.id.dialog_title, R.color.red, 20, CustomFonts.FONT_STYLE_1);

        ArrayList<DialogText> content = new ArrayList<>();
        content.add(new DialogText(resourceGetter.getString(R.string.no_internet_description), R.id.dialog_description, R.color.gray_dark, 17, CustomFonts.FONT_STYLE_3));

        ArrayList<DialogButton> buttons = new ArrayList<>();
        DialogText settingsButtonText = new DialogText(resourceGetter.getString(R.string.settings), R.id.dialog_button_left);
        DialogButton settingsButton = new DialogButton(settingsButtonText, R.id.dialog_button_left, true, messengerLeft, CustomButton.ButtonColor.SELECTOR_1);
        DialogText tryAgainButtonText = new DialogText(resourceGetter.getString(R.string.okay), R.id.dialog_button_right);
        DialogButton tryAgainButton = new DialogButton(tryAgainButtonText, R.id.dialog_button_right, true, messengerRight);
        buttons.add(settingsButton);
        buttons.add(tryAgainButton);

        show(new DialogDescriptionBuilder()
                .setId(R.layout.dialog_two_btn_one_txt)
                .setButtons(buttons)
                .setContent(content)
                .setTitle(title)
                .createDialogDescription()
        );
    }

    @Override
    public void errorDialog(@StringRes int errorTitle, @StringRes int errorDescription, DialogActionListener buttonListener) {
        Messenger messenger = null;
        if (buttonListener != null) {
            messenger = new Messenger(new Handler(new DialogActionListenerLink(buttonListener)));
        }

        DialogText title = new DialogText(resourceGetter.getString(errorTitle), R.id.dialog_title, R.color.gray_dark, 20, CustomFonts.FONT_STYLE_1);
        ArrayList<DialogText> content = new ArrayList<>();
        content.add(new DialogText(resourceGetter.getString(errorDescription), R.id.dialog_description, -1, 17, CustomFonts.FONT_STYLE_3));

        ArrayList<DialogButton> buttons = new ArrayList<>();
        DialogText textCloseButton = new DialogText((String) resourceGetter.getString(R.string.close), R.id.dialog_button);
        DialogButton close = new DialogButton(textCloseButton, R.id.dialog_button, true, messenger);
        buttons.add(close);

        show(new DialogDescriptionBuilder()
                .setId(R.layout.dialog_one_btn_one_txt)
                .setButtons(buttons)
                .setContent(content)
                .setTitle(title)
                .createDialogDescription()
        );
    }

    public void show(DialogDescription dialogDescription) {

        Bundle arguments = new Bundle();
        arguments.putParcelable(DIALOG_DESCRIPTION, dialogDescription);

        navigationController.loadPage(Dialog.class)
                .addToBackStack(false)
                .isDialog(true)
                .animation(AnimationUtils.Transition.FADE)
                .arguments(arguments)
                .load();
    }
}
