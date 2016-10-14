package tikkipeli.logic;

/**
 * Pelissä käytettävä korttiluokka, jonka täytyy olla kykenväinen ymmärtämään
 * järjestys korttien väliltä, siksi Comparable.
 *
 * @author janne
 */
public class Kortti implements Comparable<Kortti> {

    private Maa maa;
    private KortinArvo arvo;
    private int pisteet;

    /**
     * Kortti tietää mitä maata on ja minkä arvoinen on.
     * @param maa Kortin maa
     * @param arvo Kortin arvo
     */
    public Kortti(Maa maa, KortinArvo arvo) {
        this.maa = maa;
        this.arvo = arvo;
        KortinArvo j = arvo;
        this.pisteet = 0;
        if (j.getKortinArvo() >= 11 && j.getKortinArvo() <= 13) {
            this.pisteet = 5;
        } else if (j.getKortinArvo() >= 14 && j.getKortinArvo() <= 15) {
            this.pisteet = 10;
        }
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
        return this.pisteet;
    }

    public void setPisteet(int pisteet) {
        this.pisteet = pisteet;
    }

    public void setMaa(Maa maa) {
        this.maa = maa;
    }

    public void setArvo(KortinArvo arvo) {
        this.arvo = arvo;
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