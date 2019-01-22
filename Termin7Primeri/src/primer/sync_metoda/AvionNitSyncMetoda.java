package primer.sync_metoda;

import primer.sync_blok.AerodromSyncBlok;

public class AvionNitSyncMetoda extends Thread {

    private AerodromSyncMetoda aerodrom;
    private int sifraAviona;

    public AvionNitSyncMetoda(int sifraAviona, AerodromSyncMetoda aerodrom){
        this.sifraAviona = sifraAviona;
        this.aerodrom = aerodrom;
    }

    private void poleti(){
        System.out.println("Avion " + sifraAviona + " je poleteo.");

        try {
            this.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

     private void sleti() {
         boolean dobioDozvolu;
         do {
             System.out.println("Avion " + sifraAviona + " trazi dozvolu za sletanje.");
             // Citamo u synchronized metodi
             // Proveravamo da li je dozvoljeno sletanje
             dobioDozvolu = aerodrom.traziDozvoluZaSletanje();

             //Ako nije dobio dozvolu za sletanje ceka sekund da ponovo proveri da li je dozvoljeno sletanje
             if (!dobioDozvolu) {
                 try {
                     // Svake sekudne proveravaj dozvolu za sletanje
                     this.sleep(1000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         } while (!dobioDozvolu);//Proveravamo da li je dozvoljeno sletanje sve dok se ne dobije dozvola za sletanje

         // Treba mu jedna sekunda da sleti
         System.out.println("Avion " + sifraAviona + " slece.");
         try {
             this.sleep(1000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }



         System.out.println("Avion " + sifraAviona + " je sleteo.");
         // Pisemo u synchronized metodi
         // Obavestavamo da je sletanje zavrseno
         aerodrom.zavrsioSletanje();
     }


    public void run() {
        poleti();
        sleti();
    }
}
