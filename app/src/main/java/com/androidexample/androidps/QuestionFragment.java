package com.androidexample.androidps;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by stu5 on 2016-08-10.
 */
public class QuestionFragment extends Fragment{
    ArrayList<TestListData> testListDatas = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_question, container, false);

        final ListView listView = (ListView) viewGroup.findViewById(R.id.question_listview);

        String [] TextItem = new String []{"이 문제 답이 무엇인가요?? 아무리봐도 모르겠어요 알려주세요 ㅠㅠ",
                "초등학교 1학년이에요. 틀렸는데 자꾸 아닌가요? 또 산에서 밥먹으며는 왜 그런거죠? 알려주세요",
                "고3 수포자 입니다. 제가 이제 수능공부 하려고 하니까 너무 힘드네요 알려주세요 ㅠㅠ"};


        Drawable[] ImageItem = new Drawable[] {
                getResources().getDrawable(R.drawable.english1_e),
                getResources().getDrawable(R.drawable.korean_k),
                getResources().getDrawable(R.drawable.math1_m)
        };


        for (int i = 0; i < TextItem.length; i++) {
            TestListData testListData = new TestListData();
            testListData.settData(TextItem[i]);

            testListData.settDrawable(ImageItem[i]);

            testListDatas.add(testListData);
        }

        final Adapters.QuestionAdapter questionAdapter = new Adapters.QuestionAdapter(getActivity().getApplication(),testListDatas);
        listView.setAdapter(questionAdapter);


        return viewGroup;

    }

}
