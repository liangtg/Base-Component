package com.github.liangtg.base.util;


import android.os.Handler;
import android.os.Looper;

import com.squareup.otto.Bus;

/**
 * Created by liangtg on 17-10-26.
 */

public class BusUtils {
    private BusUtils() {
    }

    public static void postOnUiThread(final Bus bus, final Object object) {
        Wrapper.handler.post(new Runnable() {
            @Override
            public void run() {
                bus.post(object);
            }
        });
    }

    private static class Wrapper {
        private static Handler handler = new Handler(Looper.getMainLooper());
    }


}
