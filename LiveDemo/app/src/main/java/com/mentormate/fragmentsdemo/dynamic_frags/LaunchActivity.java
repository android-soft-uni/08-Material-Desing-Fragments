package com.mentormate.fragmentsdemo.dynamic_frags;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.mentormate.fragmentsdemo.R;

public class LaunchActivity extends AppCompatActivity implements ContactListFragment.OnFragmentDataReceived {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ContactListFragment fragment = new ContactListFragment();
        fragmentTransaction.add(R.id.grp_container, fragment);
        fragmentTransaction.disallowAddToBackStack();
        fragmentTransaction.commit();

        ContactDetailsFragment fr2 = new ContactDetailsFragment();
        fragmentManager
                .beginTransaction()
                .replace(R.id.grp_container, fr2)
                .commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onDataReceived(String text) {

    }
}
