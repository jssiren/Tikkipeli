package tikkipeli.Logic;

import java.util.*;

public class Kierros {
    private ArrayList<Tikki> tikit;
    private ArrayList<Pelaaja> tikinVoittavaPelaaja;
    private Maa valtti;
    private int huudonVoittaja;
    
    public Kierros(int pelaaja) {
        tikit = new ArrayList<>();
        tikinVoittavaPelaaja = new ArrayList<>();
        valtti = Maa.TYHJA;
        huudonVoittaja = pelaaja;
    }
    
    public ArrayList<Tikki> getTikit() {
        return tikit;
    }
    
    public ArrayList<Pelaaja> getVoittavatPelaajat() {
        return tikinVoittavaPelaaja;
    }
    
    public Maa getValtti() {
        return valtti;
    }
    
    public int getHuudonVoittaja() {
        return huudonVoittaja;
    }
    
    
    public void setHuudonVoittaja(int pelaaja) {
        huudonVoittaja = pelaaja;
    }
    
    public void lisaaTikki() {
        tikit.add(new Tikki());
    }
    
    public void lisaaVoittavaPelaaja(Pelaaja pelaaja) {
        tikinVoittavaPelaaja.add(pelaaja);
    }
    
    /*
    * Metodin tarkoitus on selventää vain valtin vaihtoa.
    * Jokaisen kierroksen alussa valttia ei ole, vaan se pitää julistaa
    * erikseen ja yhden kierroksen aikana voi julistaa myös useamman valtin.
    */
    public void vaihdaValtti(Maa maa) {
        valtti = maa;
        tikit.get(tikit.size()-1).vaihdaValtti(valtti);
    }
    
    public boolean vuorossaOlevaPelaajaPelaaKortin(Pelaaja pelaaja, int kortti) {
        Tikki tikki = tikit.get(tikit.size()-1);
        return tikki.vuorossaOlevaPelaajaPelaaKortin(pelaaja, kortti);
    }
    
    public boolean siirrytaanSeuraavaanTikkiin() {
        if (tikit.get(tikit.size() - 1).getKortit().size() == 4) {
            tikit.add(new Tikki());
            return true;
        } else {
            return false;
        }
    }
    
}
