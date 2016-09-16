package tikkipeli;

import java.util.*;

public class Pakka {
    private ArrayList<Kortti> kortit;
    
    public Pakka() {
        this.kortit = new ArrayList<Kortti>();
    }
    
    public void lisaaKortti() {
//        kortti.setMaa(2);
//        kortti.setArvo(3);
//        this.kortit.add(kortti);
        for (int i=0; i <=3; i++) {
            Kortti kortti = new Kortti(0,0);
            kortti.setMaa(i);
            for (int j=6; j<=15;i++) {
                kortti.setArvo(j);
                if (j >= 11 && j <=13) {
                    kortti.setPisteet(5);
                } else if (j > 13) {
                    kortti.setPisteet(10);
                }
                this.kortit.add(kortti);
            }
        }
    }
    
    public ArrayList<Kortti> getKortit() {
        return this.kortit;
    }
    public void tulostaPakka() {
        this.kortit.stream().forEach((kortti) -> {
            kortti.toString();
        });
    }
    
    @Override
    public String toString() {
        return this.kortit.toString();
    }
    
    
}
