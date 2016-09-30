package tikkipeli;
/**
 *
 * @author janne
 */

import java.util.*;

public class Peli {
    
    private Scanner scanner;
    private Pelipari[] peliparit;
    private Pakka pakka;
    private List<Kierros> kierrokset;
    
    public Peli() {
        this.scanner = new Scanner(System.in); 
        this.pakka = new Pakka();
        kierrokset = new ArrayList<>();
        peliparit = new Pelipari[2];
        
    }
    
    public Pelipari[] getPeliparit() {
        return peliparit;
    }
    
    public Pelipari getPelipari(int i) {
        return peliparit[i - 1];
    }
    
}
