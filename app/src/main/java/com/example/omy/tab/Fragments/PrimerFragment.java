package com.example.omy.tab.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.omy.tab.R;

public class PrimerFragment extends Fragment {


    public PrimerFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     View view =  inflater.inflate(R.layout.fragment_primer, container, false);
        return view;
    }

}
