package com.example.mayne.tyroiddiagnosis;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.mayne.tyroiddiagnosis.Model.TyroidTestModel;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

/**
 * Created by mayne on 8.12.2018.
 */

public class Test1Activity extends AppCompatActivity implements StepperLayout.StepperListener {

    private static final String TAG = "Test1Activity";
    private StepperLayout stepperLayout;
    private TyroidTestModel tyroidTestModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.test1_activity);

        gatherViews();
    }

    private void gatherViews() {

        stepperLayout = findViewById(R.id.stepperLayout);

        init();
    }

    private void init() {
        tyroidTestModel = new TyroidTestModel();
        stepperLayout.setOffscreenPageLimit(5);
        stepperLayout.setAdapter(new FragmentStepAdapter(getSupportFragmentManager(), this, tyroidTestModel));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);

    }

    @Override
    public void onCompleted(View completeButton) {
        Log.d(TAG, "onCompleted: ");

    }

    @Override
    public void onError(VerificationError verificationError) {
        Log.d(TAG, "onError: "+verificationError.getErrorMessage());
    }

    @Override
    public void onStepSelected(int newStepPosition) {
        Log.d(TAG, "onStepSelected: "+newStepPosition);
    }

    @Override
    public void onReturn() {
        Log.d(TAG, "onReturn: ");
    }
}
