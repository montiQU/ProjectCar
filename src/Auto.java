public class Auto {

    private String hersteller;
    private int id;
    private int hoechstgeschwindigkeit;
    private boolean lieferbar;

    public Auto(String hersteller, int id, int hoechstgeschwindigkeit, boolean lieferbar) {
        this.hersteller = hersteller;
        this.id = id;
        this.hoechstgeschwindigkeit = hoechstgeschwindigkeit;
        this.lieferbar = lieferbar;
    }

    public Auto() {

    }

    @Override
    public String toString() {
        return "\t\t\t\t\tID:\t" + this.id + "\n\t\t\tHersteller:\t" + this.hersteller + "\n Hoechstgeschwindikeit:\t" + this.hoechstgeschwindigkeit + "\n\t\t\t Lieferbar:\t" + this.lieferbar + "\n";
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHoechstgeschwindigkeit() {
        return hoechstgeschwindigkeit;
    }

    public void setHoechstgeschwindigkeit(int hoechstgeschwindigkeit) {
        this.hoechstgeschwindigkeit = hoechstgeschwindigkeit;
    }

    public void isLieferbar(boolean lieferbar) {
        this.lieferbar = lieferbar;
    }

    public boolean getLieferbar() {
        return lieferbar;
    }
}