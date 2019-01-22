package auto.trka;

import auto.trka.AvionNit.Avion;
import auto.trka.kontejner.KontejnerNit;

import java.util.ArrayList;

public class Polimo {

    public static void main(String[] args) {
        ArrayList<Runnable>r1 = new ArrayList<>();
        r1.add(new AutomobilNit("automobil 1"));
        r1.add(new Avion("avion1"));
        r1.add(new KontejnerNit(1111));

        ArrayList<Thread> listaT = new ArrayList<>();


        for(int i = 0; i < r1.size(); i++){
            listaT.add(new Thread(r1.get(i)));
            listaT.get(i).start();

        }
        for(int i = 0; i < listaT.size(); i++){
            try {
                listaT.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i = 0; i < r1.size(); i++){
            if(r1.get(i) instanceof AutomobilNit){

            }
        }


    }
}
