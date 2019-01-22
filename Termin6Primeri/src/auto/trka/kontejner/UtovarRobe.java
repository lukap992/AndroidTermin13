package auto.trka.kontejner;

import java.util.ArrayList;

public class UtovarRobe {
    public static void main(String[] args) {
        KontejnerNit kontejner1 = new KontejnerNit(1111);
        KontejnerNit kontejner2 = new KontejnerNit(2222);
        KontejnerNit kontejner3 = new KontejnerNit(3333);
        KontejnerNit kontejner4 = new KontejnerNit(4444);
        KontejnerNit kontejner5 = new KontejnerNit(5555);

        Thread t1 = new Thread(kontejner1);
        Thread t2 = new Thread(kontejner2);
        Thread t3 = new Thread(kontejner3);
        Thread t4 = new Thread(kontejner4);
        Thread t5 = new Thread(kontejner5);

        ArrayList<Thread> listaKontejnera = new ArrayList<>();

        listaKontejnera.add(t1);
        listaKontejnera.add(t2);
        listaKontejnera.add(t3);
        listaKontejnera.add(t4);
        listaKontejnera.add(t5);

        ArrayList<Thread> listaT = new ArrayList<>();


        for(int i = 0; i < listaKontejnera.size(); i++){
            listaKontejnera.get(i).start();
        }


        for(int i = 0; i < listaKontejnera.size(); i++){
            try {
                listaKontejnera.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Brod je krenuo iz luke");






    }
}
