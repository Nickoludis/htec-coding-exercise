package com.htec.codingexercise.utils.rxutils;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MSchedulersImp implements MSchedulers {
    /**
     * Creates and returns a {@link Scheduler} that executes work immediately on the current thread.
     *
     * @return an Scheduler instance
     */
    @Override
    public Scheduler immediate() {
        return Schedulers.immediate();
    }

    /**
     * Creates and returns a {@link Scheduler} that creates a new {@link Thread} for each unit of work.
     *
     * @return an Scheduler instance
     */
    @Override
    public Scheduler newThread() {
        return Schedulers.newThread();
    }

    /**
     * Creates and returns a {@link Scheduler} intended for computational work.
     *
     * @return an Scheduler instance
     */
    @Override
    public Scheduler computation() {
        return Schedulers.computation();
    }

    /**
     * Creates and returns a {@link Scheduler} intended for IO-bound work.
     *
     * @return a {@link Scheduler} meant for IO-bound work
     */
    @Override
    public Scheduler io() {
        return Schedulers.io();
    }

    /**
     * Creates and returns a {@link Scheduler} that executes work immediately on the main Android thread.
     *
     * @return an Scheduler instance which will work on main thread
     */
    @Override
    public Scheduler mainThread() {
        return AndroidSchedulers.mainThread();
    }

    /**
     * Creates and returns a {@link Scheduler} intended for timer.
     *
     * @return an Scheduler instance
     */
    @Override
    public Scheduler timerThread() {
        return Schedulers.newThread();
    }
}
