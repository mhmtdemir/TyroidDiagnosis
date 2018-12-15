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

public class T3 extends Fragment implements Step {

    private static final String TAG = "T3";
    private TyroidTestModel tyroidTestModel;
    private EditText t3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.test_step_t3, container, false);
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
        t3 = view.findViewById(R.id.t3);
    }

    @Nullable
    @Override
    public VerificationError verifyStep() {
        if (t3.getText().length() <= 0) {

            return new VerificationError("Boş Geçilemez");
        } else {

            tyroidTestModel.setT3(Double.valueOf(t3.getText().toString()));
            showAnalyzeDialog();
            return null;
        }
    }

    private void showAnalyzeDialog() {

        AnalyzeDialog analyzeDialog = new AnalyzeDialog();
        Bundle b = new Bundle();
        b.putParcelable("tyroidTestModel", tyroidTestModel);
        analyzeDialog.setArguments(b);
        analyzeDialog.show(getFragmentManager(), "AnalyzeDialog");


    }


    @Override
    public void onSelected() {

    }

    @Override
    public void onError(@NonNull VerificationError error) {
        Log.d(TAG, "onError: " + error);
    }
}
