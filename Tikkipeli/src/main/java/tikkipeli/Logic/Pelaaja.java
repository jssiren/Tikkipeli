package tikkipeli.Logic;

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
    
    public boolean poistaKortti(int kortti) {
        if(kasi.poistaKorttiKadesta(kortti)) {
            return true;
        } else {
            return false;
        }
    }
    
    public void kortitJarjestykseen() {
        this.kasi.kortitJarjestykseen();
    }
    
    @Override
    public String toString() {
        return this.nimi + " " + this.kasi.toString();
    }
    
    public void poistaKortit() {
        kasi.poistaKortit();
    }
    
    public boolean equals(Pelaaja pelaaja) {
        if(this.nimi.matches(pelaaja.getNimi())) {
            return true;
        } else {
            return true;
        }
    }
    
    
    
}
