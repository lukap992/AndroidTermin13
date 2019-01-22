package auto.trka.AvionNit;

public class Avion extends Thread{

    private String sifraAviona;

    public Avion(String sifraAviona){
        this.sifraAviona = sifraAviona;
    }

    @Override
    public void run(){
        System.out.println("Avion je poleteo " + sifraAviona);
        try{
            sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }



    }

    private void pitStop(){
        System.out.println("Avion trazi dozvolu za sletanje " + sifraAviona);
        try{
            sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Avion je sleteo " + sifraAviona);

    }



}
