package com.htec.codingexercise;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

import com.htec.codingexercise.network.di.ModuleNetworkManager;
import com.htec.codingexercise.network.NetworkStateReceiver;

public class App extends Application implements ComponentProvider {

    private static App app = null;

    private ComponentApp componentApp = null;
    private NetworkStateReceiver networkStateReceiver = new NetworkStateReceiver();

    @Override
    public void onCreate() {
        super.onCreate();

        app = this;

        // Initialize connectivity manager
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkStateReceiver, intentFilter);

        componentApp = DaggerComponentApp.builder()
                .moduleApp(new ModuleApp(this))
                .moduleNetworkManager(new ModuleNetworkManager(networkStateReceiver, connectivityManager))
                .build();
    }

    /**
     * Get application
     *
     * @return application instance
     */
    public static App get() {
        return app;
    }

    @Override
    public <T> T component(Class<T> type) {
        if (ComponentApp.class == type) {
            return (T) componentApp;
        }
        throw new RuntimeException("Unsupported component type :" + type.getSimpleName());
    }
}

