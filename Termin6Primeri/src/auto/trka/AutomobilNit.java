package auto.trka;

/**
 * Created by lazar on 11.9.16..
 */
public class AutomobilNit extends Thread {

    private String ime;

    public AutomobilNit(String ime){
        this.ime = ime;
    }

    @Override
    public void run() {
        System.out.println(ime + " je krenuo!");
        vozi();
        pitStop();
        vozi();
        System.out.println(ime + " je zavrsio trku!");
    }

    private void pitStop(){
        System.out.println(ime + " ulazi u pit stop!");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ime + " izlazi iz pit stopa!");
    }

    private void vozi(){
        int period = (int)(Math.random() * 2000);
        try {
            sleep(period);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
