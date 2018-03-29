package com.mentormate.fragmentsdemo.dynamic_frags;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mentormate.fragmentsdemo.R;

import java.io.UncheckedIOException;

public class ContactListFragment extends Fragment {

    private OnFragmentDataReceived listener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentActivity activityCompat = getActivity();
        if(activityCompat instanceof OnFragmentDataReceived) {
            listener = (OnFragmentDataReceived) activityCompat;
        } else {
            throw new RuntimeException("You must implement my interface");
        }

        //some of our code
        listener.onDataReceived("yess");
    }

    public interface OnFragmentDataReceived {
        void onDataReceived(String text);
    }

}
