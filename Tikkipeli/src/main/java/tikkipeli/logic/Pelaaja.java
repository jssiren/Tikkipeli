package tikkipeli.logic;

/**
 * Pelaaja on pelin osallistuja, jolla on nimi ja käsi kortteja.
 *
 * @author janne
 */
public class Pelaaja {

    private Kasi kasi;
    private String nimi;

    /**
     * Pelaaja muistaa nimensä ja kätensä.
     * @param nimi Pelaajan nimi
     */
    public Pelaaja(String nimi) {
        this.kasi = new Kasi();
        this.nimi = nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setKasi(Kasi kasi) {
        this.kasi = kasi;
    }

    public String getNimi() {
        return this.nimi;
    }

    public Kasi getKasi() {
        return this.kasi;
    }

    /**
     * Metodi tarkistaa voiko kortin poistaa, ja jos voi niin poistaa sen
     * kädestä.
     *
     * @param kortti Poistettava kortti
     *
     * @see tikkipeli.Logic.Kasi#poistaKortit()
     *
     * @return tosi jos poisto onnistui, epätosi jos epäonnistui
     */
    public boolean poistaKortti(int kortti) {
        if (kasi.poistaKorttiKadesta(kortti)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodi asettaa kädessä olevat kortit järjestykseen.
     *
     * @see tikkipeli.Logic.Kasi#kortitJarjestykseen()
     */
    public void kortitJarjestykseen() {
        this.kasi.kortitJarjestykseen();
    }

    @Override
    public String toString() {
        return this.nimi + " " + this.kasi.toString();
    }

    /**
     * Metodi poistaa pelaajan kädessä olevat kortit, eli tyhjentää käden.
     *
     * @see tikkipeli.Logic.Kasi#poistaKortit()
     */
    public void poistaKortit() {
        kasi.poistaKortit();
    }

    /**
     * Metodi tarkistaa ovatko pelaajat samoja. Nimien yksilöllisyys riittää.
     *
     * @param pelaaja Pelaaja johon verrataan
     * @return tosi jos pelaajat ovat samoja, epätos muulloin
     */
    public boolean equals(Pelaaja pelaaja) {
        if (this.nimi.matches(pelaaja.getNimi())) {
            return true;
        } else {
            return true;
        }
    }

}
