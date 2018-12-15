package com.example.mayne.tyroiddiagnosis.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mayne.tyroiddiagnosis.Adapter.TestStepAdapter;
import com.example.mayne.tyroiddiagnosis.R;

import java.util.ArrayList;

/**
 * Created by mayne on 7.12.2018.
 */

public class Test1 extends Fragment implements View.OnClickListener {
    private static final String TAG = "Test1Activity";

    private RecyclerView testStepRecylerView;
    private ArrayList<String> stepList = new ArrayList<>();
    private TestStepAdapter testStepAdapter;
    private EditText content;
    private TextView contentHead;
    private RelativeLayout bottom;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.test1, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        testStepRecylerView = view.findViewById(R.id.testStepRecylerView);
        contentHead = view.findViewById(R.id.contentHead);
        content = view.findViewById(R.id.content);
        bottom = view.findViewById(R.id.bottom);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: ");
        stepList.add("TST");
        testStepAdapter = new TestStepAdapter(getContext(), stepList, true);
        testStepRecylerView.setAdapter(testStepAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        testStepRecylerView.setLayoutManager(linearLayoutManager);
        LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation(getActivity(), R.anim.layout_anim3);
        testStepRecylerView.setLayoutAnimation(layoutAnimationController);
        testStepRecylerView.setItemAnimator(new DefaultItemAnimator());
        testStepRecylerView.setHasFixedSize(true);
        bottom.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.bottom:

                if ((Double.valueOf(content.getText().toString())) < 5.200) {
                    Log.d(TAG, "DEVAM BUTONU : " + (Double.valueOf(content.getText().toString())));
                    stepList.add("TSTT");
                    testStepAdapter.notifyItemInserted(stepList.size() - 1);


                }


                break;


        }
    }
}
