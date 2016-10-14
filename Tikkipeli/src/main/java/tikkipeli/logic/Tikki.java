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
    private Maa valtti;

    /**
     * Tikki on lista kortteja ja pelaajia joka muistaa mikä maa on valttia.
     */
    public Tikki() {
        this.kortit = new ArrayList<>();
        pelaajat = new ArrayList<>();
        valtti = Maa.TYHJA;
    }

    public ArrayList<Kortti> getKortit() {
        return this.kortit;
    }

    /**
     * Valtin vaihto vaikuttaa pelin kulkuun.
     *
     * @param valtti Maa johon valtti vaihdetaan.
     */
    public void vaihdaValtti(Maa valtti) {
        this.valtti = valtti;
    }

    /**
     * Lisää kortin tikkiin.
     * 
     * @param kortti Lisättävä kortti
     * @param pelaaja pelaaja joka pelaa kortin
     */
    public void lisaaKorttiTikkiin(Kortti kortti, Pelaaja pelaaja) {
        kortit.add(kortti);
        pelaajat.add(pelaaja);
    }

    /**
     * Metodi kertoo mikä kortti voittaa kullakin hetkellä tikin seuraten pelin
     * korttijärjestyksen logiikkaa riippuen kuinka monta korttii on pelattu
     * tikkiin.
     *
     * @return Kortti joka voittaa tikin
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

//    private boolean tikkiinPelattuValttia() {
//        if (!kortit.isEmpty()) {
//            for (Kortti kortti : kortit) {
//                if (kortti.getMaa().equals(valtti)) {
//                    return true;
//                }
//            }
//            return false;
//        } else {
//            return false;
//        }
//    }
    /**
     * Metodi palauttaa toden mikäli kortin voi pelata kyseiseen tikkiin. Pelin
     * sääntöjen mukaan pelattavilla korteilla on maantunnustuspakko ja
     * ylimenopakko. Eli tikin aloittava kortti määrää mitä kortteja kukin
     * pelaaja voi pelata. Mikäli pelaajan omasta kädestä löytyy isompi samaa
     * maata oleva kortti se täytyy pelata. Jos valtti on julistettu ja valttia
     * on pelattu, ylimenopakko ei enää päde ellei pelaa valttimaan korttia.
     *
     * @param moneskoKortti kortin indeksi
     * @param pelaaja pelaaja jolta pelataan kortti
     *
     * @return tosi mikäli voi pelata kortin, epätosi muulloin
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
     * @param pelaaja joka haluaa pelata  kortin
     * @param moneskoKortti pelatatavan kortin indeksi
     * @return tosi mikäli voi, epätosi muulloin
     */
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
