package com.androidexample.androidps;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by stu5 on 2016-08-12.
 */
public class Adapters {

    public static class QuestionAdapter extends BaseAdapter{


        private ArrayList<TestListData> testListDatas;

        private Context context;

        public QuestionAdapter(Context context, ArrayList<TestListData> testListDatas){

            this.context = context;
            this.testListDatas = testListDatas;
        }
        public ArrayList<TestListData> getTestListDatas() {
            return testListDatas;
        }

        public void setTestListDatas(ArrayList<TestListData> testListDatas) {
            this.testListDatas = testListDatas;
        }

        @Override
        public int getCount() {
            return testListDatas.size();
        }

        @Override
        public Object getItem(int position) {

            return testListDatas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            if(convertView == null){
                convertView = View.inflate(context, R.layout.question_fragment_listview, null);
                //convertView = new TextView(context);
                //((TextView)convertView).setText("test");
            }

            TestListData testListData = testListDatas.get(position);


            ((ImageView)convertView.findViewById(R.id.question_list_image_item)).setImageDrawable(testListData.gettDrawable());
            ((TextView)convertView.findViewById(R.id.question_list_text_item)).setText(String.valueOf(testListData.gettData()));

            return convertView;
        }
    }


    public static class TotalStoryAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }

    public static class GroupAdapger extends BaseAdapter{

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }

    public static class MyGroupAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }
}
