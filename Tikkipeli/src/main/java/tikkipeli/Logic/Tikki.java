package tikkipeli.Logic;

import java.util.*;

public class Tikki {
    private ArrayList<Kortti> tikinKortit;
    
    public Tikki(int i) {
        this.tikinKortit = new ArrayList<Kortti>();
    }
    
    public ArrayList<Kortti> getKortit() {
        return this.tikinKortit;
    }
    
    public void lisaaKorttiTikkiin(Kortti kortti) {
        tikinKortit.add(kortti);
    }
    
    /*
    * Tikkilogiikassa tämä logiikka ilmenee
    */
    public Kortti tikinVoittavaKortti() {
        Tikkilogiikka tikkilogiikka = new Tikkilogiikka();
        return tikkilogiikka.tikinVoittavaKortti(tikinKortit);
    }
    
}
