package com.martiproduction.drinkownia.CustomViews;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.martiproduction.drinkownia.R;

import java.io.File;
import java.util.List;

/**
 * Created by marcin on 20.09.2017.
 */

public class PickingImageAdapter extends RecyclerView.Adapter<PickingImageAdapter.PickingImageHolder> {

    private Cursor mImages;
    private Context mContext;

    class PickingImageHolder extends RecyclerView.ViewHolder {
        ImageView image;

        public PickingImageHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.adapter_pickingImage_image);
        }
    }

    public PickingImageAdapter() {}

    public void addCursor(Cursor data){ this.mImages = data; }

    @Override
    public PickingImageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_picking_image,parent,false);
        return new PickingImageHolder(view);
    }

    @Override
    public void onBindViewHolder(PickingImageHolder holder, int position) {
       // mImages.move(position);
        Glide.with(mContext)
                .load(mImages.getString(0))
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return mImages.getCount();
    }


}
