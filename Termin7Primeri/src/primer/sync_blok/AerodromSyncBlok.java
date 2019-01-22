package primer.sync_blok;


public class AerodromSyncBlok {
    /* Ne mozemo koristiti ovaj objekat za sinhronizaciju, jer se tokom izvrsavanje menja vrednost
       kada avioni dobiju dozovlu za sletanje i kada slete opet menjaju da je ponovo dozvoljeno sletanje.
     */
    public static Boolean dozvoljenoSletanje = true;
    /* Kreiramo objekat koji ce biti jedinstaven za sve niti i koji se nece menjati tokom izvrsavanje
       programa. Kao zastitu mozemo da dodamo kljucnu rec final, da bismo bili sigurno da se ne promeni
       kasnije u kodu.
    */
    public static final Object sinhronizacija=new Object();

    public static void main(String[] args){
        AvionNitSyncBlok a1 = new AvionNitSyncBlok(1);
        AvionNitSyncBlok a2 = new AvionNitSyncBlok(2);
        AvionNitSyncBlok a3 = new AvionNitSyncBlok(3);
        AvionNitSyncBlok a4 = new AvionNitSyncBlok(4);

        a1.start();
        a2.start();
        a3.start();
        a4.start();
    }

}
