package primer3;

public class TestKonstruktori {
    public static void main(String[] args) {
        Automobil a1=new Automobil();
        Automobil a2=new Automobil(200,true);
        Automobil a3=new Automobil(a2);

        System.out.println("maksimalna brzina " + a2.maksimalnaBrzina);
        System.out.println("Auto radi " + a2.radi);
    }
}
