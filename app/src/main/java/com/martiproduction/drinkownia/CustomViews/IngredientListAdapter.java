package com.martiproduction.drinkownia.CustomViews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.martiproduction.drinkownia.R;

import java.util.List;

/**
 * Created by Marcin on 03.03.2017.
 */

public class IngredientListAdapter extends RecyclerView.Adapter<IngredientListAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView ingredientName;

        public ViewHolder(View itemView) {
            super(itemView);

            ingredientName = (TextView) itemView.findViewById(R.id.ingredient_single_text);
        }
    }

    private List<String> ingredientsNames;

    public IngredientListAdapter(List<String> ingredientsNames) {
        this.ingredientsNames = ingredientsNames;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_ingredients_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.ingredientName.setText(ingredientsNames.get(position));
    }

    @Override
    public int getItemCount() {
        return ingredientsNames.size();
    }


}
