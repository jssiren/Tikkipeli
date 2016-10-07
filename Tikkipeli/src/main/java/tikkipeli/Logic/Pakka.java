package tikkipeli.Logic;

import java.util.*;

public class Pakka {

    private ArrayList<Kortti> kortit;

    public Pakka() {
        this.kortit = new ArrayList<Kortti>();

        for (Maa maa : Maa.values()) {
            for (KortinArvo arvo : KortinArvo.values()) {
                Kortti kortti1 = new Kortti(maa, arvo);
                this.kortit.add(kortti1);
            }
        }
    }

    public ArrayList<Kortti> getKortit() {
        return this.kortit;
    }

    public void tulostaPakka() {
        for (Kortti kortti : this.kortit) {
            System.out.println(kortti);
        }
    }

    @Override
    public String toString() {
        return this.kortit.toString();
    }

    public void sekoitaPakka() {
        Collections.shuffle(kortit);
    }

    public void jarjestaPakka() {
        Collections.sort(kortit);
    }

    /*
    * Metodi sekoittaa pakan, ja palauttaa listan neljästä
    * yhdeksän kortin kädestä.
    */
    public List jaaPakkaNeljaan() {
        sekoitaPakka();
        ArrayList<Kasi> pakat = new ArrayList<Kasi>();
        Kasi kasi1 = new Kasi();
        Kasi kasi2 = new Kasi();
        Kasi kasi3 = new Kasi();
        Kasi kasi4 = new Kasi();
        int i = 0;
        for (Kortti kortti : this.kortit) {
            if (i % 4 == 0) {
                kasi1.lisaaKorttiKateen(kortti);
            } else if (i % 4 == 1) {
                kasi2.lisaaKorttiKateen(kortti);
            } else if (i % 4 == 2) {
                kasi3.lisaaKorttiKateen(kortti);
            } else if (i % 4 == 3) {
                kasi4.lisaaKorttiKateen(kortti);
            }
            i++;
        }
        kasi1.kortitJarjestykseen();
        kasi2.kortitJarjestykseen();
        kasi3.kortitJarjestykseen();
        kasi4.kortitJarjestykseen();
        pakat.add(kasi1);
        pakat.add(kasi2);
        pakat.add(kasi3);
        pakat.add(kasi4);
        return pakat;
    }

}
