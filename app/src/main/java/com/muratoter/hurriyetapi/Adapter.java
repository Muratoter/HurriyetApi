package com.muratoter.hurriyetapi;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.toolbox.ImageLoader;

import java.util.Collections;
import java.util.List;

/**
 * Created by Murat on 1.10.2016.
 */

public class Adapter extends RecyclerView.Adapter<SetViewHolder> {
    List<Article> articles= Collections.emptyList();
    private Activity activity;
    public ImageLoader imageLoader;

    public Adapter(Activity activity,List<Article> articles){
        this.activity=activity;
        this.articles=articles;
    }
    @Override
    public SetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);

        return new SetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SetViewHolder holder,final int position) {
        holder.tv_title.setText(articles.get(position).getTitle());
        holder.tv_description.setText(articles.get(position).getDescription());
        holder.tv_url.setText(articles.get(position).getUrl());

        //hyperlink
        holder.tv_url.setMovementMethod(LinkMovementMethod.getInstance());

        imageLoader=CustomVolleyRequest.getInstance(activity.getApplicationContext()).getImageLoader();
        imageLoader.get(articles.get(position).getFileUrl().toString(),ImageLoader.getImageListener(holder.networkImageView,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher));

        holder.networkImageView.setImageUrl(articles.get(position).getFileUrl(),imageLoader);

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }
}
