package tikkipeli.Logic;

import java.util.*;

public class Pelipari {
    private Pelaaja[] parinPelaajat;
    private int pisteet;
    
    
    public Pelipari(Pelaaja pelaaja1, Pelaaja pelaaja2) {
        this.parinPelaajat = new Pelaaja[2];
        parinPelaajat[0] = pelaaja1;
        parinPelaajat[1] = pelaaja2;
        pisteet = 0;
    }
    
    public Pelaaja[] getPelaajat() {
        return parinPelaajat;
    }
    
    public Pelaaja getPelaaja1() {
        return parinPelaajat[0];
    }
    
    public Pelaaja getPelaaja2() {
        return parinPelaajat[1];
    }
    
    public int getPisteet() {
        return this.pisteet;
    }
    
    public void lisaaPisteita(int pisteita) {
        this.pisteet += pisteita;
    }
    
    @Override
    public String toString() {
        return parinPelaajat[0].getNimi() + " " + parinPelaajat[1].getNimi() + " " + pisteet;
    }
    
    public void jarjestaPelaajienKortit() {
        for (Pelaaja pelaaja : parinPelaajat) {
            pelaaja.kortitJarjestykseen();
        }
    }
    
    public void poistaPelaajienKortit() {
        for (Pelaaja pelaaja : parinPelaajat) {
            pelaaja.poistaKortit();
        }
    }
    
}
