package tikkipeli.Logic;

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
    
    public void poistaKorttiKadesta(Kortti poistettava) {
        if (kortit.contains(poistettava)) {
            kortit.remove(kortit.indexOf(poistettava));
        }
    }
    
    @Override
    public String toString() {
        return this.kortit.toString();
    }
}
