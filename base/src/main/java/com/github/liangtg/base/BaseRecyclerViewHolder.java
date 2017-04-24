package com.github.liangtg.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by liangtg on 17-3-17.
 */

public abstract class BaseRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public BaseRecyclerViewHolder(View itemView) {
        super(itemView);
    }

    @SuppressWarnings("unchecked")
    public static <T extends View> T get(View view, int id) {
        return (T) view.findViewById(id);
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T get(int id) {
        return (T) itemView.findViewById(id);
    }

    public Context getContext() {
        if (null != itemView) {
            return itemView.getContext();
        }
        return null;
    }

    @Override
    public void onClick(View v) {
        onClick(v, v.getId());
    }

    protected void onClick(View v, int id) {
    }

}
