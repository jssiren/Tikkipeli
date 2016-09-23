package tikkipeli;

public enum Maa {
    HERTTA(100), RUUTU(80), RISTI(60), PATA(40);
    
    private final int arvo;
    
    private Maa(int arvo) {
        this.arvo = arvo;
    }
    
    public int getValtinArvo() {
        return arvo;
    }
    
}
