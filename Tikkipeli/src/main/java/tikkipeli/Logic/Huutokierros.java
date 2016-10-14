package tikkipeli.Logic;

/**
 *
 * @author janne
 */
public class Huutokierros {
    
    private int voittohuuto;
    private int huudonVoittaja;
    
    public Huutokierros(int luku, int voittaja) {
        huudonVoittaja = voittaja;
        voittohuuto = luku;
    }
    
    public int getHuudonVoittaja() {
        return this.huudonVoittaja;
    }
    
    public int getVoittohuuto() {
        return voittohuuto;
    }
    
    
    
}
