package com.example.josip.nbaworld.viewholder;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.josip.nbaworld.R;
import com.example.josip.nbaworld.ui.DetailsActivity;

/**
 * Created by Josip on 18.1.2017..
 */

public class OrganisationsHistoryViewHolder extends RecyclerView.ViewHolder {

    private ImageView mImage;

    public OrganisationsHistoryViewHolder(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.item_tile, parent, false));
        mImage = (ImageView) itemView.findViewById(R.id.logo);

        mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra(DetailsActivity.EXTRA_POSITION, getAdapterPosition());
                context.startActivity(intent);
            }
        });
    }

    public void setImage(Drawable drawable) {
        mImage.setImageDrawable(drawable);
    }
}
