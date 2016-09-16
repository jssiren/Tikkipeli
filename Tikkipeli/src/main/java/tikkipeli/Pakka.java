package tikkipeli;

import java.util.*;

public class Pakka {

    private ArrayList<Kortti> kortit;

    public Pakka() {
        this.kortit = new ArrayList<Kortti>();
        int i = 0;
        for (i = 0; i <= 3; i++) {
            int j = 6;
            for (j = 6; j <= 15; j++) {
                if (j != 10) {
                    Kortti kortti = new Kortti(i, j);
                    if (j >= 11 && j <= 13) {
                        kortti.setPisteet(5);
                        this.kortit.add(kortti);
                    } else if (j >= 14) {
                        kortti.setPisteet(10);
                        this.kortit.add(kortti);
                    } else {
                        this.kortit.add(kortti);
                    }   
                }
            }
        }
    }

    public void lisaaKortti() {
        Kortti kortti = new Kortti(0, 0);
        kortti.setMaa(2);
        kortti.setArvo(3);
        this.kortit.add(kortti);
    }

    public void lisaaKortit() {
        int i = 0;
        for (i = 0; i <= 3; i++) {
            int j = 6;
            for (j = 6; j <= 15; j++) {
                if (j != 10) {
                    Kortti kortti = new Kortti(i, j);
                    if (j >= 11 && j <= 13) {
                        kortti.setPisteet(5);
                        this.kortit.add(kortti);
                    } else if (j >= 14) {
                        kortti.setPisteet(10);
                        this.kortit.add(kortti);
                    } else {
                        this.kortit.add(kortti);
                    }
                    
                }

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
