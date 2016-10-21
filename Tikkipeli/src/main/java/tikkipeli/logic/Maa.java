package tikkipeli.logic;

/*
* Maa on enum luokkana sillä jokaisella maalla on oma valttiarvonsa.
* Esimerkiksi jos pelin aikana julistetaan herttavaltti kyseinen
* pelipari saa 100 pistettä itselleen. Valttiarvoa käytetään myös
* korttien järjestämiseen.
 */
public enum Maa {
    HERTTA(100, "He"), RUUTU(80, "Ru"), RISTI(60, "Ri"), PATA(40, "Pa"), TYHJA(0, "X");

    private final int arvo;
    private final String lyhenne;

    /**
     * Maa on perinteiten korttien pelian maa, jolla kuitenkin valttiarvo.
     * @param arvo Valttiarvo
     * @param lyhenne Se minkä pelaaja näkee kentällä
     */
    private Maa(int arvo, String lyhenne) {
        this.arvo = arvo;
        this.lyhenne = lyhenne;
    }

    public int getValtinArvo() {
        return this.arvo;
    }

    public String getLyhenne() {
        return this.lyhenne;
    }

    /**
     * Tarkistaa ovatko kortit samaa maata.
     *
     * @param maa Maa johon verrataan
     * @return tosi jos ovat samaa maata
     */
    public boolean equals(Maa maa) {
        if (lyhenne.matches(maa.getLyhenne()) && arvo == maa.getValtinArvo()) {
            return true;
        } else {
            return false;
        }
    }

}
