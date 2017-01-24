package com.example.josip.nbaworld.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.josip.nbaworld.viewholder.AllTimeScorersViewHolder;
import com.example.josip.nbaworld.R;

/**
 * Created by Josip on 18.1.2017..
 */

public class AllTimeScorersAdapter extends RecyclerView.Adapter<AllTimeScorersViewHolder> {

    private final String[] mData;
    private final Drawable[] mLogos;

    public AllTimeScorersAdapter(Context context) {
        Resources resources = context.getResources();
        mData = resources.getStringArray(R.array.nba_scorers);
        TypedArray a = resources.obtainTypedArray(R.array.nba_scorers_image);
        mLogos = new Drawable[a.length()];
        for (int i = 0; i < mLogos.length; i++) {
            mLogos[i] = a.getDrawable(i);
        }
        a.recycle();
    }

    @Override
    public AllTimeScorersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AllTimeScorersViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(AllTimeScorersViewHolder holder, int position) {
        holder.setImage(mLogos[position]);
        holder.setDataText(mData[position]);
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }
}
