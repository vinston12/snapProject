package com.example.snapchatcopy.AfterLoginActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class Adapter  extends FragmentPagerAdapter {

    public Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new ChatFragment().newInstance();
            case 1:
                return new CameraFragment().newInstance();
            case 2:
                return new StoryFragment().newInstance();

        }
    return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

}
