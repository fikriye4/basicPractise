package hastaneProject;

public class Hasta extends VeriBankasi {

    private String isim;
    private String soyIsim;
    private int hastaID;
    private Durum hastaDurumu;

    public Hasta() {
    }

    public Hasta(String isim, String soyIsim, int hastaID, Durum hastaDurumu) {
        this.isim = isim;
        this.soyIsim = soyIsim;
        this.hastaID = hastaID;
        this.hastaDurumu = hastaDurumu;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyIsim() {
        return soyIsim;
    }

    public void setSoyIsim(String soyIsim) {
        this.soyIsim = soyIsim;
    }

    public int getHastaID() {
        return hastaID;
    }

    public void setHastaID(int hastaID) {
        this.hastaID = hastaID;
    }

    public Durum getHastaDurumu() {
        return hastaDurumu;
    }

    public void setHastaDurumu(Durum hastaDurumu) {
        this.hastaDurumu = hastaDurumu;
    }

    @Override
    public String toString() {
        return "Hasta{" +
                "isim='" + isim + '\'' +
                ", soyIsim='" + soyIsim + '\'' +
                ", hastaID=" + hastaID +
                ", hastaDurumu=" + hastaDurumu +
                '}';
    }
}