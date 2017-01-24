package com.example.josip.nbaworld.ui;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.josip.nbaworld.BaseActivity;
import com.example.josip.nbaworld.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Josip on 19.1.2017..
 */

public class DetailsActivity extends BaseActivity {

    public static final String EXTRA_POSITION = "position";

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;

    @BindView(R.id.arena_name)
    TextView arenaName;

    @BindView(R.id.location)
    TextView location;

    @BindView(R.id.championships_number)
    TextView championships;

    @BindView(R.id.conference_titles)
    TextView conferenceTitles;

    @BindView(R.id.image)
    ImageView logo;

    private int position;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        position = getIntent().getIntExtra(EXTRA_POSITION, 0);
        initUi();
        setToolbarTitle();
        setLocation();
        setArenaName();
        setChampionships();
        setConferenceTitles();
        setLogo();
    }

    @Override
    public void initUi() {
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        setupToolbar();

        collapsingToolbar.setTitle(getString(R.string.item_title));
    }

    private void setupToolbar() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setToolbarTitle() {
        String[] names = getResources().getStringArray(R.array.nba_names);
        collapsingToolbar.setTitle(names[position]);
    }

    private void setLocation() {
        String[] locations = getResources().getStringArray(R.array.nba_team_location);
        location.setText(locations[position]);
    }

    private void setArenaName() {
        String[] arenas = getResources().getStringArray(R.array.nba_arenas);
        arenaName.setText(arenas[position]);
    }

    private void setChampionships() {
        String[] champ = getResources().getStringArray(R.array.nba_championships);
        championships.setText(champ[position]);
    }

    private void setConferenceTitles() {
        String[] conf = getResources().getStringArray(R.array.nba_conference_titles);
        conferenceTitles.setText(conf[position]);
    }

    private void setLogo() {
        TypedArray placePictures = getResources().obtainTypedArray(R.array.nba_logos);
        logo.setImageDrawable(placePictures.getDrawable(position));

        placePictures.recycle();
    }

    @Override
    protected void onResume() {
        super.onResume();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        float mScreenHeight = displaymetrics.heightPixels;

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        logo.startAnimation(animation);
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
