package primer.sync_metoda;

public class AerodromSyncMetoda {

    /* Ne moramo koristiti wraper klasu Boolean jer se sinhronizacija vrsi nad objektom klase
       AerodromSyncMetoda.
    */
    private boolean dozvolaZaSletanje = true;

    public static void main(String[] args){
        AerodromSyncMetoda aerodrom = new AerodromSyncMetoda();
        AvionNitSyncMetoda a1 = new AvionNitSyncMetoda(1, aerodrom);
        AvionNitSyncMetoda a2 = new AvionNitSyncMetoda(2, aerodrom);
        AvionNitSyncMetoda a3 = new AvionNitSyncMetoda(3, aerodrom);
        AvionNitSyncMetoda a4 = new AvionNitSyncMetoda(4, aerodrom);

        a1.start();
        a2.start();
        a3.start();
        a4.start();
    }

    public synchronized boolean traziDozvoluZaSletanje() {
        // Provera da li je moguce sletanje, da li je pista slobodna
        if(dozvolaZaSletanje)
        {
            // Pista vise nije slobodno i sledeci avion ne moze da sleti
            dozvolaZaSletanje=false;
            return true;//Trenutni avion je dobio dozvolu i moze da sleti
        }
        return false;
    }

    public synchronized void zavrsioSletanje() {
        this.dozvolaZaSletanje = true;
    }
}
