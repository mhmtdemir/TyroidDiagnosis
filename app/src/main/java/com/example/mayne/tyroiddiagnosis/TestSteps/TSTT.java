package com.example.mayne.tyroiddiagnosis.TestSteps;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.mayne.tyroiddiagnosis.Model.TyroidTestModel;
import com.example.mayne.tyroiddiagnosis.R;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

/**
 * Created by mayne on 8.12.2018.
 */

public class TSTT extends Fragment implements Step {

    private static final String TAG = "TSTT";
    private TyroidTestModel tyroidTestModel;
    private EditText tstt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.test_step_tstt, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: ");
        if (getArguments() != null) {
            tyroidTestModel = getArguments().getParcelable("tyroidTestModel");
            Log.d(TAG, "onActivityCreated: " + tyroidTestModel);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated: ");
        tstt = view.findViewById(R.id.tstt);
    }

    @Nullable
    @Override
    public VerificationError verifyStep() {
        if (tstt.getText().length() <= 0) {
            return new VerificationError("Boş Geçilemez");
        } else {
            tyroidTestModel.setTSTT(Double.valueOf(tstt.getText().toString()));
            return null;
        }
    }

    @Override
    public void onSelected() {
        Log.d(TAG, "onSelected: ");
    }

    @Override
    public void onError(@NonNull VerificationError error) {

    }
}
