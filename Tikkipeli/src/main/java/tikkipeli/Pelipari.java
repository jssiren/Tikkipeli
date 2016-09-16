package tikkipeli;

import java.util.*;

public class Pelipari {
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    
    public Pelipari(Pelaaja pelaaja1, Pelaaja pelaaja2) {
        this.pelaaja1 = pelaaja1;
        this.pelaaja2 = pelaaja2;
    }
    
    public Pelaaja getPelaaja1() {
        return this.pelaaja1;
    }
    
    public Pelaaja getPelaaja2() {
        return this.pelaaja2;
    }

    
}
