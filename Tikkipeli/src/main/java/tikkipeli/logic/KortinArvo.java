package tikkipeli.logic;

/**
 * KortinArvo on tehty enumiksi sillä kymppi on Tikkipelissä järjestyksessä
 * toiseksi suurin kortti, Ässän jälkeen. Aina kun haetaan kortin arvoa ja
 * selvitetään tikin voittanutta korttia ei näin ollen tarvitse erikseen asettaa
 * lisäehtoa ottamaan huomioon onko kymppi pelattu tikkiin vai ei.
 *
 * @author janne
 */
public enum KortinArvo {
    k6("6", 6, 0), k7("7", 7, 0), k8("8", 8, 0), k9("9", 9, 0), k10("10", 14, 10), kJ("J", 11, 5), kQ("Q", 12, 5), kK("K", 13, 5), kA("A", 15, 10);

    private final int arvo;
    private final String arvoString;
    private final int pisteet;

    /**
     * Kortin arvo määräytyy sen arvosta.
     *
     * @param blaa On arvon string
     * @param arvo On arvon numeroArvo
     * @param pisteet On arvon mukainen pistemäärä
     */
    private KortinArvo(String nimi, int arvo1, int pisteet1) {
        arvoString = nimi;
        arvo = arvo1;
        pisteet = pisteet1; 

    }

    public int getKortinArvo() {
        return this.arvo;
    }

    public String getKortinArvoString() {
        return arvoString;
    }
    
    public int getKortinArvonPisteet() {
        return pisteet;
    }

    @Override
    public String toString() {
        return arvoString;
    }

}
