package model;

public class Artikal {
    private String naziv;
    private String opis;
    private double cena;

    public Artikal(){

    }
    public Artikal(String naziv, String opis, double cena){
        this.naziv = naziv;
        this.opis = opis;
        this.cena = cena;


    }
    public Artikal(Artikal a){
        this.naziv = naziv;
        this.opis = opis;
        this.cena = cena;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
}
