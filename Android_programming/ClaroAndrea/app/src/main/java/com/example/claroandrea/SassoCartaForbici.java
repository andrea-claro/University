package com.example.claroandrea;

public class SassoCartaForbici {

    public enum Scelta {
        SASSO,
        CARTA,
        FORBICI
    }


    public SassoCartaForbici() {
    }

    public Scelta getPlayer() {
        return player;
    }

    public void setPlayer(Scelta player) {
        this.player = player;
    }

    public Scelta getApplication() {
        return application;
    }

    public void setApplication(Scelta application) {
        this.application = application;
    }

    //se true -> player vince  ||  se false -> application vince
    public int verify() {

        if (this.player == this.application)
            return -1;

        else if(this.player == Scelta.SASSO && this.application == Scelta.FORBICI ||
                this.player == Scelta.CARTA && this.application == Scelta.SASSO ||
                this.player == Scelta.FORBICI && this.application == Scelta.CARTA)
            return 1;

        return 0;
    }

    private Scelta player;
    private Scelta application;
}

