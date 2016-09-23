package tikkipeli;

import java.util.*;

public class Tikki {
    private int moneskoTikki;
    private Kortti[] pelatutKortit;
    private Pelaaja[] pelaajat;
    
    public Tikki(int i) {
        this.pelaajat = new Pelaaja[4];
        this.pelatutKortit = new Kortti[4];
        moneskoTikki = i;
    }
    
    public Kortti[] getKortit() {
        return this.pelatutKortit;
    }
    
    public Pelaaja[] getPelaajat() {
        return this.pelaajat;
    }
    
    public void setPelaajat(Pelaaja[] pelaajat) {
        this.pelaajat = pelaajat;
    }
    
    public void lisaaKorttiPaikkaanI(int i, Kortti kortti) {
        this.pelatutKortit[i] = kortti;
    }
    
    public Kortti tikinVoittavaKortti() {
        // kehitä logiikka
        Kortti voittavaKortti = new Kortti(Maa.HERTTA, KortinArvo.k6); // jotta metodi ei tuota erroria
        return voittavaKortti;
    }
    
}
