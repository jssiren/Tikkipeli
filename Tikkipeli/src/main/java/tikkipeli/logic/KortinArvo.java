package tikkipeli.logic;

/**
 * KortinArvo on tehty enumiksi sillä kymppi on Tikkipelissä järjestyksessä
 * toiseksi suurin kortti, Ässän jälkeen. Aina kun haetaan kortin arvoa
 * ja selvitetään tikin voittanutta korttia ei näin ollen tarvitse erikseen
 * asettaa lisäehtoa ottamaan huomioon onko kymppi pelattu tikkiin vai ei.
 * @author janne
 */

public enum KortinArvo {
    k6("6", 6), k7("7", 7), k8("8", 8), k9("9", 9), k10("10", 14), kJ("J", 11), kQ("Q", 12), kK("K", 13), kA("A", 15);

    private final int arvo;
    private final String arvoString;

    /**
     * Kortin arvo määräytyy sen arvosta.
     * @param blaa On arvon string
     * @param arvo On arvon numeroArvo
     */
    private KortinArvo(String blaa, int arvo) {
        this.arvoString = blaa;
        this.arvo = arvo;
    }

    public int getKortinArvo() {
        return this.arvo;
    }

    public String getKortinArvoString() {
        return arvoString;
    }

    @Override
    public String toString() {
        return arvoString;
    }

}
