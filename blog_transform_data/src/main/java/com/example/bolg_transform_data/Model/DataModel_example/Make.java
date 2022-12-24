package com.example.bolg_transform_data.Model.DataModel_example;

public class Make {
    String text;
    int image[];


    public Make(String text, int[] image) {
        this.text = text;
        this.image = image;

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int[] getImage() {
        return image;
    }

    public void setImage(int[] image) {
        this.image = image;
    }


}
