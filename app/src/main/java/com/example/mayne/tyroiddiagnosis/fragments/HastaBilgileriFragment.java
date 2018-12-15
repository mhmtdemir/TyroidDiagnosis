package com.example.mayne.tyroiddiagnosis.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.ViewSwitcher;

import com.example.mayne.tyroiddiagnosis.MyFragmentsInterface;
import com.example.mayne.tyroiddiagnosis.R;
import com.example.mayne.tyroiddiagnosis.Test1Activity;

/**
 * Created by mayne on 7.12.2018.
 */

public class HastaBilgileriFragment extends Fragment implements View.OnClickListener, View.OnKeyListener {
    private static final String TAG = "MainFragment";
    private RelativeLayout test1, testler;
    private MyFragmentsInterface myFragmentsInterface;
    private ViewSwitcher formSwitcher;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {

            myFragmentsInterface = (MyFragmentsInterface) getActivity();
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        myFragmentsInterface = null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.d(TAG, "onCreateView: ");

        return inflater.inflate(R.layout.hasta_details, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: ");
        formSwitcher.setInAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.push_left_in));
        formSwitcher.setOutAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.push_left_out));
        test1.setOnClickListener(this);
        testler.setOnClickListener(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        test1 = view.findViewById(R.id.test1);
        testler = view.findViewById(R.id.testler);
        formSwitcher = view.findViewById(R.id.formSwitcher);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(this);

        Log.d(TAG, "onViewCreated: ");
    }


    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.test1:

                Log.d(TAG, "onClick: TEST 1 ");

                // myFragmentsInterface.getMyFragments("Test1Activity", null);

                startActivity(new Intent(getActivity(), Test1Activity.class));
                getActivity().overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                break;

            case R.id.testler:
                Log.d(TAG, "onClick:TESTLER ");

                formSwitcher.setDisplayedChild(1);


                break;

        }


    }

    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i == KeyEvent.KEYCODE_BACK) {
            Log.d(TAG, "onKey: ");
            if (formSwitcher.getChildAt(1) == formSwitcher.getCurrentView()) {
                Log.d(TAG, "onKey: Form : 0");
                formSwitcher.setDisplayedChild(0);
                return true;
            } else {

                Log.d(TAG, "onKey: GERİ");
                return false;
            }
        }

            return false;
    }
}
