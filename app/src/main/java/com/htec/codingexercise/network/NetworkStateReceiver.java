package com.htec.codingexercise.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.htec.codingexercise.utils.Logger;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Receiver which notifies subscribed interested parties regarding occurred network event.
 */
public class NetworkStateReceiver extends BroadcastReceiver {

    protected List<WeakReference<NetworkStateReceiverListener>> listeners = new ArrayList();

    public NetworkStateReceiver() {

    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null || intent.getExtras() == null) {
            return;
        }

        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = manager.getActiveNetworkInfo();
        notifyStateToAll(new NNetworkInfo(to(ni)));
    }

    /**
     * Notifies all subscribed listeners about network event.
     */
    private void notifyStateToAll(NNetworkInfo info) {
        for (WeakReference<NetworkStateReceiverListener> listener : listeners) {
            NetworkStateReceiverListener ll = listener.get();
            if (ll != null) {
                ll.onNetworkStateChange(info);
            }
        }
        Logger.d(NetworkStateReceiver.class, "notifyStateToAll: " + info);
        trim();
    }

    private NNetworkInfo.State to(NetworkInfo ni) {
        if (ni == null) {
            return NNetworkInfo.State.UNKNOWN;
        }
        switch (ni.getState()) {
            case CONNECTED:
                return NNetworkInfo.State.CONNECTED;
            case CONNECTING:
                return NNetworkInfo.State.CONNECTING;
            case DISCONNECTED:
                return NNetworkInfo.State.DISCONNECTED;
            case DISCONNECTING:
                return NNetworkInfo.State.DISCONNECTING;
            case SUSPENDED:
                return NNetworkInfo.State.SUSPENDED;
            case UNKNOWN:
            default:
                return NNetworkInfo.State.UNKNOWN;
        }
    }

    public void addListener(NetworkStateReceiverListener l) {
        listeners.add(new WeakReference<>(l));
    }

    public void removeListener(NetworkStateReceiverListener l) {
        ArrayList<WeakReference<NetworkStateReceiverListener>> remove = new ArrayList<>();
        for (WeakReference<NetworkStateReceiverListener> listener : listeners) {
            NetworkStateReceiverListener ll = listener.get();
            if (ll == l) {
                remove.add(listener);
            }
        }
        listeners.removeAll(remove);
    }

    private void trim() {
        ArrayList<WeakReference<NetworkStateReceiverListener>> remove = new ArrayList<>();
        for (WeakReference<NetworkStateReceiverListener> listener : listeners) {
            NetworkStateReceiverListener ll = listener.get();
            if (ll == null) {
                remove.add(listener);
            }
        }
        listeners.removeAll(remove);
    }
}
