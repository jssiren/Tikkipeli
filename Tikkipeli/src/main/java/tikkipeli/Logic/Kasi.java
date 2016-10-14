package tikkipeli.Logic;

import java.util.*;

/**
 *
 * @author janne
 */
public class Kasi {
    private ArrayList<Kortti> kortit;
    
    /**
     *
     */
    public Kasi() {
        this.kortit = new ArrayList<Kortti>();
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Kortti> getKortit() {
        return this.kortit;
    }
    
    /**
     *
     * @param kortit
     */
    public void setKortit(ArrayList<Kortti> kortit) {
        this.kortit = kortit;
    }
    
    public void lisaaKorttiKateen(Kortti kortti) {
        kortit.add(kortti);
    }
    

    /**
     * Metodi laittaa kortit kädessä olevat kortit järjestykseen.
     */
    public void kortitJarjestykseen() {
        Collections.sort(kortit);
    }
    
    /**
     * Kortti poistetaan kädestä kun se pelataan.
     * @param poistettava
     * @return
     */
    public boolean poistaKorttiKadesta(int poistettava) {
        if(kortit.isEmpty()) {
            return false;
        } else {
            kortit.remove(poistettava);
            return true;
        }
        
    }
    
    @Override
    public String toString() {
        String kortit = "Kortit:";
        for (Kortti kortti : this.kortit) {
            kortit = kortit + "  " + kortti.toString();
        }
        return kortit;
    }
    
    /**
     * Metodi tarkistaa löytyykö pelaajan kädestä kysyttyä maata.
     * @param maa
     * @return
     */
    public boolean loytyykoKadestaMaata(Maa maa) {
        if (!kortit.isEmpty()) {
            for (Kortti kortti : kortit) {
                if (kortti.getMaa().equals(maa)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Metodi tarkistaa löytyykö pelaajan kädestä samaa maata ja arvoltaan isompaa korttia
     * kuin ylitettävä kortti. Muistetaan että pelissä kuitenkin on ylimenopakko ja 
     * maan tunnustuspakko.
     * @param ylitettava
     * @return
     */
    public boolean loytyykoKadestaSamaaMaataJaIsompaa(Kortti ylitettava) {
        if(kortit.isEmpty()) {
            return false;
        } else {
            if (loytyykoKadestaMaata(ylitettava.getMaa())) {
                for (Kortti kortti : kortit) {
                    if (kortti.getArvo() > ylitettava.getArvo() && kortti.getMaa().equals(ylitettava.getMaa())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public void poistaKortit() {
        kortit.clear();
    }
    
    public boolean onkoKadessaKorttia(Kortti haettava) {
        for (Kortti kortti : kortit) {
            if (kortti.equals(haettava)) {
                return true;
            }
        }
        return false;
    }
}
