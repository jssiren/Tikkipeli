package tikkipeli;

public class Kortti {
    private int maa;
    private int arvo;
    private int pisteet;
    
    public Kortti(int maa, int arvo) {
        this.maa = maa;
        this.arvo = arvo;
        this.pisteet = 0;
    }
    
    @Override
    public String toString() {
        return "maa" + this.maa + "arvo" + this.arvo + "pisteet" + this.pisteet;
    }

    private int getMaa() {
        return this.maa;
    }
    
    public int getArvo() {
        return this.arvo;
    }
    
    public int getPisteet() {
        return this.pisteet;
    }
    
    public void setPisteet(int pisteet) {
        this.pisteet = pisteet;
    }
    
    public void setMaa(int maa) {
        this.maa = maa;
    }
    
    public void setArvo(int arvo) {
        this.arvo = arvo;
    }
}
