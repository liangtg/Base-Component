package com.liangtg.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.squareup.otto.Bus;

/**
 * Created by liangtg on 15-7-29.
 */
public class BaseActivity<H extends BaseViewHolder> extends AppCompatActivity {

    protected final String TAG = getClass().getSimpleName();

    private H holder;

    private Toast toast;

    private Bus bus = new Bus(getClass().getSimpleName());

    protected void gotoActivity(Class<? extends Activity> cls) {
        Intent i = new Intent(this, cls);
        i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(i);
    }

    protected void setViewHolder(H h) {
        holder = h;
        if (null != holder) {
            setContentView(holder.getContainer());
        }
    }

    protected H getViewHolder() {
        return holder;
    }

    protected Bus getBus() {
        return bus;
    }

    protected Bus getApplicationBus() {
        return ((BaseApplication) getApplication()).getBus();
    }

    protected void showToast(String msg) {
        if (!isFinishing()) {
            if (null == toast) {
                toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
            }
            toast.setText(msg);
            toast.show();
        }
    }

    protected void showToast(int resId) {
        showToast(getString(resId));
    }

    protected boolean isDead() {
        boolean result = isFinishing();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            result |= isDestroyed();
        }
        return result;
    }

}
