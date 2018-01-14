package com.htec.codingexercise.error;

import android.app.Activity;
import android.content.Context;

import com.htec.codingexercise.BuildConfig;
import com.htec.codingexercise.network.NetworkManager;
import com.htec.codingexercise.utils.Logger;

public class ErrorHandlerImp implements ErrorHandler {

    private Context context;
    private final NetworkManager networkManager;
//   todo : private final DialogManager dialogManager;

    public ErrorHandlerImp(Context activity, NetworkManager networkManager /*, DialogManager dialogManager*/) {
        this.context = activity;
        this.networkManager = networkManager;
//        this.dialogManager = dialogManager;
    }

    @Override
    public boolean error(Throwable error) {
        if (BuildConfig.DEBUG) {
            Logger.d(ErrorHandlerImp.class, "error:", error);
        }
        if (isAppLive()) {
            if (isNetworkError(error)) {

//                todo : show proper dialog

            } else {
//                todo : show dialog
            }
            return true;
        } else {
            // TODO : handle error without having Activity context !!!
            Logger.e(ErrorHandlerImp.class, "=============>>> ErrorHandler called with non Activity context !!!");
            return false;
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
        if (error instanceof java.net.UnknownHostException && !networkManager.isNetworkAvailable()) {
            return true;
        }
        return false;
    }
}
