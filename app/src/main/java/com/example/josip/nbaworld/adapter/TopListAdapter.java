package com.example.josip.nbaworld.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.josip.nbaworld.viewholder.TopListViewHolder;

/**
 * Created by Josip on 22.1.2017..
 */

public class TopListAdapter extends RecyclerView.Adapter<TopListViewHolder> {

    private String[] mData;

    public TopListAdapter() {

    }

    public void setData(String[] data) {
        this.mData = data;
    }

    @Override
    public TopListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TopListViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(TopListViewHolder holder, int position) {
        holder.setData(mData[position]);
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }
}
