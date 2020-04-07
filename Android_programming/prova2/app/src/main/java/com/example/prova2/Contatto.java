package com.example.prova2;

import android.graphics.drawable.Drawable;

public class Contatto {

    private String name;
    private String cellphone;
    private Drawable image;

    public Contatto(){

    }

    public Contatto(String name, String cellphone, Drawable picture){
        this.name = name;
        this.cellphone = cellphone;
        this.image = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getCellphone() {
        return cellphone;
    }

    public Drawable getImage() {
        return image;
    }
}
