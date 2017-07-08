package com.martiproduction.drinkownia.core;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

/**
 * Created by marti on 08.11.2016.
 */

public class Bubbles {

    public static class Builder{
        private int bubbleCount,bubbleMinSize,bubbleMaxSize;
        private float bubbleMinAcceleration,bubbleMaxAcceleration,bubbleMaxSpeed;
        private Canvas canvas;

        public Builder setBubbleCount(int bubbleCount) {
            this.bubbleCount = bubbleCount;
            return this;
        }

        public Builder setBubbleMinSize(int bubbleMinSize) {
            this.bubbleMinSize = bubbleMinSize;
            return this;
        }

        public Builder setBubbleMaxSize(int bubbleMaxSize) {
            this.bubbleMaxSize = bubbleMaxSize;
            return this;
        }

        public Builder setBubbleMinAcceleration(float bubbleMinAcceleration) {
            this.bubbleMinAcceleration = bubbleMinAcceleration;
            return this;
        }

        public Builder setBubbleMaxAcceleration(float bubbleMaxAcceleration) {
            this.bubbleMaxAcceleration = bubbleMaxAcceleration;
            return this;
        }

        public Builder setBubbleMaxSpeed(float bubbleMaxSpeed) {
            this.bubbleMaxSpeed = bubbleMaxSpeed;
            return this;
        }

        public Builder setCanvas(Canvas canvas) {
            this.canvas = canvas;
            return this;
        }

        public Bubbles build(){
            return new Bubbles(this);
        }
    }

    private class Bubble{
        private int size;
        private float acceleration, X, Y;

        float getSpeed() {
            return speed;
        }

        void setSpeed(float speed) {
            this.speed = speed;
        }

        private float speed;

        Bubble(int size, float acceleration, float speed, float x, float y) {
            this.size = size;
            this.acceleration = acceleration;
            X = x;
            Y = y;
            this.speed = speed;
        }

        float getX() {
            return X;
        }

        float getY() {
            return Y;
        }

        void setY(float y) {
            Y = y;
        }

        int getSize() {
            return size;
        }

        float getAcceleration() {
            return acceleration;
        }
    }

    private int bubbleCount,bubbleMinSize,bubbleMaxSize;
    private float bubbleMinAcceleration,bubbleMaxAcceleration,bubbleMaxSpeed;
    private Canvas canvas;
    private Bubble bubbleList[];
    private Paint brush;

    public Bubbles(Builder builder) {
        this.bubbleCount = builder.bubbleCount;
        this.bubbleMinSize = builder.bubbleMinSize;
        this.bubbleMaxSize = builder.bubbleMaxSize;
        this.bubbleMinAcceleration = builder.bubbleMinAcceleration;
        this.bubbleMaxAcceleration = builder.bubbleMaxAcceleration;
        this.bubbleMaxSpeed = builder.bubbleMaxSpeed;
        this.canvas = builder.canvas;
        init();
    }

    private float random(float min , float max){
        Random rand = new Random();
        return (max-min)*rand.nextFloat()+min;
    }

    private int random(int max){
        Random rand = new Random();
        return rand.nextInt(max);
    }

    private void init(){
        brush = new Paint();
        brush.setColor(Color.argb(70,255,255,255));
        brush.setStyle(Paint.Style.FILL);

        bubbleList = new Bubble[bubbleCount];

        for(int i = 0; i < bubbleCount;i++)
            bubbleList[i] = new Bubble(random(bubbleMaxSize)+bubbleMinSize,random(bubbleMinAcceleration,bubbleMaxAcceleration),0,random(canvas.getWidth()),random(canvas.getHeight()));
    }

    public void update(){
        for(int i = 0 ; i < bubbleCount;i++){

            if(bubbleList[i].getSpeed() < bubbleMaxSpeed)
                bubbleList[i].setSpeed(bubbleList[i].getSpeed()+bubbleList[i].getAcceleration());

            if(bubbleList[i].getY() > 0)
                bubbleList[i].setY(bubbleList[i].getY()-bubbleList[i].getAcceleration());
            else
                bubbleList[i] = new Bubble(random(bubbleMaxSize)+bubbleMinSize,random(bubbleMinAcceleration,bubbleMaxAcceleration),0,random(canvas.getWidth()),canvas.getHeight());

            canvas.drawCircle(bubbleList[i].getX(),bubbleList[i].getY(),bubbleList[i].getSize(),brush);
        }
    }
}
