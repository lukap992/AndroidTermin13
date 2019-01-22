package primer.sync_blok;

public class AvionNitSyncBlok extends Thread {

    private int sifraAviona;

    public AvionNitSyncBlok(int sifraAviona) {
        this.sifraAviona = sifraAviona;
    }

    private void poleti() {
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
            // Citamo u synchronized bloku
            synchronized (AerodromSyncBlok.sinhronizacija) {
                //Proveravamo da li mozemo da sletimo
                if (AerodromSyncBlok.dozvoljenoSletanje) {
                    AerodromSyncBlok.dozvoljenoSletanje = false;
                    dobioDozvolu = true;
                } else {
                    dobioDozvolu = false;
                }
            }
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
        // Pisemo u synchronized bloku
        synchronized (AerodromSyncBlok.sinhronizacija) {
            //Obavestavamo da je sletanje zavrseno
            AerodromSyncBlok.dozvoljenoSletanje = true;
        }
    }

    public void run() {
        poleti();
        sleti();
    }
}
