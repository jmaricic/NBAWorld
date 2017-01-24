package com.example.josip.nbaworld.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.josip.nbaworld.BaseActivity;
import com.example.josip.nbaworld.R;
import com.example.josip.nbaworld.adapter.TopListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Josip on 22.1.2017..
 */

public class TopListActivity extends BaseActivity {

    public static final String ASSIST = "ASSIST";
    public static final String REBOUNDS = "REBOUND";
    public static final String TAG = "Tag";
    public static final String ASSIST_TITLE = "NBA All Time Assist Leaders";
    public static final String REBOUNDS_TITLE = "NBA All Time Rebound Leaders";
    public static final String TRIPLE_DOUBLES_TITLE = "NBA All Time Triple Double Leaders";

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private String[] mData;
    private String mTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.top_list);
        prepareData();
        initUi();
    }

    private void prepareData() {
        if (String.valueOf(ASSIST).equals(getIntent().getExtras().getString(TAG))) {
            mTitle = ASSIST_TITLE;
            mData = getResources().getStringArray(R.array.nba_assists);
        } else if (String.valueOf(REBOUNDS).equals(getIntent().getExtras().getString(TAG))) {
            mTitle = REBOUNDS_TITLE;
            mData = getResources().getStringArray(R.array.nba_rebounds);
        } else {
            mTitle = TRIPLE_DOUBLES_TITLE;
            mData = getResources().getStringArray(R.array.nba_triple_double);
        }
    }

    @Override
    public void initUi() {
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setupActionBar();
        setupAdapter();
    }

    private void setupActionBar() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setTitle(mTitle);
        }
    }

    private void setupAdapter() {
        TopListAdapter adapter = new TopListAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setData(mData);
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
