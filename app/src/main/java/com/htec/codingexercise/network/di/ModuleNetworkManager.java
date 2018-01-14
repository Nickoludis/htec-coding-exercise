package com.htec.codingexercise.network.di;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.htec.codingexercise.network.NetworkManager;
import com.htec.codingexercise.network.NetworkStateReceiver;
import com.htec.codingexercise.network.NetworkStateReceiverListener;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Singleton
@Module
public class ModuleNetworkManager {

    private NetworkStateReceiver networkStateReceiver = null;
    private ConnectivityManager connectivityManager;

    public ModuleNetworkManager(NetworkStateReceiver networkStateReceiver, ConnectivityManager connectivityManager) {
        this.networkStateReceiver = networkStateReceiver;
        this.connectivityManager = connectivityManager;
    }

    @Provides
    @Singleton
    NetworkManager providesNetworkManager() {
        return new NetworkManagerImp();
    }

    private class NetworkManagerImp implements NetworkManager {

        @Override
        public void addListener(NetworkStateReceiverListener l) {
            networkStateReceiver.addListener(l);
        }

        @Override
        public void removeListener(NetworkStateReceiverListener l) {
            networkStateReceiver.removeListener(l);
        }

        @Override
        public boolean isNetworkAvailable() {
            NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
            return activeNetwork != null &&
                    activeNetwork.isConnectedOrConnecting();
        }
    }
}
