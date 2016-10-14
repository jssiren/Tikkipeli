package tikkipeli.Logic;

/*
* Maa on enum luokkana sillä jokaisella maalla on oma valttiarvonsa.
* Esimerkiksi jos pelin aikana julistetaan herttavaltti kyseinen
* pelipari saa 100 pistettä itselleen. Valttiarvoa käytetään myös
* korttien järjestämiseen.
*/

public enum Maa {
    HERTTA(100,"He"), RUUTU(80,"Ru"), RISTI(60,"Ri"), PATA(40,"Pa"), TYHJA(0,"X");
    
    private final int arvo;
    private final String lyhenne;
    
    private Maa(int arvo, String lyhenne) {
        this.arvo = arvo;
        this.lyhenne = lyhenne;
    }
    
    public int getValtinArvo() {
        return arvo;
    }
    
    public String getLyhenne() {
        return lyhenne;
    }
    
}
