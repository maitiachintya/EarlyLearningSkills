package com.example.earlylearningskills;

public class FruitsImageModel {
int charecter;
int charecter_img;


    String name;
    public FruitsImageModel(int apple, int strawberry, String img_name) {
        charecter = apple;
        charecter_img = strawberry;
        name = img_name;
    }

    public int getCharecter() {
        return charecter;
    }

    public void setCharecter(int charecter) {
        this.charecter = charecter;
    }

    public int getCharecter_img() {
        return charecter_img;
    }

    public void setCharecter_img(int charecter_img) {
        this.charecter_img = charecter_img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
