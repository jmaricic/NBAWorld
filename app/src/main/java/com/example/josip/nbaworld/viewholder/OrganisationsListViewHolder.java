package com.example.josip.nbaworld.viewholder;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.josip.nbaworld.R;
import com.example.josip.nbaworld.ui.DetailsActivity;

/**
 * Created by Josip on 18.1.2017..
 */

public class OrganisationsListViewHolder extends RecyclerView.ViewHolder {

    private ImageView mImage;
    private TextView mName;
    private TextView mLocation;

    public OrganisationsListViewHolder(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.item_list, parent, false));
        mImage = (ImageView) itemView.findViewById(R.id.logo);
        mName = (TextView) itemView.findViewById(R.id.organisation_name);
        mLocation = (TextView) itemView.findViewById(R.id.organisation_location);
        RelativeLayout row = (RelativeLayout) itemView.findViewById(R.id.row);

        row.setOnClickListener(new View.OnClickListener() {
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

    public void setName(String name) {
        mName.setText(name);
    }

    public void setLocation(String location) {
        mLocation.setText(location);
    }
}
