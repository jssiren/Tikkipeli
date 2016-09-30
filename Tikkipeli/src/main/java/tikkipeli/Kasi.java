package tikkipeli;

import java.util.*;

public class Kasi {
    private ArrayList<Kortti> kortit;
    
    public Kasi() {
        this.kortit = new ArrayList<Kortti>();
    }
    
    public ArrayList<Kortti> getKortit() {
        return this.kortit;
    }
    
    public void setKortit(ArrayList<Kortti> kortit) {
        this.kortit = kortit;
    }
    
    public void lisaaKorttiKateen(Kortti kortti) {
        kortit.add(kortti);
    }
    
    public void kortitJarjestykseen() {
        Collections.sort(kortit);
    }
    
    @Override
    public String toString() {
        return this.kortit.toString();
    }
}
