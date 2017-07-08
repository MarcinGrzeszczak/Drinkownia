package com.martiproduction.drinkownia.CustomViews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.martiproduction.drinkownia.R;

import java.util.List;

/**
 * Created by Marcin on 14.06.2017.
 */

public class DirectionsListAdapter extends RecyclerView.Adapter<DirectionsListAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView stepNumber, stepDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            stepNumber = (TextView) itemView.findViewById(R.id.stepDirection_number);
            stepDescription = (TextView) itemView.findViewById(R.id.stepDirection_description);
        }
    }



    private List<String> stepDescriptionList;

    public DirectionsListAdapter(List<String> stepDescriptionList){
        this.stepDescriptionList = stepDescriptionList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_step_directions,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.stepNumber.setText(String.valueOf(position+1));
        holder.stepDescription.setText(stepDescriptionList.get(position));
    }

    @Override
    public int getItemCount() {
        return stepDescriptionList.size();
    }


}
