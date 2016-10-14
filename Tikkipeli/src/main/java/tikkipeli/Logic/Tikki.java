package tikkipeli.Logic;

import java.util.*;

/**
 * Tikki on neljän kortin kokoelma, joka muistaa meneillä olevan kierroksen
 * valtin.
 *
 * @author janne
 */
public class Tikki {

    private ArrayList<Kortti> tikinKortit;
    private ArrayList<Integer> pelaajat;
    private Maa valtti;

    /**
     *
     * @param valttiMaa
     */
    public Tikki() {
        this.tikinKortit = new ArrayList<>();
        pelaajat = new ArrayList<>();
        valtti = Maa.TYHJA;
    }

    /**
     *
     * @return
     */
    public ArrayList<Kortti> getKortit() {
        return this.tikinKortit;
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
     * Metodilla asetetaan pelaajan kädestä tikkiin kortti ja samalla
     * tarkistetaan voiko näin tehdä sääntöjen puitteissa. Pelissä on aina
     * muistettava ylimenopakko ja maantunnustuspakko.
     *
     * @param moneskoKortti
     * @param pelaaja
     *
     * @return
     */
    public boolean lisaaKorttiTikkiin(int moneskoKortti, Pelaaja pelaaja) {
        if (voikoKortinPelataTikkiin(moneskoKortti, pelaaja)) {
            tikinKortit.add(pelaaja.getKasi().getKortit().get(moneskoKortti));
            pelaaja.getKasi().poistaKorttiKadesta(pelaaja.getKasi().getKortit().get(moneskoKortti));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodi kertoo mikä kortti voittaa kullakin hetkellä tikin seuraten pelin
     * korttijärjestyksen logiikkaa riippuen kuinka monta korttii on pelattu
     * tikkiin.
     *
     * @return
     */
    public Kortti tikinVoittavaKortti() {
        Kortti kortti = tikinKortit.get(0); // tikin aloittava kortti
        if (valtti.equals(Maa.TYHJA)) {
            for (Kortti kortti1 : tikinKortit) {
                if (kortti1.getMaa().equals(kortti.getMaa()) && kortti1.getArvo() > kortti.getArvo()) {
                    kortti = kortti1;
                }
            }
            return kortti;
        } else {
            for (Kortti kortti1 : tikinKortit) {
                if (!kortti.getMaa().equals(valtti) && kortti1.getMaa().equals(valtti)) {
                    kortti = kortti1;
                } else if (kortti.getMaa().equals(valtti) && kortti1.getMaa().equals(valtti) && (kortti1.getArvo() > kortti.getArvo()) ) {
                    kortti = kortti1;
                }
            }
            return kortti;
        }
    }

    private boolean tikkiinPelattuValttia() {
        if (!tikinKortit.isEmpty()) {
            for (Kortti kortti : tikinKortit) {
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

        if (tikinKortit.isEmpty()) {
            return true;
        } else {
            Kortti tikinAloitusKortti = tikinKortit.get(0);
            Kortti tikinJohtavaKortti = tikinVoittavaKortti();
            if (pelaajanKasi.loytyykoKadestaSamaaMaataJaIsompaa(tikinJohtavaKortti) && (pelattavaKortti.getArvo() < tikinJohtavaKortti.getArvo() || pelattavaKortti.getMaa().equals(tikinJohtavaKortti.getMaa()))) {
                return false;
            } else {
                return true;
            }
//            
//            if (valtti == Maa.TYHJA || (valtti != Maa.TYHJA && (tikinAloitusKortti.getMaa().equals(pelattavaKortti.getMaa()) && pelattavaKortti.getMaa().equals(valtti) || !tikkiinPelattuValttia()))) {
//                if (pelaajanKasi.loytyykoKadestaSamaaMaataJaIsompaa(tikinJohtavaKortti) && pelattavaKortti.getArvo() < tikinJohtavaKortti.getArvo()) {
//                    return false;
//                } else if (pelaajanKasi.loytyykoKadestaMaata(tikinJohtavaKortti.getMaa()) && !pelattavaKortti.getMaa().equals(tikinJohtavaKortti.getMaa())) {
//                    return false;
//                } else {
//                    return true;
//                }
//            } else if (!tikinAloitusKortti.getMaa().equals(valtti) && tikinAloitusKortti.getMaa().equals(pelattavaKortti.getMaa())) {
//                if (tikkiinPelattuValttia()) {
//                    return true;
//                } else {
//                    return false;
//                }
//            } else {
//                return true;
//            }
        }
    }

    public int tikinPisteet() {
        int pisteet = 0;
        for (Kortti kortti : tikinKortit) {
            pisteet += kortti.getPisteet();
        }
        return pisteet;
    }
}
