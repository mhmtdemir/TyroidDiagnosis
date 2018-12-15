package com.example.mayne.tyroiddiagnosis.TestSteps;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mayne.tyroiddiagnosis.Model.TyroidTestModel;
import com.example.mayne.tyroiddiagnosis.R;

import at.grabner.circleprogress.CircleProgressView;

/**
 * Created by mayne on 11.12.2018.
 */

public class AnalyzeDialog extends DialogFragment implements View.OnClickListener, View.OnKeyListener {


    private static final String TAG = "AnalyzeDialog";
    private CircleProgressView mCircleView;
    private RelativeLayout analyzeLayout;
    private TyroidTestModel tyroidTestModel;
    private String resultText;
    private CardView sonucOnayla;
    private Handler handler;
    private ImageView editBtn;

    private TextView tstValue, tshValue, tsttValue, madtshValue, t3Value, normalValue, hyperValue, hypoValue,
            tstText, tshText, tsttText, madtshText, t3Text;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.editBtn:


                getDialog().dismiss();

                break;
            case R.id.sonucOnayla:


                mCircleView.stopSpinning();
                getDialog().dismiss();

                break;


        }
    }

    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {

        if (i == KeyEvent.KEYCODE_BACK) {
            Log.d(TAG, "onKey: BACK BTN ");
            getDialog().dismiss();
        }

        return true;
    }

    //Enum Değerleri..

    public enum TyroidTypes {
        HYPER,
        HYPO,
        NORMAL,
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");

        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

        return inflater.inflate(R.layout.analyze_fragment, null, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");

        super.onViewCreated(view, savedInstanceState);
        mCircleView = view.findViewById(R.id.circleView);
        analyzeLayout = view.findViewById(R.id.analyzeLayout);
        tstValue = view.findViewById(R.id.tstValue);
        tshValue = view.findViewById(R.id.tshValue);
        tsttValue = view.findViewById(R.id.tsttValue);
        madtshValue = view.findViewById(R.id.madtshValue);
        t3Value = view.findViewById(R.id.t3Value);
        normalValue = view.findViewById(R.id.normalValue);
        hyperValue = view.findViewById(R.id.hyperValue);
        hypoValue = view.findViewById(R.id.hypoValue);
        tstText = view.findViewById(R.id.tstText);
        tshText = view.findViewById(R.id.tshText);
        tsttText = view.findViewById(R.id.tsttText);
        madtshText = view.findViewById(R.id.madtshText);
        t3Text = view.findViewById(R.id.t3Text);
        editBtn = view.findViewById(R.id.editBtn);
        sonucOnayla = view.findViewById(R.id.sonucOnayla);


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //FullScreen Dialog
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.MATCH_PARENT;
        getDialog().getWindow().setLayout(width, height);
        getDialog().getWindow().setWindowAnimations(
                R.style.DialogSlideAnimation);
        editBtn.setOnClickListener(this);
        sonucOnayla.setOnClickListener(this);

        getView().setOnKeyListener(this);
        mCircleView.setText("Analiz Ediliyor...");
        mCircleView.spin();
        setTestValuesText();
        handler = new Handler();
        //6 saniye sonra spin işlemi duracak analiz işlemi başlayacak (spin animasyonunun dogru çalışması içinn)
        handler.postDelayed(runnable, 6000);
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                analyzeResult();
//                mCircleView.stopSpinning();
//                //mCircleView.setValueAnimated(95);
//                mCircleView.setText(resultText);
//
//            }
//        }, 6000);

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
        handler.removeCallbacks(runnable);
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            analyzeResult();
            mCircleView.stopSpinning();
            //mCircleView.setValueAnimated(95);
            mCircleView.setText(resultText);
        }
    };


    private void setTestValuesText() {

        if (getArguments() != null) {
            tyroidTestModel = getArguments().getParcelable("tyroidTestModel");

            Log.d(TAG, "analyzeResult: " + tyroidTestModel);
        }

        Drawable descend = getResources().getDrawable(R.drawable.sort_down);
        Drawable increase = getResources().getDrawable(R.drawable.long_arrow_pointing_up);

        tstValue.setText(String.valueOf(tyroidTestModel.getTST()));
        tstText.setCompoundDrawablesWithIntrinsicBounds(null, null,
                tyroidTestModel.getTST() > 5.200 ? increase : descend, null);


        tshValue.setText(String.valueOf(tyroidTestModel.getTSH()));
        tshText.setCompoundDrawablesWithIntrinsicBounds(null, null,
                tyroidTestModel.getTSH() > 4 ? increase : descend, null);
        tsttValue.setText(String.valueOf(tyroidTestModel.getTSTT()));
        tsttText.setCompoundDrawablesWithIntrinsicBounds(null, null,
                tyroidTestModel.getTSTT() > 2.950 ? increase : descend, null);

        madtshValue.setText(String.valueOf(tyroidTestModel.getMADTSH()));
        madtshText.setCompoundDrawablesWithIntrinsicBounds(null, null,
                tyroidTestModel.getMADTSH() > 9.600 ? increase : descend, null);
        t3Value.setText(String.valueOf(tyroidTestModel.getT3()));
        t3Text.setCompoundDrawablesWithIntrinsicBounds(null, null,
                tyroidTestModel.getT3() > 96.500 ? increase : descend, null);


    }


    //Analiz İşlemi .
    private void analyzeResult() {

        if (tyroidTestModel.getTST() > 5.200) {

            if (tyroidTestModel.getTSTT() > 2.950) {
                Log.d(TAG, "analyzeResult: " + TyroidTypes.HYPER);

                resultText = String.valueOf(TyroidTypes.HYPER);
                setCircleViewAttributes(
                        getResources().getColor(R.color.ForestGreen),
                        getResources().getColor(R.color.ForestGreen),
                        getResources().getColor(R.color.ForestGreen), 100);
                setValueText(100, 0, 0);


            } else {


                if (tyroidTestModel.getMADTSH() > 9.600) {

                    Log.d(TAG, "analyzeResult: " + TyroidTypes.HYPO);
                    resultText = String.valueOf(TyroidTypes.HYPO);
                    setCircleViewAttributes(
                            getResources().getColor(R.color.OrangeRed),
                            getResources().getColor(R.color.OrangeRed),
                            getResources().getColor(R.color.OrangeRed), 100);
                    setValueText(0, 0, 100);


                } else {


                    if (tyroidTestModel.getTST() > 16.650) {
                        Log.d(TAG, "analyzeResult: " + TyroidTypes.HYPER);
                        resultText = String.valueOf(TyroidTypes.HYPER);
                        setCircleViewAttributes(
                                getResources().getColor(R.color.ForestGreen),
                                getResources().getColor(R.color.ForestGreen),
                                getResources().getColor(R.color.ForestGreen), 100);
                        setValueText(100, 0, 0);


                    } else {

                        if (tyroidTestModel.getMADTSH() > 0.250) {
                            Log.d(TAG, "analyzeResult: " + TyroidTypes.NORMAL);
                            resultText = String.valueOf(TyroidTypes.NORMAL);

                            setCircleViewAttributes(
                                    getResources().getColor(R.color.myblue),
                                    getResources().getColor(R.color.myblue),
                                    getResources().getColor(R.color.myblue), 100);
                            setValueText(0, 100, 0);

                        } else {

                            if (tyroidTestModel.getT3() > 96.500) {

                                Log.d(TAG, "analyzeResult: " + TyroidTypes.NORMAL);
                                resultText = String.valueOf(TyroidTypes.NORMAL);
//
                                setCircleViewAttributes(
                                        getResources().getColor(R.color.myblue),
                                        getResources().getColor(R.color.myblue),
                                        getResources().getColor(R.color.ForestGreen), 90);
                                setValueText(10, 90, 0);

                            } else {

                                Log.d(TAG, "analyzeResult: " + TyroidTypes.HYPER);
                                resultText = String.valueOf(TyroidTypes.HYPER);
//
                                setCircleViewAttributes(
                                        getResources().getColor(R.color.ForestGreen),
                                        getResources().getColor(R.color.ForestGreen),
                                        getResources().getColor(R.color.ForestGreen), 100);
                                setValueText(100, 0, 0);

                            }

                        }


                    }
                }


            }

        } else {

            Log.d(TAG, "analyzeResult: " + TyroidTypes.HYPO);
            resultText = String.valueOf(TyroidTypes.HYPO);

            setCircleViewAttributes(
                    getResources().getColor(R.color.OrangeRed),
                    getResources().getColor(R.color.OrangeRed),
                    getResources().getColor(R.color.OrangeRed), 100);
            setValueText(0, 0, 100);

        }


    }

    private void setValueText(int _hyperValue, int _normalValue, int _hypoValue) {

        hyperValue.setText(getString(R.string.hypoValue, String.valueOf(_hyperValue).concat("%")));
        hypoValue.setText(getString(R.string.hypoValue, String.valueOf(_hypoValue).concat("%")));
        normalValue.setText(getString(R.string.hypoValue, String.valueOf(_normalValue).concat("%")));


    }


    private void setCircleViewAttributes(int innerConturColor, int barColor, int rimColor, int value) {
        mCircleView.setInnerContourColor(innerConturColor);
        mCircleView.setBarColor(barColor);
        mCircleView.setRimColor(rimColor);
        mCircleView.setValueAnimated(value);


    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
        mCircleView.stopSpinning();
        handler.removeCallbacks(runnable);

    }
}
