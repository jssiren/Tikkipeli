package tikkipeli.Logic;

public class Kierros {
    private Tikki[] tikit;
    private Pelaaja[] tikinVoittavaPelaaja;
    private Maa valtti;
    
    public Kierros() {
        tikit = new Tikki[9];
        tikinVoittavaPelaaja = new Pelaaja[9];
        valtti = null;
    }
    
    public Tikki[] getTikit() {
        return tikit;
    }
    
    public Pelaaja[] getVoittavatPelaajat() {
        return tikinVoittavaPelaaja;
    }
    
    /*
    * Metodin tarkoitus on selventää vain valtin vaihtoa.
    * Jokaisen kierroksen alussa valttia ei ole, vaan se pitää julistaa
    * erikseen ja yhden kierroksen aikana voi julistaa myös useamman valtin.
    */
    public void vaihdaValtti(Maa maa) {
        valtti = maa;
    }
    
}
