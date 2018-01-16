package com.htec.codingexercise.errorhandler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;

import com.htec.codingexercise.BuildConfig;
import com.htec.codingexercise.R;
import com.htec.codingexercise.dialog.DialogManager;
import com.htec.codingexercise.dialog.messaging.DialogActionListener;
import com.htec.codingexercise.network.NetworkManager;
import com.htec.codingexercise.utils.Logger;

/**
 * ErrorHandler implementation which handles all provided exceptions.
 */
public class ErrorHandlerImp implements ErrorHandler {

    private Context context;
    private final NetworkManager networkManager;
    private final DialogManager dialogManager;

    public ErrorHandlerImp(Context activity, NetworkManager networkManager, DialogManager dialogManager) {
        this.context = activity;
        this.networkManager = networkManager;
        this.dialogManager = dialogManager;
    }

    /**
     * In case of network error ( e.g. no internet connection ) presents proper dialog. In other cases
     * if passed error isn't handled already it shows generic error dialog.
     *
     * @param error Throwable instance
     */
    @Override
    public void error(Throwable error) {
        if (BuildConfig.DEBUG) {
            Logger.d(ErrorHandlerImp.class, "error:", error);
        }
        if (isAppLive()) {
            if (isNetworkError(error)) {
                DialogActionListener settingsListener = () -> context.startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                dialogManager.noInternetDialog(settingsListener, null);
            } else {
                dialogManager.errorDialog(R.string.error_message, R.string.something_went_wrong_error, null);
            }

            // TODO : Handle other kinds of exceptions.
        }
    }

    private boolean isAppLive() {
        if (context instanceof Activity) {
            if (!((Activity) context).isFinishing()) {
                return true;
            }
        }
        return false;
    }

    private boolean isNetworkError(Throwable error) {
        if ((error instanceof java.net.UnknownHostException || error instanceof java.net.ConnectException) &&
                !networkManager.isNetworkAvailable()) {
            return true;
        }
        return false;
    }
}
