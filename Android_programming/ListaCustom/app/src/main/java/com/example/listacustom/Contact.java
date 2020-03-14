package com.example.listacustom;

import android.graphics.drawable.Drawable;

public class Contact {

    private String name;
    private String tel;
    private Drawable picture;

    public Contact(String name, String tel, Drawable pic){
        this.name = name;
        this.tel = tel;
        this.picture = pic;
    }

    public String getName(){
        return name;
    }

    public String getTel(){
        return tel;
    }

    public Drawable getPicture(){
        return picture;
    }
}
