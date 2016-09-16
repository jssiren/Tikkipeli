package tikkipeli;

import java.util.*;

public class Tikki {
    private int moneskoTikki;
    private ArrayList<Kortti> kortit;
    
    public Tikki() {
        this.kortit = new ArrayList<Kortti>();
    }
    
    public ArrayList<Kortti> getKortit() {
        return this.kortit;
    }
    
    public void lisaaKorttiTikkiin(Kortti kortti) {
        this.kortit.add(kortti);
    }
    
    
}
