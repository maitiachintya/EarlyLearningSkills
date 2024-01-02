package com.example.earlylearningskills;

public class LearningImageModel {

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getAlphabat() {
        return alphabat;
    }

    public void setAlphabat(int alphabat) {
        this.alphabat = alphabat;
    }

    int img;
    int alphabat;
    public LearningImageModel(int a, int apple) {
        this.img = a;
        this.alphabat = apple;
    }
}
