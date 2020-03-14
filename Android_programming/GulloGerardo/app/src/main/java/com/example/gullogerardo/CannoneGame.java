package com.example.gullogerardo;

public class CannoneGame {


    public CannoneGame() {
        this.direzione = BASSO;

        this.bassoCount = 0;
        this.medioCount = 0;
        this.altoCount = 0;
    }

    public void restart(){
        this.bassoCount = 0;
        this.medioCount = 0;
        this.altoCount = 0;
    }

    public int getBassoCount() {
        return bassoCount;
    }

    public void setBassoCount(int bassoCount) {
        this.bassoCount = bassoCount;
    }

    public int getMedioCount() {
        return medioCount;
    }

    public void setMedioCount(int medioCount) {
        this.medioCount = medioCount;
    }

    public int getAltoCount() {
        return altoCount;
    }

    public void setAltoCount(int altoCount) {
        this.altoCount = altoCount;
    }

    public String getDirezione() {
        return direzione;
    }

    public void setDirezione(String direzione) {
        this.direzione = direzione;
    }

    private String direzione;
    private int bassoCount;
    private int medioCount;
    private int altoCount;


    public static String MEDIO = "Medio";
    public static String ALTO = "Alto";
    public static String BASSO = "Basso";

}
