package com.htec.codingexercise.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.htec.codingexercise.dialog.messaging.DialogActionListener;
import com.htec.codingexercise.ui.widget.CustomButton;
import com.htec.codingexercise.ui.widget.CustomFontTextView;
import com.htec.codingexercise.utils.Logger;

public class Dialog extends DialogFragment {

    DialogDescription dialogDescription;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialogDescription = getArguments().getParcelable(DialogManagerImp.DIALOG_DESCRIPTION);
        setCancelable(dialogDescription.cancelable);
    }

    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        android.app.Dialog dialog = super.onCreateDialog(savedInstanceState);
        // On older Android versions there is empty header inserted into dialogDescription's layout. This is the way to avoid that, hopefully :)
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(dialogDescription.id, container, false);
        setTitle(rootView);
        setButtons(rootView);
        setContent(rootView);
        return rootView;
    }

    private void setTitle(ViewGroup rootView) {
        setDialogText(dialogDescription.title, rootView);
    }

    private void setButtons(ViewGroup rootView) {
        for (final DialogButton dialogButton : dialogDescription.buttons) {
            if (dialogButton.id != -1) {
                CustomButton button = (CustomButton) rootView.findViewById(dialogButton.id);
                button.setVisibility(View.VISIBLE);

                if (dialogButton.text != null && !TextUtils.isEmpty(dialogButton.text.text)) {
                    button.setText(dialogButton.text.text);
                }
                if (dialogButton.text.fontColor != -1) {
                    button.setTextColor(getActivity().getResources().getColor(dialogButton.text.fontColor));
                }
                if (dialogButton.text.fontSize != -1) {
                    button.setTextSize(TypedValue.COMPLEX_UNIT_SP, dialogButton.text.fontSize);
                }
                if (dialogButton.text.fontFamily != null) {
                    button.setFont(dialogButton.text.fontFamily.ordinal());
                }
                if (dialogButton.background != -1) {
                    button.setButtonBackground(CustomButton.ButtonColor.fromId(dialogButton.background));
                }
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (dialogButton.onClickListener != null) {
                            Dialog.this.sendAction(dialogButton.onClickListener);
                        }
                        if (dialogButton.dismiss) {
                            Dialog.this.dismiss();
                        }
                    }
                });
            }
        }
    }

    private void setContent(ViewGroup rootView) {
        for (DialogText dialogText : dialogDescription.content) {
            setDialogText(dialogText, rootView);
        }
    }

    private void setDialogText(final DialogText dialogText, ViewGroup rootView) {
        if (dialogText == null) {
            Logger.d(Dialog.class, "dialogText NULL");
            return;
        }
        if (dialogText.id == -1) {
            Logger.d(Dialog.class, "dialogText id not set");
            return;
        }
        CustomFontTextView textView = (CustomFontTextView) rootView.findViewById(dialogText.id);
        textView.setVisibility(View.VISIBLE);
        if (dialogText.text != null && !TextUtils.isEmpty(dialogText.text)) {
            textView.setText(dialogText.text);
        }
        if (dialogText.fontColor != -1) {
            textView.setTextColor(getActivity().getResources().getColor(dialogText.fontColor));
        }
        if (dialogText.fontSize != -1) {
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, dialogText.fontSize);
        }
        if (dialogText.onClickListener != null || dialogText.dismiss) {
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (dialogText.onClickListener != null) {
                        Dialog.this.sendAction(dialogText.onClickListener);
                    }
                    if (dialogText.dismiss) {
                        Dialog.this.dismiss();
                    }
                }
            });
        }

        textView.setFont(dialogText.fontFamily.ordinal());
    }

    @Override
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        if (dialogDescription.onCancelListener != null) {
            sendAction(dialogDescription.onCancelListener);
        }
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (dialogDescription.onDismissListener != null) {
            sendAction(dialogDescription.onDismissListener);
        }
    }

    @Override
    public void onResume() {
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setAttributes((WindowManager.LayoutParams) params);
        super.onResume();
    }

    private void sendAction(Messenger messenger) {
        Message m = new Message();
        m.what = DialogActionListener.ACTION;
        try {
            messenger.send(m);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
