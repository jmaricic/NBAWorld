package com.example.josip.nbaworld.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.josip.nbaworld.BaseActivity;
import com.example.josip.nbaworld.R;
import com.example.josip.nbaworld.adapter.MainAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static final String ORGANISATIONS = "Organisations";
    public static final String HISTORY = "History";
    public static final String ALL_TIME_SCORING_LIST = "All Time Scorers";
    public static final String ASSIST = "ASSIST";
    public static final String REBOUNDS = "REBOUND";
    public static final String TRIPLE_DOUBLES = "TRIPLE DOUBLE";
    public static final String TAG = "Tag";

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @BindView(R.id.tabs)
    TabLayout tabs;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @BindView(R.id.drawer)
    DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();
    }

    @Override
    public void initUi() {
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        setupViewPager(viewPager);
        tabs.setupWithViewPager(viewPager);
        setupActionBar();
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void setupViewPager(ViewPager viewPager) {
        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());
        adapter.addFragment(new OrganisationsListFragment(), ORGANISATIONS);
        adapter.addFragment(new OrganisationsHistoryFragment(), HISTORY);
        adapter.addFragment(new AllTimeScorersFragment(), ALL_TIME_SCORING_LIST);
        viewPager.setAdapter(adapter);
    }

    private void setupActionBar() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            VectorDrawableCompat indicator = VectorDrawableCompat.create(getResources(), R.drawable.ic_menu, getTheme());
            if (indicator != null) {
                indicator.setTint(ResourcesCompat.getColor(getResources(), R.color.white, getTheme()));
            }
            supportActionBar.setHomeAsUpIndicator(indicator);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        item.setChecked(true);
        if (item.getItemId() == R.id.assists) {
            startActivity(new Intent(this, TopListActivity.class).putExtra(TAG, ASSIST));
        } else if (item.getItemId() == R.id.rebounds) {
            startActivity(new Intent(this, TopListActivity.class).putExtra(TAG, REBOUNDS));
        } else if (item.getItemId() == R.id.triple_doubles) {
            startActivity(new Intent(this, TopListActivity.class).putExtra(TAG, TRIPLE_DOUBLES));
        }
        mDrawerLayout.closeDrawers();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            mDrawerLayout.openDrawer(navigationView, true);
        }
        return super.onOptionsItemSelected(item);
    }
}
