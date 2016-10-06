package com.muratoter.hurriyetapi;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

/**
 * Created by Murat on 1.10.2016.
 */

public class SetViewHolder extends RecyclerView.ViewHolder {
    public TextView tv_title,tv_description,tv_url;
    public NetworkImageView networkImageView;

    public SetViewHolder(View itemView) {
        super(itemView);
        tv_title=(TextView)itemView.findViewById(R.id.tv_title);
        tv_description=(TextView)itemView.findViewById(R.id.tv_description);
        tv_url=(TextView)itemView.findViewById(R.id.tv_url);
        networkImageView=(NetworkImageView)itemView.findViewById(R.id.Picture);
    }
}
