package com.example.josip.nbaworld.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.josip.nbaworld.R;

/**
 * Created by Josip on 22.1.2017..
 */

public class TopListViewHolder extends RecyclerView.ViewHolder {

    private TextView mData;

    public TopListViewHolder(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.activity_top_list, parent, false));
        mData = (TextView) itemView.findViewById(R.id.organisation_name);
    }

    public void setData(String data) {
        mData.setText(data);
    }
}
