package com.example.omy.tab.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.omy.tab.Fragments.PrimerFragment;
import com.example.omy.tab.Fragments.SegundoFragment;
import com.example.omy.tab.Fragments.TerceroFragment;
import com.example.omy.tab.Fragments.calendar;

public class PagerAdapter extends FragmentPagerAdapter {

    private int numeroTAB;

    public PagerAdapter(FragmentManager fm, int tabs) {
        super(fm);
        this.numeroTAB = tabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new calendar();
            case 1:
                return new SegundoFragment();
            case 2:
                return new TerceroFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numeroTAB;
    }
}
