package primer.zadaci;

public class Stampac {

    public  Boolean dozvoljenoStampanje = true;

    public static final Object sinhronizacija=new Object();

    public void stampaj(String string){
        System.out.println(string);
    }


}
