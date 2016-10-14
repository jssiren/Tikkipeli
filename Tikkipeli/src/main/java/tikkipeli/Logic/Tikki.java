package tikkipeli.Logic;

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
    private Maa valtti;

    /**
     *
     * @param valttiMaa
     */
    public Tikki() {
        this.kortit = new ArrayList<>();
        pelaajat = new ArrayList<>();
        valtti = Maa.TYHJA;
    }

    /**
     *
     * @return
     */
    public ArrayList<Kortti> getKortit() {
        return this.kortit;
    }

    /**
     * Valtin vaihto vaikuttaa pelin kulkuun
     *
     * @param valtti
     */
    public void vaihdaValtti(Maa valtti) {
        this.valtti = valtti;
    }

    /**
     * Metodi kertoo mikä kortti voittaa kullakin hetkellä tikin seuraten pelin
     * korttijärjestyksen logiikkaa riippuen kuinka monta korttii on pelattu
     * tikkiin.
     *
     * @return
     */
    public Kortti tikinVoittavaKortti() {
        Kortti kortti = kortit.get(0); // tikin aloittava kortti
        if (valtti.equals(Maa.TYHJA)) {
            for (Kortti kortti1 : kortit) {
                if (kortti1.getMaa().equals(kortti.getMaa()) && kortti1.getArvo() > kortti.getArvo()) {
                    kortti = kortti1;
                }
            }
            return kortti;
        } else {
            for (Kortti kortti1 : kortit) {
                if (!kortti.getMaa().equals(valtti) && kortti1.getMaa().equals(valtti)) {
                    kortti = kortti1;
                } else if (kortti.getMaa().equals(valtti) && kortti1.getMaa().equals(valtti) && (kortti1.getArvo() > kortti.getArvo())) {
                    kortti = kortti1;
                }
            }
            return kortti;
        }
    }

    private boolean tikkiinPelattuValttia() {
        if (!kortit.isEmpty()) {
            for (Kortti kortti : kortit) {
                if (kortti.getMaa().equals(valtti)) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    /**
     * Metodi palauttaa toden mikäli kortin voi pelata kyseiseen tikkiin. Pelin
     * sääntöjen mukaan pelattavilla korteilla on maantunnustuspakko ja
     * ylimenopakko. Eli tikin aloittava kortti määrää mitä kortteja kukin
     * pelaaja voi pelata. Mikäli pelaajan omasta kädestä löytyy isompi samaa
     * maata oleva kortti se täytyy pelata. Jos valtti on julistettu ja valttia
     * on pelattu, ylimenopakko ei enää päde ellei pelaa valttimaan korttia.
     *
     * @param moneskoKortti
     * @param pelaaja
     *
     * @return
     */
    public boolean voikoKortinPelataTikkiin(int moneskoKortti, Pelaaja pelaaja) {
        Kasi pelaajanKasi = pelaaja.getKasi();
        Kortti pelattavaKortti = pelaajanKasi.getKortit().get(moneskoKortti);

        if (kortit.isEmpty()) {
            return true;
        } else {
            Kortti tikinAloitusKortti = kortit.get(0);
            Kortti tikinJohtavaKortti = tikinVoittavaKortti();

            if (pelaajanKasi.loytyykoKadestaSamaaMaataJaIsompaa(tikinJohtavaKortti)) {
                if (!pelattavaKortti.getMaa().equals(tikinJohtavaKortti.getMaa()) || pelattavaKortti.getArvo() < tikinJohtavaKortti.getArvo()) {
                    return false;
                } else {
                    return true;
                }
            } else if (pelaajanKasi.loytyykoKadestaMaata(tikinAloitusKortti.getMaa())) {
                if (!pelattavaKortti.getMaa().equals(tikinAloitusKortti.getMaa())) {
                    return false;
                } else {
                    return true;
                }
            } else {
                return true;
            }
        }
    }

    public int tikinPisteet() {
        int pisteet = 0;
        for (Kortti kortti : kortit) {
            pisteet += kortti.getPisteet();
        }
        return pisteet;
    }

    public boolean vuorossaOlevaPelaajaPelaaKortin(Pelaaja pelaaja, int moneskoKortti) {
        if (voikoKortinPelataTikkiin(moneskoKortti, pelaaja) && pelaaja.poistaKortti(moneskoKortti)) {
            kortit.add(pelaaja.getKasi().getKortit().get(moneskoKortti));
            pelaajat.add(pelaaja);
            return true;
        } else {
            return false;
        }
    }
}
