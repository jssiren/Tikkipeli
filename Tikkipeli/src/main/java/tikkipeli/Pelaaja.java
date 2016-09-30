package tikkipeli;

import java.util.*;

public class Pelaaja {
    private Kasi kasi;
    private String nimi;
    
    public Pelaaja(String nimi) {
        this.kasi = new Kasi();
        this.nimi = nimi;
    }
    
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    
    public void setKasi(Kasi kasi) {
        this.kasi = kasi;
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    public Kasi getKasi() {
        return this.kasi;
    }
    
    @Override
    public String toString() {
        return this.nimi + this.kasi.toString();
    }
    
    
}
