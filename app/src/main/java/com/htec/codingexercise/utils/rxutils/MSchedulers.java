package com.htec.codingexercise.utils.rxutils;


import rx.Scheduler;


public interface MSchedulers {

    /**
     * Creates and returns a {@link Scheduler} that executes work immediately on the current thread.
     * @return an Scheduler instance
     */
     Scheduler immediate();


    /**
     * Creates and returns a {@link Scheduler} that creates a new {@link Thread} for each unit of work.
     * @return an Scheduler instance
     */
     Scheduler newThread();

    /**
     * Creates and returns a {@link Scheduler} intended for computational work.
     * @return an Scheduler instance
     */
     Scheduler computation();

    /**
     * Creates and returns a {@link Scheduler} intended for IO-bound work.
     * @return a {@link Scheduler} meant for IO-bound work
     */
     Scheduler io();

    /**
     * Creates and returns a {@link Scheduler} intended for work on main thread.
     * @return an Scheduler instance which will work on main thread
     */
    Scheduler mainThread();

    /**
     * Creates and returns a {@link Scheduler} intended for timer.
     * @return an Scheduler instance
     */
    Scheduler timerThread();
}
