package com.example.josip.nbaworld.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.josip.nbaworld.viewholder.OrganisationsListViewHolder;
import com.example.josip.nbaworld.R;

/**
 * Created by Josip on 18.1.2017..
 */

public class OrganisationsListAdapter extends RecyclerView.Adapter<OrganisationsListViewHolder> {

    private final String[] mName;
    private final String[] mLocation;
    private final Drawable[] mImages;

    public OrganisationsListAdapter(Context context) {
        Resources resources = context.getResources();
        mName = resources.getStringArray(R.array.nba_names);
        mLocation = resources.getStringArray(R.array.nba_team_location);
        TypedArray typedArray = resources.obtainTypedArray(R.array.nba_logos);
        mImages = new Drawable[typedArray.length()];
        for (int i = 0; i < mImages.length; i++) {
            mImages[i] = typedArray.getDrawable(i);
        }
        typedArray.recycle();
    }

    @Override
    public OrganisationsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new OrganisationsListViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(OrganisationsListViewHolder holder, int position) {
        holder.setImage(mImages[position]);
        holder.setName(mName[position]);
        holder.setLocation(mLocation[position]);
    }

    @Override
    public int getItemCount() {
        return mName.length;
    }
}
