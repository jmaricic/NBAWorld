package com.example.josip.nbaworld.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.josip.nbaworld.R;
import com.example.josip.nbaworld.viewholder.OrganisationsHistoryViewHolder;

/**
 * Created by Josip on 18.1.2017..
 */

public class OrganisationsHistoryAdapter extends RecyclerView.Adapter<OrganisationsHistoryViewHolder> {

    private final Drawable[] mImages;

    public OrganisationsHistoryAdapter(Context context) {
        Resources resources = context.getResources();
        TypedArray a = resources.obtainTypedArray(R.array.nba_logos);
        mImages = new Drawable[a.length()];
        for (int i = 0; i < mImages.length; i++) {
            mImages[i] = a.getDrawable(i);
        }
        a.recycle();
    }

    @Override
    public OrganisationsHistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new OrganisationsHistoryViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(OrganisationsHistoryViewHolder holder, int position) {
        holder.setImage(mImages[position]);
    }

    @Override
    public int getItemCount() {
        return mImages.length;
    }
}
