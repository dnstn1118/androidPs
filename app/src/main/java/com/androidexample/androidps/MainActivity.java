package com.androidexample.androidps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabSelectedListener;

public class MainActivity extends AppCompatActivity{

        QuestionFragment questionFragment;
        StoryFragment storyFragment;
        ProfileFragment profileFragment;
        GroupActivity groupActivity;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            questionFragment = new QuestionFragment();
            storyFragment = new StoryFragment();
            profileFragment = new ProfileFragment();
            final ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("질문");


        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, questionFragment).commit();
        final BottomBar bottomBar = BottomBar.attach(this, savedInstanceState);

            bottomBar.setItemsFromMenu(R.menu.main_button_menu, new OnMenuTabSelectedListener() {
                @Override
                public void onMenuItemSelected(int itemId) {
                    switch (itemId) {
                        case R.id.question_item:
                            //Snackbar.make(coordinatorLayout, "Recent Item Selected", Snackbar.LENGTH_LONG).show();
                            getSupportFragmentManager().beginTransaction().replace(R.id.main_container, questionFragment).commit();
                            actionBar.setTitle("질문");
                            break;
                        case R.id.story_item:
                            //Snackbar.make(coordinatorLayout, "Recent Item Selected",Snackbar.LENGTH_LONG).show();
                            getSupportFragmentManager().beginTransaction().replace(R.id.main_container, storyFragment).commit();
                            actionBar.setTitle("이야기");
                            break;
                        case R.id.profile_item:
                            //Snackbar.make(coordinatorLayout, "Recent Item Selected", Snackbar.LENGTH_LONG).show();
                            getSupportFragmentManager().beginTransaction().replace(R.id.main_container, profileFragment).commit();
                            actionBar.setTitle("프로필");
                            break;
                    }
                }
            });


        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 메뉴를 위한 XML 파일 설정

        getMenuInflater().inflate(R.menu.question_actionbar_menu, menu);
        //getMenuInflater().inflate(R.menu.else_actionbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int curId = item.getItemId();
        switch(curId) {
            case R.id.group_item:
                Intent intent1 = new Intent(getApplicationContext(), GroupActivity.class);
                startActivity(intent1);
                break;
            case R.id.search_item:
                Intent intent2 = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent2);
                break;
            case R.id.news_item:
                Intent intent3 = new Intent(getApplicationContext(), NewsActivity.class);
                startActivity(intent3);
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }



}


