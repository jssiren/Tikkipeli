package tikkipeli.Logic;

/*
* Maa on enum luokkana sillä jokaisella maalla on oma valttiarvonsa.
* Esimerkiksi jos pelin aikana julistetaan herttavaltti kyseinen
* pelipari saa 100 pistettä itselleen. Valttiarvoa käytetään myös
* korttien järjestämiseen.
*/

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
