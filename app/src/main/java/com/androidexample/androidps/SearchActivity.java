package com.androidexample.androidps;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;

/**
 * Created by stu5 on 2016-08-11.
 */
public class SearchActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Toolbar toolbar = (Toolbar) findViewById(R.id.search_toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("단원별 질문 보기");


        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        PagerSlidingTabStrip pagerSlidingTabStrip =(PagerSlidingTabStrip)findViewById(R.id.search_pager_sliding_tab);

        ViewPager mViewPager = (ViewPager) findViewById(R.id.search_fragment_container);

        mViewPager.setAdapter(mSectionsPagerAdapter);

        pagerSlidingTabStrip.setViewPager(mViewPager);

    }

    public static class SearchFragment extends Fragment {

        int gPosition;
        int gIndex;

        public SearchFragment() {
        }

        public static SearchFragment newInstance(int index) {
            SearchFragment searchFragment = new SearchFragment();
            Bundle args = new Bundle();
            args.putInt("index", index);
            searchFragment.setArguments(args);
            return searchFragment;
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            gIndex = getArguments().getInt("index");
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_search, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.search_section);
            textView.setText("Search" + gIndex);
            return rootView;
        }

        // 데이터 불러올 메서드 쓰는 곳.
    }


    //프래그먼트를 페이저에 뿌려주는 어댑터.

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private String[] tabTitle = {"수학","영어","과학","국어","사회","기타"};

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return SearchFragment.newInstance(position + 1);
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
