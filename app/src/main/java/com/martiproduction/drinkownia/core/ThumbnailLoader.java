package com.martiproduction.drinkownia.core;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcin on 21.09.2017.
 */

public class ThumbnailLoader extends AsyncTaskLoader<List<Bitmap>> {

    Context mContext;

    public ThumbnailLoader(Context context) {
        super(context);
    }

    @Override
    public List<Bitmap> loadInBackground() {

        List<Bitmap> thumbnails = new ArrayList<>();

        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String[] projection = {MediaStore.Images.Media._ID};
        Cursor cursor = mContext.getContentResolver().query(uri,projection,null,null,null);


        while(cursor.moveToNext()) {
            Bitmap thumbnail = MediaStore.Images.Thumbnails.getThumbnail(mContext.getContentResolver(),cursor.getInt(0),MediaStore.Images.Thumbnails.MINI_KIND,null);
            thumbnails.add(thumbnail);
        }

        return thumbnails;
    }
}
