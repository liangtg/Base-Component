package com.github.liangtg.base.view;

import android.view.View;

/**
 * Created by liangtg on 17-11-10.
 */

public abstract class RepeatClickListener implements View.OnClickListener {
    long last = 0;
    int click = 0;
    private int count;

    public RepeatClickListener(int count) {
        this.count = count;
    }

    @Override
    public void onClick(View v) {
        long cur = System.currentTimeMillis();
        if (last == 0) {
            last = cur;
        } else if (cur - last <= 300) {
            last = cur;
            click++;
        } else {
            click = 0;
            last = 0;
        }
        if (click >= count) {
            click = 0;
            last = 0;
            onRepeat();
        }
    }

    protected abstract void onRepeat();
}
