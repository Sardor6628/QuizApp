package com.pratyakshkhurana.quizapp;

public class OnBoardIngItems {
    private int image;
    private String text;

    // Constructor
    public OnBoardIngItems(int image, String text) {
        this.image = image;
        this.text = text;
    }

    // Getter and Setter for image
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    // Getter and Setter for text
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
