package com.liangtg.base;

import android.app.Application;

import com.squareup.otto.Bus;

/**
 * Created by liangtg on 15-7-29.
 */
public class BaseApplication extends Application {

    private Bus bus = new Bus(getClass().getSimpleName());

    public Bus getBus() {
        return bus;
    }
}
