package tikkipeli.logic;

import java.util.*;

/**
 * Tikki on neljän kortin kokoelma, joka muistaa meneillä olevan kierroksen
 * valtin.
 *
 * @author janne
 */
public class Tikki {

    private ArrayList<Kortti> kortit;
    private ArrayList<Pelaaja> pelaajat;

    /**
     * Tikki on lista kortteja ja pelaajia joka muistaa mikä maa on valttia.
     */
    public Tikki() {
        this.kortit = new ArrayList<>();
        pelaajat = new ArrayList<>();
    }

    public ArrayList<Kortti> getKortit() {
        return kortit;
    }
    
    public ArrayList<Pelaaja> getPelaajat() {
        return pelaajat;
    }
    
    public void setKortit(ArrayList<Kortti> korvaaja) {
        kortit = korvaaja;
    }

    /**
     * Metodi kertoo mikä kortti voittaa kullakin hetkellä tikin seuraten pelin
     * korttijärjestyksen logiikkaa riippuen kuinka monta korttii on pelattu
     * tikkiin.
     *
     * @return Kortti joka voittaa tikin
     */
    public Kortti tikinVoittavaKortti() {
        Kortti aloituskortti = kortit.get(0); // tikin aloittava kortti
        for (Kortti kortti : kortit) {
            if (kortti.getMaa().getValtinArvo() == aloituskortti.getMaa().getValtinArvo() && kortti.getArvo() > aloituskortti.getArvo()) {
                aloituskortti = kortti;
            }
        }
        return aloituskortti;
    }

    /**
     * Metodi palauttaa toden mikäli kortin voi pelata kyseiseen tikkiin. Pelin
     * sääntöjen mukaan pelattavilla korteilla on maantunnustuspakko ja
     * ylimenopakko. Eli tikin aloittava kortti määrää mitä kortteja kukin
     * pelaaja voi pelata. Mikäli pelaajan omasta kädestä löytyy isompi samaa
     * maata oleva kortti se täytyy pelata. Jos valtti on julistettu ja valttia
     * on pelattu, ylimenopakko ei enää päde ellei pelaa valttimaan korttia.
     *
     * @param kortti pelattava kortti
     * @param pelaaja pelaaja jolta pelataan kortti
     *
     * @return tosi mikäli voi pelata kortin, epätosi muulloin
     */
    public boolean voikoKortinPelataTikkiin(Kortti kortti, Pelaaja pelaaja) {
        Kasi pelaajanKasi = pelaaja.getKasi();
        Kortti pelattavaKortti = kortti;
        if (kortit.isEmpty()) {
            return true;
        } else {
            Kortti tikinJohtavaKortti = tikinVoittavaKortti();
            if (pelaajanKasi.loytyykoKadestaSamaaMaataJaIsompaa(tikinJohtavaKortti)) {
                if (pelattavaKortti.getMaa().getValtinArvo() != tikinJohtavaKortti.getMaa().getValtinArvo() || pelattavaKortti.getArvo() < tikinJohtavaKortti.getArvo()) {
                    return false;
                } else {
                    return true;
                }
            } else if (pelaajanKasi.loytyykoKadestaMaata(tikinJohtavaKortti.getMaa()) && pelattavaKortti.getMaa().getValtinArvo() != tikinJohtavaKortti.getMaa().getValtinArvo()) {
                return false;
            } else {
                return true;
            }
        }
    }

    /**
     * Metodi palauttaa tikistä saatavien pisteiden lukumäärän.
     *
     * @return pisteet
     */
    public int tikinPisteet() {
        int pisteet = 0;
        for (Kortti kortti : kortit) {
            pisteet += kortti.getPisteet();
        }
        return pisteet;
    }

    /**
     * Metodi tarkistaa voiko pelaaja pelata kädestään tietyn kortin sääntöjen
     * puitteiss.
     *
     * @param pelaaja joka haluaa pelata kortin
     * @param kortti pelatatava kortti
     * @return tosi mikäli voi, epätosi muulloin
     */
    public boolean vuorossaOlevaPelaajaPelaaKortin(Pelaaja pelaaja, Kortti kortti) {
        if (voikoKortinPelataTikkiin(kortti, pelaaja) && pelaaja.poistaKortti(kortti)) {
            kortit.add(kortti);
            pelaajat.add(pelaaja);
            return true;
        } else {
            return false;
        }
    }
}
