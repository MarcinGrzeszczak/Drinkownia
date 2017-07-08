package com.martiproduction.drinkownia.CustomViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.martiproduction.drinkownia.R;
import com.martiproduction.drinkownia.core.RecipeInfo;
import com.squareup.picasso.Picasso;

import java.util.List;


public class RecipesListAdapter extends RecyclerView.Adapter<RecipesListAdapter.ViewHolder> {

    private RecyclerView mRecyclerView;
    private List<RecipeInfo> recipeInfoList;
    private Context context;
    private static OnClickListener onClickListener;


    public interface OnClickListener{
        void clickedFavButton(int position);
        void clickedRecipe(int position);
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
         ImageView drinkPicture , favouriteBtn;
         TextView drinkName;
         RatingBar ratingBar;


        ViewHolder(View itemView) {
            super(itemView);
            favouriteBtn = (ImageView) itemView.findViewById(R.id.title_favourite_btn);
            drinkPicture = (ImageView) itemView.findViewById(R.id.title_drink_pic);
            drinkName = (TextView) itemView.findViewById(R.id.title_drink_name);
            ratingBar = (RatingBar) itemView.findViewById(R.id.title_ratingbar);

            if(onClickListener != null)
                favouriteBtn.setOnClickListener(v->onClickListener.clickedFavButton(getAdapterPosition()));
        }
    }


    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public RecipesListAdapter(List<RecipeInfo> recipeInfoList, RecyclerView recyclerView){
        this.recipeInfoList = recipeInfoList;
        this.mRecyclerView = recyclerView;
    }

    @Override
    public RecipesListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View item = LayoutInflater.from(context).inflate(R.layout.adapter_drink_title,parent,false);

        if(onClickListener != null)
            item.setOnClickListener(v-> onClickListener.clickedRecipe(mRecyclerView.getChildAdapterPosition(v)));

        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(RecipesListAdapter.ViewHolder holder, int position) {
        Picasso
                .with(context)
                .load(recipeInfoList.get(position).getPicSrc())
                .resize(80,80).centerCrop()
                .into(holder.drinkPicture);

         /*
              Animation animation = AnimationUtils.loadAnimation(context,
                R.anim.item_animation);
                item.startAnimation(animation);
             */
        holder.drinkName.setText(recipeInfoList.get(position).getName());
        holder.ratingBar.setRating(recipeInfoList.get(position).getRating());
    }


    @Override
    public int getItemCount() {
        return recipeInfoList.size();
    }

}
