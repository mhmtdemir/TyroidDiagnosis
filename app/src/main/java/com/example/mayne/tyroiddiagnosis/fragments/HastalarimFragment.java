package com.example.mayne.tyroiddiagnosis.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.mayne.tyroiddiagnosis.MyFragmentsInterface;
import com.example.mayne.tyroiddiagnosis.R;

/**
 * Created by mayne on 7.12.2018.
 */

public class HastalarimFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "HastalarimFragment";
    private RelativeLayout hastalarimName;
    private MyFragmentsInterface myFragmentsInterface;

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

        return inflater.inflate(R.layout.hastalar, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: ");
        hastalarimName.setOnClickListener(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hastalarimName = view.findViewById(R.id.hastalarimName);

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

            case R.id.hastalarimName:

                Log.d(TAG, "onClick: ");
                myFragmentsInterface.getMyFragments("HastaBilgileri", null);

                break;

        }


    }
}
