package model;

import java.time.LocalDate;

public class Racun {
    private String oznaka;
    private LocalDate datum;



    public Racun(){


    }
    public Racun(Racun a){
        this.oznaka = oznaka;
        this.datum = datum;

    }
    public Racun(String oznaka, LocalDate datum){
        this.oznaka = oznaka;
        this.datum = datum;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }
}

