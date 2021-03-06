package tikkipeli.logic;

/**
 * Luokan tarkoitus on säilyttää tieto kuka pelaajista on voittanut huudon ja
 * millä määrällä.
 *
 * @author janne
 *
 */
public class Huutokierros {

    private final int voittohuuto;
    private final int huudonVoittaja;

    /**
     * Huutokierros muistaa voittajan ja luvun jolla on voitett huutokierros.
     *
     * @param voittaja Huudon voittaja
     * @param luku Voitettava luku
     */
    public Huutokierros(int voittaja, int luku) {
        huudonVoittaja = voittaja;
        voittohuuto = luku;
    }

    public int getHuudonVoittaja() {
        return this.huudonVoittaja;
    }

    public int getVoittohuuto() {
        return voittohuuto;
    }

}
