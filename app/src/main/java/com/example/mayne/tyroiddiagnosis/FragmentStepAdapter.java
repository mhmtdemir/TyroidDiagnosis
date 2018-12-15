package com.example.mayne.tyroiddiagnosis;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.example.mayne.tyroiddiagnosis.Model.TyroidTestModel;
import com.example.mayne.tyroiddiagnosis.TestSteps.MADTSH;
import com.example.mayne.tyroiddiagnosis.TestSteps.T3;
import com.example.mayne.tyroiddiagnosis.TestSteps.TSH;
import com.example.mayne.tyroiddiagnosis.TestSteps.TST;
import com.example.mayne.tyroiddiagnosis.TestSteps.TSTT;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.stepstone.stepper.viewmodel.StepViewModel;

/**
 * Created by mayne on 1.05.2018.
 */

public class FragmentStepAdapter extends AbstractFragmentStepAdapter {
    private TyroidTestModel tyroidTestModel;

    @Override
    public Parcelable saveState() {
        Log.d(TAG, "saveState: ");
        return super.saveState();
    }


    private static final String TAG = "FragmentStepAdapter";

    public FragmentStepAdapter(@NonNull FragmentManager fm, @NonNull Context context, TyroidTestModel tyroidTestModel) {
        super(fm, context);
        this.tyroidTestModel = tyroidTestModel;
    }

    @Override
    public Step createStep(int position) {
        Log.d(TAG, "createStep: ");
        if (position == 0) {
            Log.d(TAG, "createStep: 0");
            TST step = new TST();
            Bundle b = new Bundle();
            b.putParcelable("tyroidTestModel", tyroidTestModel);
            step.setArguments(b);
            return step;

        }
        if (position == 1) {
            Log.d(TAG, "createStep: 1");
            TSH step = new TSH();
            Bundle b = new Bundle();
            b.putParcelable("tyroidTestModel", tyroidTestModel);
            step.setArguments(b);
            return step;

        }
        if (position == 2) {
            Log.d(TAG, "createStep: 2");
            TSTT step = new TSTT();
            Bundle b = new Bundle();
            b.putParcelable("tyroidTestModel", tyroidTestModel);
            step.setArguments(b);
            return step;

        }
        if (position == 3) {
            Log.d(TAG, "createStep: 3");
            MADTSH step = new MADTSH();
            Bundle b = new Bundle();
            b.putParcelable("tyroidTestModel", tyroidTestModel);
            step.setArguments(b);
            return step;

        }
        if (position == 4) {
            Log.d(TAG, "createStep: 3");
            T3 step = new T3();
            Bundle b = new Bundle();
            b.putParcelable("tyroidTestModel", tyroidTestModel);
            step.setArguments(b);
            return step;
        } else {
            Log.d(TAG, "createStep: 1 2 3 4 5 ");
            TST step = new TST();
            Bundle b = new Bundle();
            b.putParcelable("tyroidTestModel", tyroidTestModel);
            step.setArguments(b);
            return step;
        }
    }


    @NonNull
    @Override
    public StepViewModel getViewModel(int position) {
        Log.d(TAG, "getViewModel: d");
        StepViewModel.Builder stepViewModel = new StepViewModel.Builder(context);
        switch (position) {
            case 0:
                stepViewModel.setTitle("TST");
              //  stepViewModel.setSubtitle()
            //    stepViewModel.setSubtitle("TST DEĞERİ ");
                break;
            case 1:
                stepViewModel.setTitle("TSH");
           // stepViewModel.setSubtitle("TSH DEĞERİ");
                break;
            case 2:
                stepViewModel.setTitle("TSTT");
             //   stepViewModel.setSubtitle("TSTT DEĞERİ");

                break;
            case 3:
                stepViewModel.setTitle("MADTSH");
             //   stepViewModel.setSubtitle("MADTSH DEĞERİ");
                break;
            case 4:
                stepViewModel.setTitle("T3");
             //   stepViewModel.setSubtitle("T3 DEĞERİ");
                break;
        }

        return stepViewModel.create();
    }

    @Override
    public int getCount() {
        return 5;
    }
}
