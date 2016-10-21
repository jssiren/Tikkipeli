package tikkipeli.logic;

/**
 * Pelaaja on pelin osallistuja, jolla on nimi ja käsi kortteja.
 *
 * @author janne
 */
public class Pelaaja {

    private final Kasi kasi;
    private final String nimi;

    /**
     * Pelaaja muistaa nimensä ja kätensä.
     *
     * @param nimi1 Pelaajan nimi
     */
    public Pelaaja(String nimi1) {
        this.kasi = new Kasi();
        this.nimi = nimi1;
    }

    public String getNimi() {
        return this.nimi;
    }

    public Kasi getKasi() {
        return this.kasi;
    }

    /**
     * Metodi lisää pelaajan käteen parametrina annetun kortin.
     *
     * @param kortti kortti joka lisätään
     *
     * @return tosi mikäli käteen voi lisätä kortin
     */
    public boolean lisaaKorttiKateen(Kortti kortti) {
        return kasi.lisaaKorttiKateen(kortti);
    }

    /**
     * Metodi tarkistaa voiko kortin poistaa, ja jos voi niin poistaa sen
     * kädestä.
     *
     * @param kortti Poistettava kortti
     *
     * @see tikkipeli.logic.Kasi#poistaKortit()
     *
     * @return tosi jos poisto onnistui, epätosi jos epäonnistui
     */
    public boolean poistaKortti(Kortti kortti) {
        return kasi.poistaKorttiKadesta(kortti);
    }

    /**
     * Metodi asettaa kädessä olevat kortit järjestykseen.
     *
     * @see tikkipeli.logic.Kasi#kortitJarjestykseen()
     */
    public void kortitJarjestykseen() {
        kasi.kortitJarjestykseen();
    }

//    @Override
//    public String toString() {
//        return this.nimi;
//    }
    /**
     * Metodi poistaa pelaajan kädessä olevat kortit, eli tyhjentää käden.
     *
     * @see tikkipeli.logic.Kasi#poistaKortit()
     *
     * @return tosi, mikäli kortit poistetaan
     */
    public boolean poistaKortit() {
        return kasi.poistaKortit();
    }

    /**
     * Metodi tarkistaa ovatko pelaajat samoja. Nimien yksilöllisyys riittää.
     *
     * @param pelaaja Pelaaja johon verrataan
     * @return tosi jos pelaajat ovat samoja, epätos muulloin
     */
    public boolean equals(Pelaaja pelaaja) {
        if (this.nimi.matches(pelaaja.getNimi()) && kasi.equals(pelaaja.getKasi())) {
            return true;

        } else {
            return false;
        }
    }

}
