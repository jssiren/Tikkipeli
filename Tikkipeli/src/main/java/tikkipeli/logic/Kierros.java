package tikkipeli.logic;

import java.util.*;

/**
 * Kierros on lista tikkejä ja lista pelaajia jotka ovat voittaneet kyseiset
 * tikit.
 *
 * @author janne
 */
public class Kierros {

    private ArrayList<Tikki> tikit;
    private ArrayList<Pelaaja> tikinVoittavaPelaaja;

    /**
     * Kierrosta luodessa pitää muistaa kuka aloittaa kierroksen.
     */
    public Kierros() {
        tikit = new ArrayList<>();
        tikinVoittavaPelaaja = new ArrayList<>();
    }

    public ArrayList<Tikki> getTikit() {
        return tikit;
    }

    public ArrayList<Pelaaja> getVoittavatPelaajat() {
        return tikinVoittavaPelaaja;
    }

    /**
     * Metodi lisää viimeisimpaan tikkiin kortin, jos näin voi tehdä.
     *
     * @param pelaaja Pelaaja joka on pelaamassa kortin
     * @param kortti Kortti jonka pelaaja pelaa
     * @return tosi mikäli kortin voi pelata tikkiin, epätosi muulloin
     */
    public boolean vuorossaOlevaPelaajaPelaaKortin(Pelaaja pelaaja, Kortti kortti) {
        if (tikit.isEmpty()) {
            tikit.add(new Tikki());
        }
        Tikki tikki = tikit.get(tikit.size() - 1);
        if (tikki.vuorossaOlevaPelaajaPelaaKortin(pelaaja, kortti)) {
            if (tikki.getKortit().size() == 4) {
                int voittavanKortinIndeksi = tikki.getKortit().indexOf(tikki.tikinVoittavaKortti());
                Pelaaja voittavaPelaaja = tikki.getPelaajat().get(voittavanKortinIndeksi);
                tikinVoittavaPelaaja.add(voittavaPelaaja);
                tikit.add(new Tikki());
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodi lisää uuden tikin tikkien listalle.
     */
    public void lisaaTikki() {
        tikit.add(new Tikki());
    }

    /**
     * Metodi tarkistaa onko kierroksen viimeisin tikki tyhjä.
     *
     * @return tosi jos viimeisin tikki on tyhjä, epätosi muulloin
     */
    public boolean viimeisinTikkiTyhja() {
        if (tikit.isEmpty()) {
            return true;
        } else if (tikit.get(tikit.size() - 1).getKortit().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
