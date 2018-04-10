package com.example.ghostl.proyectocibertec.views.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.example.ghostl.proyectocibertec.R;
import com.example.ghostl.proyectocibertec.views.adapters.PrincipalAdapter;
import com.example.ghostl.proyectocibertec.views.fragments.EventsFragment;
import com.example.ghostl.proyectocibertec.views.fragments.PrincipalFragment;
import com.example.ghostl.proyectocibertec.views.fragments.ProfileSettingsFragment;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    RecyclerView mRecyclerView;
    PrincipalAdapter mPrincipalAdapter;

    DrawerLayout mDrawer;
    Toolbar mToolbar;
    NavigationView mNavView;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        initObjectts();
        initNavigationDrawer();
        initFragment();
    }

    private void initFragment() {
        fragment = PrincipalFragment.newInstance();
        fragmentTransaction(fragment);

    }

    private void initNavigationDrawer() {

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, mToolbar, R.string.app_name, R.string.app_name ){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                if(mDrawer.isDrawerOpen(Gravity.END) == true){
                    Log.d("Close", "Close");
                }
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                Log.d("Abrio", "Enter Abrio");
            }
        };

        mDrawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        mNavView.setNavigationItemSelectedListener(this);
        mNavView.setItemIconTintList(null);

        View headerLayout = mNavView.getHeaderView(0);
        View pencil = headerLayout.findViewById(R.id.rEditProfile);

        pencil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Click", "Lapiz");
                fragment = ProfileSettingsFragment.newInstance();
                fragmentTransaction(fragment);
                mDrawer.closeDrawer(GravityCompat.START);
            }
        });

    }

    private void fragmentTransaction(Fragment fragment) {

        if(fragment instanceof  ProfileSettingsFragment){
            Log.d("Enter ", "Fragment Profile");
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.flContent, fragment);
            transaction.commit();
        }

        if(fragment instanceof  PrincipalFragment){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.flContent, fragment);
            transaction.commit();
        }

        if(fragment instanceof EventsFragment){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.flContent, fragment);
            transaction.commit();
        }

    }

    private void initObjectts() {
        mToolbar = findViewById(R.id.toolbar);
        mDrawer = findViewById(R.id.dDrawer);
        mNavView = findViewById(R.id.nNavView);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Log.d("Click Menu", "/"+item.getItemId());
        int id = item.getItemId();
        loadFragment(id);

        mDrawer.closeDrawer(Gravity.START);

        return false;
    }

    private void loadFragment(int id) {

        switch (id){
            case R.id.nav_one_fragment:
                fragment = PrincipalFragment.newInstance();
                fragmentTransaction(fragment);
                mDrawer.closeDrawer(GravityCompat.START);
                break;

            case R.id.nav_two_fragment:
                fragment = EventsFragment.newInstance();
                fragmentTransaction(fragment);
                mDrawer.closeDrawer(GravityCompat.START);
                break;

            case R.id.nav_three_fragment:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
                return;

        }

        fragmentTransaction(fragment);

    }


}
