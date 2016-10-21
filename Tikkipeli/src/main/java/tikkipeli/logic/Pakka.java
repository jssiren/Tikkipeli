package tikkipeli.logic;

import java.util.*;

/**
 * Pakka toimii 36 kortin kokoelmana, josta jaetaan pelaajille kortit.
 *
 * @author janne
 */
public class Pakka {

    private ArrayList<Kortti> kortit;

    /**
     * Pakka koostuu korteista ja kortit lisätään automaattisesti pakkaan.
     */
    public Pakka() {
        this.kortit = new ArrayList<Kortti>();

        for (Maa maa : Maa.values()) {
            for (KortinArvo arvo : KortinArvo.values()) {
                if (maa.getValtinArvo() > 0) {
                    this.kortit.add(new Kortti(maa, arvo));
                }

            }
        }
    }

    public ArrayList<Kortti> getKortit() {
        return this.kortit;
    }

// Metodia ei tarvita pelin pyörimiseen. Vain korttien tarkastusta varten.
//    /**
//     * Metodi tulostaa pakan kortit. Käytetään lähinnä korttien tarkistamiseen.
//     */
//    public void tulostaPakka() {
//        if (!kortit.isEmpty()) {
//            for (Kortti kortti : this.kortit) {
//                System.out.println(kortti);
//            }
//        }
//    }
    /**
     * Metodi sekoittaa pakan kortit.
     */
    public void sekoitaPakka() {
        if (!kortit.isEmpty()) {
            Collections.shuffle(kortit);
        }
    }

    /**
     * Metodi järjestaa pakan kortit.
     */
    public void jarjestaPakka() {
        Collections.sort(kortit);

    }

}
