package tikkipeli;

/**
 *
 * @author janne
 */
public class Kierros {
    private Tikki[] tikit;
    private Pelaaja[] tikinVoittavaPelaaja;
    private Maa valtti;
    
    public Kierros() {
        tikit = new Tikki[9];
        tikinVoittavaPelaaja = new Pelaaja[9];
        valtti = null;
    }

}
