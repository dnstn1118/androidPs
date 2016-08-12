package com.androidexample.androidps;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;

/**
 * Created by stu5 on 2016-08-10.
 */
public class StoryFragment extends Fragment{


        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_story, container, false);

            SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getActivity().getSupportFragmentManager());

            PagerSlidingTabStrip pagerSlidingTabStrip =(PagerSlidingTabStrip)rootView.findViewById(R.id.total_story_pager_sliding_tab);

            ViewPager mViewPager = (ViewPager)rootView.findViewById(R.id.total_story_fragment_container);

            mViewPager.setAdapter(mSectionsPagerAdapter);

            pagerSlidingTabStrip.setViewPager(mViewPager);

            return rootView;

    }


    public static class TotalStoryFragment extends Fragment {

        int gPosition;
        int gIndex;

        public TotalStoryFragment() {
        }

        public static TotalStoryFragment newInstance(int index) {
            TotalStoryFragment totalStoryFragment = new TotalStoryFragment();
            Bundle args = new Bundle();
            args.putInt("index", index);
            totalStoryFragment.setArguments(args);
            return totalStoryFragment;
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            gIndex = getArguments().getInt("index");
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_total_story, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.total_story_section);
            textView.setText("용용이이" + gIndex);
            return rootView;
        }

        // 데이터 불러올 메서드 쓰는 곳.
    }



    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private String[] tabTitle = {"전체","자유게시판","공부자극","고민상담","꿀팁"};

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return TotalStoryFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {

            return tabTitle.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return tabTitle[position];
        }
    }
}
