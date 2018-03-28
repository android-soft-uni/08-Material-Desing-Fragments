package com.mentormate.fragmentsdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        setupToolbar();
        setupBottomNavigation();
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
    }

    private void setupBottomNavigation() {
        bottomNavigationView.setSelectedItemId(R.id.item_stories);

        Menu menu = bottomNavigationView.getMenu();
        selectFragment(menu.getItem(0));
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(item.getTitle());
                }
                selectFragment(item);
                return false;
            }
        });
    }

    protected void selectFragment(MenuItem item) {
        item.setChecked(true);
        toolbar.setElevation(4);

        switch (item.getItemId()) {
            case R.id.item_stories:
                pushFragment(new TimelineFragment());
                toolbar.setElevation(0);
                break;
            case R.id.item_gifts:
                pushFragment(new Frag4());
                toolbar.setElevation(0);
                break;
            case R.id.item_scanner:
                pushFragment(new Frag4());
                break;
            case R.id.item_profile:
                pushFragment(new Frag4());
                break;
        }
    }

    protected void pushFragment(Fragment fragment) {
        hideKeyboard();
        if (fragment == null)
            return;

        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            if (ft != null) {
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                ft.replace(R.id.grp_container, fragment);
                ft.commit();
            }
        }
    }

    public void hideKeyboard() {
        if (getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        }
    }

}
