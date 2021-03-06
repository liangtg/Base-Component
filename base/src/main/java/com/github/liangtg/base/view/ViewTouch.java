package com.github.liangtg.base.view;

import android.view.MotionEvent;
import android.view.View;

/**
 * Created by liangtg on 16-4-9.
 */
public class ViewTouch {
    public static void tap(View view) {
        MotionEvent motionEvent = MotionEvent.obtain(System.currentTimeMillis() - 100, System.currentTimeMillis(), MotionEvent.ACTION_DOWN, 0, 0, 0);
        view.onTouchEvent(motionEvent);
        motionEvent.setAction(MotionEvent.ACTION_UP);
        view.onTouchEvent(motionEvent);
        motionEvent.recycle();
    }
}
