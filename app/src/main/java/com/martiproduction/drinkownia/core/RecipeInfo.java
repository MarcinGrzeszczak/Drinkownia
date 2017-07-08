package com.martiproduction.drinkownia.core;


import android.os.Parcel;
import android.os.Parcelable;

public class RecipeInfo implements Parcelable {
    private String name , picSrc;
    private int drinkId,rating;


    public RecipeInfo(String picSrc,String name,int rating) {
        this.name = name;
        this.picSrc = picSrc;
        this.rating = rating;
    }

    protected RecipeInfo(Parcel in) {
        name = in.readString();
        picSrc = in.readString();
        drinkId = in.readInt();
        rating = in.readInt();
    }

    public static final Creator<RecipeInfo> CREATOR = new Creator<RecipeInfo>() {
        @Override
        public RecipeInfo createFromParcel(Parcel in) {
            return new RecipeInfo(in);
        }

        @Override
        public RecipeInfo[] newArray(int size) {
            return new RecipeInfo[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicSrc() {
        return picSrc;
    }

    public void setPicSrc(String picSrc) {
        this.picSrc = picSrc;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(picSrc);
        parcel.writeInt(drinkId);
        parcel.writeInt(rating);
    }
}
