package auto.trka.kontejner;

public class KontejnerNit implements Runnable {

    private int brojKontejnera;

    public KontejnerNit(int brojKontejnera){
        this.brojKontejnera = brojKontejnera;
    }

    @Override
    public void run(){
        System.out.println("Pocinje utovar kontejnera sa brojem " + brojKontejnera);

        int period = 1000 + (int)(Math.random() * 4000);
        try {
            Thread.sleep(period);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Utovar kontejnera zavrsen " + brojKontejnera );
    }
}
