package com.htec.codingexercise.utils.rxutils;

import rx.Subscription;

/**
 * Wrapper class around {@link Subscription}
 */
public class TaskImp implements Task {

    private final Subscription subscription;

    public TaskImp(Subscription subscription) {
        this.subscription = subscription;
    }

    @Override
    public void end() {
        subscription.unsubscribe();
    }

    @Override
    public boolean isEnded() {
        return subscription.isUnsubscribed();
    }
}
