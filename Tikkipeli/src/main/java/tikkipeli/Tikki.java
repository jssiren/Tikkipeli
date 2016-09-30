package tikkipeli;

import java.util.*;

public class Tikki {
    private final int moneskoTikki;
    private Kortti[] tikinKortit;
    
    public Tikki(int i) {
        this.tikinKortit = new Kortti[4];
        moneskoTikki = i;
    }
    
    public Kortti[] getKortit() {
        return this.tikinKortit;
    }
    
    public void lisaaKorttiPaikkaanI(int i, Kortti kortti) {
        this.tikinKortit[i] = kortti;
    }
    
    public Kortti tikinVoittavaKortti() {
        Tikkilogiikka tikkilogiikka = new Tikkilogiikka();
        return tikkilogiikka.tikinVoittavaKortti(tikinKortit);
    }
    
}
