package com.swamy.todolist;

public class ItemClass {
    String name;
    int img;
    int background_color;
    public ItemClass(String name,int imgRes,int background_color) {
        this.name = name;
        this.img=imgRes;
        this.background_color=background_color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getImg() {
        return this.img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getBackground_color() {
        return this.background_color;
    }

    public void setBackground_color(int background_color) {
        this.background_color = background_color;
    }



}
