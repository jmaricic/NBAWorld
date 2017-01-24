package com.example.josip.nbaworld.ui;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.josip.nbaworld.BaseActivity;
import com.example.josip.nbaworld.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.josip.nbaworld.ui.DetailsActivity.EXTRA_POSITION;

/**
 * Created by Josip on 20.1.2017..
 */

public class PlayerProfileActivity extends BaseActivity {

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.player_image)
    ImageView playerImage;

    @BindView(R.id.player_stats)
    TextView playerStats;

    @BindView(R.id.player_position)
    TextView playerPosition;

    @BindView(R.id.player_teams)
    TextView playerTeams;

    @BindView(R.id.player_draft)
    TextView playerDraft;

    private int position;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_player);
        position = getIntent().getIntExtra(EXTRA_POSITION, 0);
        initUi();
    }

    @Override
    public void initUi() {
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setupActionBar();
        setToolbarTitle();
        setPlayerStats();
        setPlayerPosition();
        setTeams();
        setPlayerDraftHistory();
        setPlayerImage();
    }

    private void setupActionBar() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setToolbarTitle() {
        String[] names = getResources().getStringArray(R.array.nba_scorers);
        collapsingToolbar.setTitle(names[position]);
    }


    private void setPlayerStats() {
        String[] stats = getResources().getStringArray(R.array.nba_player_stats);
        playerStats.setText(stats[position]);
    }

    private void setPlayerPosition() {
        String[] positions = getResources().getStringArray(R.array.nba_player_position);
        playerPosition.setText(positions[position]);
    }

    private void setTeams() {
        String[] teams = getResources().getStringArray(R.array.nba_player_teams);
        playerTeams.setText(teams[position]);
    }

    private void setPlayerDraftHistory() {
        String[] draft = getResources().getStringArray(R.array.nba_players_draft);
        playerDraft.setText(draft[position]);
    }

    private void setPlayerImage() {
        TypedArray placePictures = getResources().obtainTypedArray(R.array.nba_scorers_image);
        playerImage.setImageDrawable(placePictures.getDrawable(position));

        placePictures.recycle();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
