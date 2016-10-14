package tikkipeli.logic;

import java.util.*;

/**
 * Kierros on lista tikkejä ja lista pelaajia.
 * @author janne
 */

public class Kierros {

    private ArrayList<Tikki> tikit;
    private ArrayList<Pelaaja> tikinVoittavaPelaaja;
    private Maa valtti;
    private int huudonVoittaja;
    

    /**
     * Kierrosta luodessa pitää muistaa kuka aloittaa kierroksen.
     * @param pelaaja Huutokierroksen voittaja
     */
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

    /**
     * Metodi lisää tikin tikkien listalle. Peli aina hakee viimeisimmän
     * kierroksen viimeisimmän tikin.
     */
    public void lisaaTikki() {
        tikit.add(new Tikki());
    }

    /**
     * Metodi lisää parametrin pelaajan tikin voittaneiden listalle. Listaa
     * tarvitaan kun kierroksen jälkeen lasketaan pisteitä.
     *
     * @param pelaaja Pelaaja joka on voittanut tikin
     */
    public void lisaaVoittavaPelaaja(Pelaaja pelaaja) {
        tikinVoittavaPelaaja.add(pelaaja);
    }

    /**
     * Metodin tarkoitus on selventää vain valtin vaihtoa. Jokaisen kierroksen
     * alussa valttia ei ole, vaan se pitää julistaa erikseen ja yhden
     * kierroksen aikana voi julistaa myös useamman valtin.
     *
     * @param maa Maa johon vaihdetaan valtti
     */
    public void vaihdaValtti(Maa maa) {
        valtti = maa;
        tikit.get(tikit.size() - 1).vaihdaValtti(valtti);
    }

    /**
     * Metodi lisää viimeisimpaan tikkiin kortin, jos näin voi tehdä.
     *
     * @param pelaaja Pelaaja joka on pelaamassa kortin
     * @param kortti Kortti jonka pelaaja pelaa
     * @return tosi mikäli kortin voi pelata tikkiin, epätosi muulloin
     */
    public boolean vuorossaOlevaPelaajaPelaaKortin(Pelaaja pelaaja, int kortti) {
        Tikki tikki = tikit.get(tikit.size() - 1);
        return tikki.vuorossaOlevaPelaajaPelaaKortin(pelaaja, kortti);
    }

    /**
     * Metodi tarkistaa voiko jo siirtyä seuravan tikin pelaamiseen. Tikissä on
     * aina enintaan 4 korttia.
     *
     * @return tosi mikäli voidaan siirtyä seuraavaan tikkiin
     */
    public boolean siirrytaanSeuraavaanTikkiin() {
        if (tikit.get(tikit.size() - 1).getKortit().size() == 4) {
            tikit.add(new Tikki());
            return true;
        } else {
            return false;
        }
    }

}
