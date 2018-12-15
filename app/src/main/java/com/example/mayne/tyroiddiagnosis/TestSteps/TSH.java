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

public class TSH extends Fragment implements Step {
    private static final String TAG = "TSH";
    private TyroidTestModel tyroidTestModel;
    private EditText tsh;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.test_step_tsh, container, false);
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
        tsh = view.findViewById(R.id.tsh);
    }

    @Nullable
    @Override
    public VerificationError verifyStep() {

        if (tsh.getText().length() <= 0) {

            return new VerificationError("Boş Geçilemez");
        } else {
            tyroidTestModel.setTSH(Double.valueOf(tsh.getText().toString()));
            return null;
        }

    }

    @Override
    public void onSelected() {

    }

    @Override
    public void onError(@NonNull VerificationError error) {

    }
}
