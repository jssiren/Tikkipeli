package tikkipeli.Logic;

import java.util.*;

public class Pakka {

    private ArrayList<Kortti> kortit;

    public Pakka() {
        this.kortit = new ArrayList<Kortti>();

        for (Maa maa : Maa.values()) {
            for (KortinArvo arvo : KortinArvo.values()) {
                if (!maa.equals(Maa.TYHJA)) {
                    this.kortit.add(new Kortti(maa, arvo));
                }
                
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

}
