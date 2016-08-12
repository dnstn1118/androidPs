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
 * Created by stu5 on 2016-08-12.
 */
public class NewsActivity extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        Toolbar toolbar = (Toolbar) findViewById(R.id.news_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("그룹");

        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        PagerSlidingTabStrip pagerSlidingTabStrip =(PagerSlidingTabStrip)findViewById(R.id.news_pager_sliding_tab);

        ViewPager mViewPager = (ViewPager) findViewById(R.id.news_fragment_container);

        mViewPager.setAdapter(mSectionsPagerAdapter);

        pagerSlidingTabStrip.setViewPager(mViewPager);

        /*TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);*/
    }

    public static class NewsFragment extends Fragment {

        int gPosition;
        int gIndex;

        public NewsFragment() {
        }

        public static NewsFragment newInstance(int index) {
            NewsFragment newsFragment = new NewsFragment();
            Bundle args = new Bundle();
            args.putInt("index", index);
            newsFragment.setArguments(args);
            return newsFragment;
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            gIndex = getArguments().getInt("index");
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_news, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.news_section);
            textView.setText("용용이이" + gIndex);
            return rootView;
        }

        // 데이터 불러올 메서드 쓰는 곳.
    }



    //프래그먼트를 페이저에 뿌려주는 어댑터.

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private String[] tabTitle = {"알림","바풀 뉴스","친구 요청"};

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return NewsFragment.newInstance(position + 1);
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
