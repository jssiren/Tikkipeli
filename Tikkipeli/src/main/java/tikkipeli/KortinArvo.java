package tikkipeli;

public enum KortinArvo {
    k6("6", 6), k7("7", 7), k8("8", 8), k9("9", 9), k10("10", 14), kJ("J", 11), kQ("Q", 12), kK("K", 13), kA("A", 15);

    private final int arvo;
    private final String arvoString;

    private KortinArvo(String blaa, int arvo) {
        this.arvoString = blaa;
        this.arvo = arvo;
    }
    
    public int getKortinArvo() {
        return this.arvo;
    }
    
    @Override
    public String toString() {
        return arvoString;
    }

}
