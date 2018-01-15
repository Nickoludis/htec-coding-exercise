package com.htec.codingexercise.utils.rxutils;

import com.htec.codingexercise.errorhandler.ErrorHandler;

import rx.Subscriber;

public class DefaultSubscriber<T> extends Subscriber<T> {

    private final PresenterCallbackErrorHandler presenterCallbackErrorHandler;
    private final PresenterCallbackOnResult presenterCallbackOnResult;
    private final PresenterCallbackOnCompleted presenterCallbackOnCompleted;
    private final ErrorHandler errorHandler;

    public DefaultSubscriber(PresenterCallbackOnResult<T> presenterCallbackOnResult, ErrorHandler errorHandler) {

        PresenterCallbackOnCompleted presenterCallbackOnCompleted = null;

        if (presenterCallbackOnResult instanceof PresenterCallbackOnCompleted) {
            presenterCallbackOnCompleted = (PresenterCallbackOnCompleted) presenterCallbackOnResult;
        }

        PresenterCallbackErrorHandler presenterCallbackErrorHandler = null;

        if (presenterCallbackOnResult instanceof PresenterCallbackErrorHandler) {
            presenterCallbackErrorHandler = (PresenterCallbackErrorHandler) presenterCallbackOnResult;
        }

        this.presenterCallbackErrorHandler = presenterCallbackErrorHandler;
        this.presenterCallbackOnResult = presenterCallbackOnResult;
        this.presenterCallbackOnCompleted = presenterCallbackOnCompleted;
        this.errorHandler = errorHandler;
    }

    /**
     * Notifies the Observer that the {@link rx.Observable} has finished sending push-based notifications.
     * <p>
     * The {@link rx.Observable} will not call this method if it calls {@link #onError}.
     */
    @Override
    public void onCompleted() {
        if (presenterCallbackOnCompleted != null) {
            presenterCallbackOnCompleted.onCompleted();
        }
    }

    /**
     * Notifies the Observer that the {@link rx.Observable} has experienced an error condition.
     * <p>
     * If the {@link rx.Observable} calls this method, it will not thereafter call {@link #onNext} or
     * {@link #onCompleted}.
     *
     * @param e the exception encountered by the Observable
     */
    @Override
    public void onError(Throwable e) {
        if (presenterCallbackErrorHandler != null) {
            if (!presenterCallbackErrorHandler.onError(e)) {
                errorHandler.error(e);
            }
        } else {
            errorHandler.error(e);
        }
    }

    /**
     * Provides the Observer with a new item to observe.
     * <p>
     * The {@link rx.Observable} may call this method 0 or more times.
     * <p>
     * The {@code Observable} will not call this method again after it calls either {@link #onCompleted} or
     * {@link #onError}.
     *
     * @param t the item emitted by the Observable
     */
    @Override
    public void onNext(T t) {
        presenterCallbackOnResult.onResult(t);
    }
}
