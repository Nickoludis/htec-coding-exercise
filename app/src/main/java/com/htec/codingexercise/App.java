package com.htec.codingexercise;

import android.app.Application;

/**
 * Created by Nikola Brankovic - branick2005@gmail.com on 1/12/18.
 */

public class App extends Application {

    private static App app = null;

    @Override
    public void onCreate() {
        super.onCreate();

        app = this;
    }

    /**
     * Get application
     *
     * @return application instance
     */
    public static App get() {
        return app;
    }
}

