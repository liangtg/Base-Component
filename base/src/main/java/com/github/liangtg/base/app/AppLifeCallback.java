package com.github.liangtg.base.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

public class AppLifeCallback implements Application.ActivityLifecycleCallbacks {
    protected Callback aCallback;
    protected int aCount = 0;

    public AppLifeCallback(Callback aCallback) {
        this.aCallback = aCallback;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
    }

    @Override
    public void onActivityStarted(Activity activity) {
        aCount++;
        if (aCount == 1) aCallback.onAppStarted(activity);
    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {
        aCount--;
        if (aCount == 0) aCallback.onAppStopped(activity);
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }

    public interface Callback {
        void onAppStarted(Activity activity);

        void onAppStopped(Activity activity);

    }


}
