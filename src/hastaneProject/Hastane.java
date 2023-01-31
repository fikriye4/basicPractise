package hastaneProject;

public class Hastane extends VeriBankasi{
    private Doktor doktor;
    private String hasta;

    public Hastane(Doktor doktor, String hasta) {
        this.doktor = doktor;
        this.hasta = hasta;
    }

    public Hastane() {

    }

    public Doktor getDoktor() {
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

}
