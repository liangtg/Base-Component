package com.liangtg.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by liangtg on 15-7-29.
 */
public class BaseViewHolder {
    private View holder;

    public BaseViewHolder(Context context, int layoutId, ViewGroup container) {
        this(LayoutInflater.from(context).inflate(layoutId, container, false));
    }

    public BaseViewHolder(View view) {
        holder = view;
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T get(int id) {
        return (T) holder.findViewById(id);
    }

    @SuppressWarnings("unchecked")
    public static <T extends View> T get(View view, int id) {
        return (T) view.findViewById(id);
    }

    public View getContainer() {
        return holder;
    }

    public Context getContext() {
        if (null != holder) {
            return holder.getContext();
        }
        return null;
    }

}
