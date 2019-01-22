package primer.zadaci;

import static java.lang.Thread.sleep;

public class Dokument {
    private Stampac stampac;
    private String rec1;
    private String rec2;
    private String nazivDokumenta;

    public Dokument(){

    }
    public Dokument(Stampac stampac, String rec1, String rec2, String nazivDokumenta){
        this.stampac = stampac;
        this.rec1 = rec1;
        this.rec2 = rec2;
        this.nazivDokumenta = nazivDokumenta;
    }

    public void run(){

        boolean dobioDozvolu;

        do{
            System.out.println("Provera zauzeca stampaca za dokument " + nazivDokumenta);
            synchronized (stampac) {
                if(stampac.dozvoljenoStampanje){
                    stampac.dozvoljenoStampanje = false;
                    dobioDozvolu = true;

                }else{
                    dobioDozvolu = false;
                }
            }

            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }





        }while (!dobioDozvolu);



    }



}
