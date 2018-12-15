package com.example.mayne.tyroiddiagnosis;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.mayne.tyroiddiagnosis.fragments.HastaBilgileriFragment;
import com.example.mayne.tyroiddiagnosis.fragments.HastalarimFragment;
import com.example.mayne.tyroiddiagnosis.fragments.MainFragment;

public class MainActivity extends AppCompatActivity implements MyFragmentsInterface {
    private static final String TAG = "MainActivity";
    //widgets
    private FrameLayout frameLayout;
    private Toolbar toolBar;
    public TextView toolbarText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gatherViews();

    }

    private void gatherViews() {

        frameLayout = findViewById(R.id.fragmentContainer);
        toolbarText = findViewById(R.id.toolbarText);

        initView();

    }

    private void initView() {

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new MainFragment(), "MainFragment")
                .addToBackStack("MainFragment").commit();

    }


    @Override
    public void getMyFragments(String tag, @Nullable String arguments) {

        switch (tag) {
            case "Hastalarim":

                Log.d(TAG, "getMyFragments: ");

                getSupportFragmentManager().beginTransaction().
                        setCustomAnimations(R.anim.push_left_in, R.anim.push_left_out, R.anim.push_left_in, R.anim.push_left_out).
                        replace(R.id.fragmentContainer, new HastalarimFragment(), "Hastalarim").addToBackStack("Hastalarim").
                        commit();


                break;
            case "HastaBilgileri":

                Log.d(TAG, "getMyFragments: ");

                getSupportFragmentManager().beginTransaction().
                        setCustomAnimations(R.anim.push_left_in, R.anim.push_left_out, R.anim.push_left_in, R.anim.push_left_out).
                        replace(R.id.fragmentContainer, new HastaBilgileriFragment(), "HastaBilgileri").addToBackStack("HastaBilgileri").
                        commit();


                break;

        }

    }
}
