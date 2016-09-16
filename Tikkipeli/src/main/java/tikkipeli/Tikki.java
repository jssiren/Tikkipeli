package tikkipeli;

import java.util.*;

public class Tikki {
    private int moneskoTikki;
    private HashMap pelatutKortit;
    
    public Tikki() {
        this.pelatutKortit = new HashMap<Kortti, Pelaaja>();
    }
    
    public HashMap<Kortti, Pelaaja> getKortit() {
        return this.pelatutKortit;
    }
    
//    public void lisaaKorttiTikkiin(Kortti kortti) {
//        this.kortit.add(kortti);
//    }
    
    
}
