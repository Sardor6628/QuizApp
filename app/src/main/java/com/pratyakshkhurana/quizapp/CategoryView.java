package com.pratyakshkhurana.quizapp;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;

import androidx.cardview.widget.CardView;

public class CategoryView {
    public int image;
    public String category;
    public Drawable cardImage;
    public Drawable icon;

    public CategoryView(int image, String category, Drawable cardImage, Drawable icon) {
        this.image = image;
        this.category = category;
        this.cardImage = cardImage;
        this.icon = icon;
    }

    public int getImage() {
        return image;
    }

    public String getCategory() {
        return category;
    }

    public Drawable getCardImage() {
        return cardImage;
    }

    public Drawable getIcon() {
        return icon;
    }
}

