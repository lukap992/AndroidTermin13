package auto.trka;

/**
 * Created by lazar on 11.9.16..
 */
public class AutoTrka {

    public static void main(String [] args){
        System.out.println("Pocetak trke");
        AutomobilNit auto1 = new AutomobilNit("Automobil 1");
        AutomobilNit auto2 = new AutomobilNit("Automobil 2");
        AutomobilNit auto3 = new AutomobilNit("Automobil 3");

        auto1.start();
        auto2.start();
        auto3.start();

            System.out.println("Kraj trke");

        try {
            auto1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            auto2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            auto3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(auto1).start();
        new Thread(auto2).start();
        new Thread(auto3).start();


    }
}
