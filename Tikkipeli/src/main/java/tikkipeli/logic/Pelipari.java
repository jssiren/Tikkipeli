package tikkipeli.logic;

/**
 * Pelipari on kahden pelaajan kokoelma joka muistaa pistemäärät.
 *
 * @author janne
 */
public class Pelipari {

    private Pelaaja[] parinPelaajat;
    private int pisteet;

    /**
     * Pelipari koostuu kahdesta pelaajasta ja muistaa pisteiden lukumäärän.
     * @param pelaaja1 parin pelaaja 1
     * @param pelaaja2 parin pelaaja 2
     */
    public Pelipari(Pelaaja pelaaja1, Pelaaja pelaaja2) {
        this.parinPelaajat = new Pelaaja[2];
        parinPelaajat[0] = pelaaja1;
        parinPelaajat[1] = pelaaja2;
        pisteet = 0;
    }

    public Pelaaja[] getPelaajat() {
        return parinPelaajat;
    }

    public Pelaaja getPelaaja1() {
        return parinPelaajat[0];
    }

    public Pelaaja getPelaaja2() {
        return parinPelaajat[1];
    }

    public int getPisteet() {
        return this.pisteet;
    }

    /**
     * Lisää tarvittavan määrän pisteitä peliparille.
     *
     * @param pisteita Lisättävien pisteiden lkm
     */
    public void lisaaPisteita(int pisteita) {
        this.pisteet += pisteita;
    }

    @Override
    public String toString() {
        return parinPelaajat[0].getNimi() + " " + parinPelaajat[1].getNimi() + " " + pisteet;
    }

    /**
     * Metodi järjestää pelaajien kortit.
     *
     * @see tikkipeli.Logic.Pelaaja#kortitJarjestykseen()
     */
    public void jarjestaPelaajienKortit() {
        for (Pelaaja pelaaja : parinPelaajat) {
            pelaaja.kortitJarjestykseen();
        }
    }

    /**
     * Metodi poistaa pelaajien kortit.
     *
     * @see tikkipeli.Logic.Pelaaja#poistaKortit()
     */
    public void poistaPelaajienKortit() {
        for (Pelaaja pelaaja : parinPelaajat) {
            pelaaja.poistaKortit();
        }
    }

}
