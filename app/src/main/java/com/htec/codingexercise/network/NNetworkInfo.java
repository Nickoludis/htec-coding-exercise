package com.htec.codingexercise.network;

public class NNetworkInfo {
    private final State state;

    public NNetworkInfo(State state) {
        this.state = state;
    }

    public enum State {
        CONNECTING, CONNECTED, SUSPENDED, DISCONNECTING, DISCONNECTED, UNKNOWN
    }

    public boolean isConnected() {
        return state == State.CONNECTED;
    }

    @Override
    public String toString() {
        return "NNetworkInfo{" +
                "state=" + state +
                '}';
    }
}
