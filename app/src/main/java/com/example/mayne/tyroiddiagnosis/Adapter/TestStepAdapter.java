package com.example.mayne.tyroiddiagnosis.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mayne.tyroiddiagnosis.R;

import java.util.ArrayList;

/**
 * Created by mayne on 8.12.2018.
 */

public class TestStepAdapter extends RecyclerView.Adapter<TestStepAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    private ArrayList<String> mStepList;
    private boolean isLastItem;

    public TestStepAdapter(Context context, ArrayList<String> stepList, boolean isLastItem) {

        mInflater = LayoutInflater.from(context);
        this.mStepList = stepList;
        this.isLastItem = isLastItem;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = mInflater.inflate(R.layout.test_step, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.stepName.setText(mStepList.get(position));


    }

    @Override
    public int getItemCount() {
        return mStepList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout stepLayout;
        TextView stepName;
        View nextLine;

        public ViewHolder(View itemView) {
            super(itemView);
            stepLayout = itemView.findViewById(R.id.stepLayout);
            stepName = itemView.findViewById(R.id.stepName);
            nextLine = itemView.findViewById(R.id.nextLine);
        }
    }
}
