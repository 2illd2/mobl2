package com.example.catrecyclerview;

public class Cat {
    private int imageResId;
    private String text;

    public Cat(int imageResId, String text) {
        this.imageResId = imageResId;
        this.text = text;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getText() {
        return text;
    }
}