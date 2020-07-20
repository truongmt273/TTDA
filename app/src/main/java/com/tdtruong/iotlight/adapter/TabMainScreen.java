package com.tdtruong.iotlight.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.tdtruong.iotlight.Fragment.HistoryAction;
import com.tdtruong.iotlight.Fragment.Information;
import com.tdtruong.iotlight.Fragment.TimerMode;
import com.tdtruong.iotlight.Fragment.Auto;

public class TabMainScreen extends FragmentStatePagerAdapter {

    public TabMainScreen(FragmentManager fm){
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position)
        {
            case 0 : fragment = new Information(); break;
            case 1 : fragment = new Auto(); break;
            case 2 : fragment = new HistoryAction(); break;
            case 3 : fragment = new TimerMode(); break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0 : title = "Infor"; break;
            case 1 : title = "Trigger"; break;
            case 2 : title = "History"; break;
            case 3 : title = "Timer"; break;
        }
        return title;
    }
}
