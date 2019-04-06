package com.example.csipro.aigiswar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.csipro.aigiswar.Class.Class1;
import com.example.csipro.aigiswar.Class.Class2;
import com.example.csipro.aigiswar.Class.Class3;
import com.example.csipro.aigiswar.Class.Class4;
import com.example.csipro.aigiswar.Class.Class5;

/**
 * Created by abdalla on 2/18/18.
 */

public class PageAdapter extends FragmentPagerAdapter {

    private int numOfTabs;

    PageAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {


            case 1:
                return new Class2();
            case 0:
                return new Class1();
            case 2:
                return new Class3();
            case 3:
                return new Class4();
            case 4:
                return new Class5();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
