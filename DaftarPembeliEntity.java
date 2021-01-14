package Entity;
public class DaftarPembeliEntity {
   private PembeliEntity pembeli; 
    private boolean isVerified;
    private int indexTas; 
     public DaftarPembeliEntity(int indexTas,
             PembeliEntity pembeli, boolean isVerified) { 
         this.indexTas = indexTas;
        this.pembeli = pembeli;
        this.isVerified = isVerified;
    }
    public PembeliEntity getPembeli() {
        return pembeli;
    }
    public boolean isIsVerified() {
        return isVerified;
    }
    public int getIndexTas() {
        return indexTas;
    }
    public void setPembeli(PembeliEntity pembeli) {
        this.pembeli = pembeli;
    }
    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }
    public void setIndexTas(int indexTas) {
        this.indexTas = indexTas;
    }
}
