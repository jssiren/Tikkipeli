package tikkipeli.logic;

/**
 * Pelissä käytettävä korttiluokka, jonka täytyy olla kykenväinen ymmärtämään
 * järjestys korttien väliltä, siksi Comparable.
 *
 * @author janne
 */
public class Kortti implements Comparable<Kortti> {

    private final Maa maa;
    private final KortinArvo arvo;
    
    /**
     * Kortti tietää mitä maata on ja minkä arvoinen on.
     * @param maa Kortin maa
     * @param arvo Kortin arvo
     */
    public Kortti(Maa maa, KortinArvo arvo) {
        this.maa = maa;
        this.arvo = arvo;
    }

    @Override
    public String toString() {
        return maa.getLyhenne() + "" + arvo.toString();
    }

    public Maa getMaa() {
        return maa;
    }

    public int getArvo() {
        return this.arvo.getKortinArvo();
    }

    public int getPisteet() {
        return this.arvo.getKortinArvonPisteet();
    }

    /**
     * Metodin avulla määritetään ovatko kortit samoja.
     * 
     * @param kortti kortti johon verrataan
     * @return palauttaa toden mikäli korttien maat ja arvot samoja
     */
    public boolean equals(Kortti kortti) {
        if (kortti.getMaa().equals(maa) && kortti.getArvo() == arvo.getKortinArvo()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * compareTo metodin avulla kädessä olevat kortit laitetaan järjestykseen
     * maittain hertasta pataan ja maan sisällä myös suuruusjärjestykseen.
     *
     * @param muuKortti Kortti johon verrataan
     */
    @Override
    public int compareTo(Kortti muuKortti) {
        if (this.maa.getValtinArvo() == muuKortti.getMaa().getValtinArvo()) {
            if (this.arvo.getKortinArvo() == muuKortti.getArvo()) {
                return 0;
            } else if (this.arvo.getKortinArvo() < muuKortti.getArvo()) {
                return -1;
            } else {
                return +1;
            }
        } else if (this.maa.getValtinArvo() < muuKortti.getMaa().getValtinArvo()) {
            return +1;
        } else {
            return -1;
        }
    }
}
