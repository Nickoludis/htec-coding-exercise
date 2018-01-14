package com.htec.codingexercise.network;

public interface NetworkManager {

    void addListener(NetworkStateReceiverListener l);

    void removeListener(NetworkStateReceiverListener l);

    boolean isNetworkAvailable();
}
