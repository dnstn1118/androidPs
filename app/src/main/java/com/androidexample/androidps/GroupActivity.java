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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;

/**
 * Created by stu5 on 2016-08-10.
 */
public class GroupActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        //toolbar 호출
        Toolbar toolbar = (Toolbar) findViewById(R.id.group_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("그룹");


       SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());


       PagerSlidingTabStrip pagerSlidingTabStrip =(PagerSlidingTabStrip)findViewById(R.id.group_pager_sliding_tab);

       ViewPager mViewPager = (ViewPager) findViewById(R.id.group_fragment_container);

        mViewPager.setAdapter(mSectionsPagerAdapter);

        pagerSlidingTabStrip.setViewPager(mViewPager);

        /*TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);*/


    }
    //toolbar 메뉴 설정.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.group_toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.toolbar_group_item) {

                // 버튼 링크

        }else if(id == R.id.toolbar_search_item){

                // 버튼 링크
        }

        return super.onOptionsItemSelected(item);
    }

    //fragment

    public static class GroupFragment extends Fragment {

        int gPosition;
        int gIndex;

        public GroupFragment() {
        }

        public static GroupFragment newInstance(int index) {
            GroupFragment groupFragment = new GroupFragment();
            Bundle args = new Bundle();
            args.putInt("index", index);
            groupFragment.setArguments(args);
            return groupFragment;
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            gIndex = getArguments().getInt("index");
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_group_1, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section1);
            textView.setText(gPosition + " 용용이이" + gIndex);
            return rootView;
        }

        // 데이터 불러올 메서드 쓰는 곳.
    }



    //프래그먼트를 페이저에 뿌려주는 어댑터.

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private String[] tabTitle = {"내 그룹","수학","영어","과학","사회","학습상담","TOEIC","TOFLE","한문","한국사","기타"};

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return GroupFragment.newInstance(position + 1);
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