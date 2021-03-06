package primer4;




public class Kvadrat implements IFigura {
    protected double stranica;

    public Kvadrat(double stranica) {
        this.stranica = stranica;
    }

    @Override
    public double izracunajPovrsinu() {
        return stranica*stranica;
    }

    @Override
    public double izracunajObim() {
        return 4*stranica;
    }

    @Override
    public String toString() {
        return "Kvadrat{stranica=" + stranica +'}';
    }
}
