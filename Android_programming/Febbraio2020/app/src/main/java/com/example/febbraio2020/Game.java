package com.example.febbraio2020;

import java.util.Random;

public class Game {

    public Game(int[][] matrix) {
        this.matrix = matrix;
    }


    public boolean doMossa(int r, int c){

        //itero per riga
        for(int i = 0 ; i < matrix.length ; i++)
            this.matrix[r][i] = (this.matrix[r][i] + this.valoreIncrementate) % Game.MODULO;

        //itero per colonna
        for(int i = 0 ; i < matrix.length ; i++)
            this.matrix[i][c] = (this.matrix[i][r] + this.valoreIncrementate) % Game.MODULO;

        this.addCountMossa(1);
        this.verifyWin();

        return this.win;
    }


    public boolean azzera(){

        int value = rand.nextInt(this.matrix.length);
        int flag = rand.nextInt(2);

        if(flag == 0)
            for(int i = 0 ; i < matrix.length ; i++)
                this.matrix[value][i] = 0;

        else
            for(int i = 0 ; i < matrix.length ; i++)
                this.matrix[i][value] = 0;


        this.addCountMossa(10);
        this.verifyWin();

        return this.win;




    }

    public int getValue(int r, int c){
        return this.matrix[r][c];
    }

    private void addCountMossa(int value){
        this.contaMosse += value;
    }

    private void verifyWin(){

        this.win = true;

        for(int i = 0 ; i < matrix.length ; i++)
            for(int j = 0 ; j < matrix.length ; j++)
                if(this.matrix[i][j] != 0){
                    this.win = false;
                    return;
                }
    }


    public int getContaMosse() {
        return contaMosse;
    }

    public void setContaMosse(int contaMosse) {
        this.contaMosse = contaMosse;
    }

    public int getValoreIncrementate() {
        return valoreIncrementate;
    }

    public void setValoreIncrementate(int valoreIncrementate) {
        this.valoreIncrementate = valoreIncrementate;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    private int contaMosse;
    private int valoreIncrementate;
    private int matrix[][];
    private boolean win = false;

    public static final int MODULO = 10;
    public static final Random rand = new Random();
}
