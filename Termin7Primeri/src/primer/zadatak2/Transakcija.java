package primer.zadatak2;

import static java.lang.Thread.sleep;

public class Transakcija {

    private Racun racun;
    private double promenaRacuna;

    public Transakcija(){

    }

    public Transakcija(Racun racun, double promenaRacuna){
        this.racun = racun;
        this.promenaRacuna = promenaRacuna;
    }

    public void run(){
        boolean imaDozvolu;

        do{
            synchronized (racun){
                if(racun.dozvoljenaTransakcija){
                    racun.dozvoljenaTransakcija = false;
                    imaDozvolu = true;
                }else {
                    imaDozvolu = false;
                }

            }
        }while (!imaDozvolu);

        System.out.println("Pocinje transakcija");

        try {
            sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
