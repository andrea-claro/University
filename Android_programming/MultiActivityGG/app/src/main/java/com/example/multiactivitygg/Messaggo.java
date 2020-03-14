package com.example.multiactivitygg;

import java.io.Serializable;

public class Messaggo implements Serializable {

    public Messaggo() { }

    public Messaggo(String activity1, String activity2, String activity3) {
        this.activity1 = activity1;
        this.activity2 = activity2;
        this.activity3 = activity3;
    }

    public String getActivity1() {
        return activity1;
    }

    public void setActivity1(String activity1) {
        this.activity1 = activity1;
    }

    public String getActivity2() {
        return activity2;
    }

    public void setActivity2(String activity2) {
        this.activity2 = activity2;
    }

    public String getActivity3() {
        return activity3;
    }

    public void setActivity3(String activity3) {
        this.activity3 = activity3;
    }

    private String activity1;
    private String activity2;
    private String activity3;
}
