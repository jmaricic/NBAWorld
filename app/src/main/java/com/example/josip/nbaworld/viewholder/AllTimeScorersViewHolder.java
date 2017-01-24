package com.example.josip.nbaworld.viewholder;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.josip.nbaworld.R;
import com.example.josip.nbaworld.ui.DetailsActivity;
import com.example.josip.nbaworld.ui.PlayerProfileActivity;

/**
 * Created by Josip on 18.1.2017..
 */

public class AllTimeScorersViewHolder extends RecyclerView.ViewHolder {

    private ImageView mImage;
    private TextView mData;

    public AllTimeScorersViewHolder(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.item_card, parent, false));
        mImage = (ImageView) itemView.findViewById(R.id.player_image);
        mData = (TextView) itemView.findViewById(R.id.player_data);
        Button seeMore = (Button) itemView.findViewById(R.id.button_see_stats);

        seeMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, PlayerProfileActivity.class);
                intent.putExtra(DetailsActivity.EXTRA_POSITION, getAdapterPosition());
                context.startActivity(intent);
            }
        });
    }

    public void setImage(Drawable drawable) {
        mImage.setImageDrawable(drawable);
    }

    public void setDataText(String text) {
        mData.setText(text);
    }
}
