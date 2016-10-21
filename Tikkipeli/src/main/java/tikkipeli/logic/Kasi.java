package tikkipeli.logic;

import java.util.*;

/**
 * Käsi toimii pelaajan korttisäilönä.
 *
 * @author janne
 */
public class Kasi {

    private ArrayList<Kortti> kortit;

    /**
     * Käsi on oleellisesti vain lista kortteja.
     */
    public Kasi() {
        this.kortit = new ArrayList<>();
    }

    public ArrayList<Kortti> getKortit() {
        return this.kortit;
    }

    public void setKortit(ArrayList<Kortti> kortit) {
        this.kortit = kortit;
    }

    /**
     * Metodi lisää kortin käteen.
     *
     * @param kortti Lisättävä kortti
     */
    public void lisaaKorttiKateen(Kortti kortti) {
        this.kortit.add(kortti);
    }

    /**
     * Metodi laittaa kortit kädessä olevat kortit järjestykseen.
     */
    public void kortitJarjestykseen() {
        Collections.sort(kortit);
    }

    /**
     * Kortti poistetaan kädestä kun se pelataan.
     *
     * @param poistettava Poistettava kortti
     * @return tosi mikäli voi poistaa
     */
    public boolean poistaKorttiKadesta(Kortti poistettava) {
        if (kortit.isEmpty()) {
            return false;
        } else {
            return kortit.remove(poistettava);
        }

    }

    @Override
    public String toString() {
        String kortit1 = "";
        for (Kortti kortti : this.kortit) {
            kortit1 = kortit1 + " " + kortti.toString();
        }
        return kortit1;
    }

    /**
     * Metodi tarkistaa löytyykö pelaajan kädestä kysyttyä maata.
     *
     * @param maa Maa jota kysytään
     * @return tosi mikäli kädestä löytyy kysyttyä maata, epätosi muulloin
     */
    public boolean loytyykoKadestaMaata(Maa maa) {
        if (!kortit.isEmpty()) {
            for (Kortti kortti : kortit) {
                if (kortti.getMaa().equals(maa)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Metodi tarkistaa löytyykö pelaajan kädestä samaa maata ja arvoltaan
     * isompaa korttia kuin ylitettävä kortti. Muistetaan että pelissä kuitenkin
     * on ylimenopakko ja maatunnustuspakko.
     *
     * @param ylitettava Kortti jonka suhteen tarkistaan miten kortti pelataan
     * @return tosi mikäli metodin nimen mukaisesti löytyy, epätosi muulloin
     */
    public boolean loytyykoKadestaSamaaMaataJaIsompaa(Kortti ylitettava) {
        if (kortit.isEmpty()) {
            return false;
        } else if (loytyykoKadestaMaata(ylitettava.getMaa())) {
            for (Kortti kortti : kortit) {
                if (kortti.getArvo() > ylitettava.getArvo() && kortti.getMaa().equals(ylitettava.getMaa())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * metodi poistaa kädessä olevat kortit.
     */
    public void poistaKortit() {
        kortit.clear();
    }

    /**
     * Metodi tarkistaa onko kädessä parametrina toimivaa korttia.
     *
     * @param haettava Kädestä haettava kortti
     * @return tosi mikäli löytyy, epätosi muulloin
     */
    public boolean onkoKadessaKorttia(Kortti haettava) {
        for (Kortti kortti : kortit) {
            if (kortti.equals(haettava)) {
                return true;
            }
        }
        return false;
    }
}
