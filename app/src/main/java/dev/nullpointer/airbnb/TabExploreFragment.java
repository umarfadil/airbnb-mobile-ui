package dev.nullpointer.airbnb;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.nullpointer.airbnb.fragment.AvailablePlacesFragment;
import dev.nullpointer.airbnb.fragment.ExploreFragment;

public class TabExploreFragment extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //inflate tab layout and setup views
        View x = inflater.inflate(R.layout.tab_fragment_explore, null);

        tabLayout = x.findViewById(R.id.tabs);
        viewPager = x.findViewById(R.id.viewpager);

        //set an adapter to the view pager
        viewPager.setAdapter(new GrafikTabAdapter(getChildFragmentManager()));

        //setup
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        return x;
    }

    class GrafikTabAdapter extends FragmentPagerAdapter {
        public GrafikTabAdapter(FragmentManager fm) {
            super(fm);
        }

        //Return fragment with respect to position
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new ExploreFragment();
                case 1:
                    return new AvailablePlacesFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return int_items;
        }

        //change title
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Explore";
                case 1:
                    return "Available Places";
            }
            return null;
        }
    }
}
