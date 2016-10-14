package tikkipeli.logic;

import java.util.*;

/**
 * Peliluokka nivoo kaiken pelimekaanisen asian yhteen.
 *
 * @author janne
 */
public class Peli {

    private List<Pelipari> peliparit;
    private List<Pelaaja> pelaajat;
    private Pakka pakka;
    private List<Kierros> kierrokset;
    private int vuorossaOlevaPelaaja;
    private List<Huutokierros> huutokierrokset;
    private boolean[] passaukset;
    private boolean huutokierrosKaynnissa;
    private boolean kierrosKaynnissa;
    private boolean pelaajatLuotu;
    private boolean korttiPelattu;

    /**
     * Peli luo kaiken oleellisen loogisen ja mekaanisen käytettäväksi.
     */
    public Peli() {
        this.pakka = new Pakka();
        kierrokset = new ArrayList<>();
        vuorossaOlevaPelaaja = 1;
        pelaajat = new ArrayList<>();
        huutokierrokset = new ArrayList<>();
        passaukset = new boolean[4];
        huutokierrosKaynnissa = false;
        kierrosKaynnissa = false;
        pelaajatLuotu = false;

    }

    public List<Kierros> getKierrokset() {
        return this.kierrokset;
    }

    public List<Pelipari> getPeliparit() {
        return peliparit;
    }

    public List<Pelaaja> getPelaajat() {
        return this.pelaajat;
    }

    /**
     * Metodi hakee parametrin arvolla peliparin.
     * @param i peliparin indeksi
     * @return haettu pelipari
     */
    public Pelipari getPelipari(int i) {
        return peliparit.get(i);
    }

    public int getVuorossaOlevaPelaaja() {
        return vuorossaOlevaPelaaja;
    }

    public boolean getHuutokierrosKaynnissa() {
        return huutokierrosKaynnissa;
    }

    public boolean getKierrosKaynnissa() {
        return kierrosKaynnissa;
    }

    public boolean getPelaajatLuotu() {
        return pelaajatLuotu;
    }

    public boolean getKorttiPelattu() {
        return korttiPelattu;
    }

    public void setKorttiPelattu(boolean onko) {
        korttiPelattu = onko;
    }

    public void setPelaajatLuotu(boolean onko) {
        pelaajatLuotu = onko;
    }

    public void setHuutokierrosKaynnissa(boolean onko) {
        huutokierrosKaynnissa = onko;
    }

    public void setKierrosKaynnissa(boolean onko) {
        kierrosKaynnissa = onko;
    }

    /**
     * Asettaa pelaajat.
     *
     * @param nimi1 Pelaaja 1
     * @param nimi2 Pelaaja 2
     * @param nimi3 Pelaaja 3
     * @param nimi4 Pelaaja 4
     */
    public void setPelaajat(String nimi1, String nimi2, String nimi3, String nimi4) {
        pelaajat.add(new Pelaaja(nimi1));
        pelaajat.add(new Pelaaja(nimi2));
        pelaajat.add(new Pelaaja(nimi3));
        pelaajat.add(new Pelaaja(nimi4));
    }

    /**
     * Asettaa peliparit: parilliset ovat yksi, parittomat toinen.
     *
     * @param nimi1 Pelaaja 1
     * @param nimi2 Pelaaja 2
     * @param nimi3 Pelaaja 3
     * @param nimi4 Pelaaja 4
     */
    public void setPeliparit(String nimi1, String nimi2, String nimi3, String nimi4) {
        lisaaPelipari(nimi1, nimi3);
        lisaaPelipari(nimi2, nimi4);
    }

    /**
     * Metodi selkiyttää peliparien luomista.
     *
     * @param nimi1 Peliparin pelaaja 1
     * @param nimi2 Peliparin pelaaja 2
     */
    public void lisaaPelipari(String nimi1, String nimi2) {
        peliparit.add(new Pelipari(new Pelaaja(nimi1), new Pelaaja(nimi2)));
    }

    /**
     * Metodi jakaa pelaajille kortit.
     */
    public void jaaPelaajilleKortit() {
        if (!pelaajat.get(0).getKasi().getKortit().isEmpty()) {
            poistaPelaajienKortit();
        }
        pakka.sekoitaPakka();
        int i = 0;
        for (Kortti kortti : pakka.getKortit()) {
            int j = i % 4;
            pelaajat.get(j).getKasi().lisaaKorttiKateen(kortti);
            i++;
        }
        jarjestaPelaajienKortit();
        asetaPassauksetFalse();
    }

    /**
     * Metodi järjestää pelaajien kortit.
     *
     * @see tikkipeli.Logic.Pelaaja#kortitJarjestykseen()
     */
    public void jarjestaPelaajienKortit() {
        for (Pelaaja pelaaja : pelaajat) {
            pelaaja.kortitJarjestykseen();
        }
    }

    /**
     * Metodi poistaa kaikkien pelaajien kortit.
     *
     * @see tikkipelli.Logic.Pelaaja#poistaKortit()
     */
    public void poistaPelaajienKortit() {
        for (Pelaaja pelaaja : pelaajat) {
            pelaaja.poistaKortit();
        }
    }

    /**
     * Metodi asettaa pelivuoron pelaajalle j. Tikin voittotapaus on yksi
     * näistä.
     *
     * @param j pelivuoroon asettettavan pelaajan indeksi
     */
    public void setPelivuorossaOlevaPelaaja(int j) {
        if (j >= 0 && j <= 3) {
            this.vuorossaOlevaPelaaja = j;
        }
    }

    /**
     * Metodi siirtää vuoron seuraavalle pelaajalle. Kortin pelaamisen tai
     * huudon tekemisen jälkeen näin tehdään.
     */
    public void siirrySeuraavaanPelaajaan() {
        vuorossaOlevaPelaaja = seuraavaPelaaja();
    }

    /**
     * Metodi tarkistaa kuka pelaajista on pelivuorossa. Huutokierroksen aikana
     * tarvittava passaukset lista käydään läpi.
     *
     * @return palauttaa pelaajan indeksin joka on seuraavana pelivuorossa.
     */
    public int seuraavaPelaaja() {
        int seuraavaPelaaja = 1;
        while (true) {
            if (passaukset[(vuorossaOlevaPelaaja + seuraavaPelaaja) % 4]) {
                seuraavaPelaaja++;
            } else {
                break;
            }
        }
        return (vuorossaOlevaPelaaja + seuraavaPelaaja) % 4;
    }

    /**
     * Metodi asettaa yksittäiselle passaukselle totuusarvon.
     *
     * @param i monesko passaus
     * @param onko asetetaan totuusarvo
     */
    public void setPassaukset(int i, boolean onko) {
        passaukset[i] = onko;
    }

    /**
     * Kun kierros päättyy tarvitaan uusi kierros, ja kierrokselle ensimmäinen
     * tikki.
     */
    public void lisaaKierros() {
        this.kierrokset.add(new Kierros(vuorossaOlevaPelaaja));
        this.kierrokset.get(this.kierrokset.size() - 1).lisaaTikki();
    }

    /**
     * Metodi lisää käydyn huutokierroksen listalle.
     *
     * @param voittohuuto määrä jolla huutokierros voitettiin
     */
    public void lisaaHuutokierros(int voittohuuto) {
        this.huutokierrokset.add(new Huutokierros(voittohuuto, vuorossaOlevaPelaaja));
        asetaPassauksetFalse();
    }

    /**
     * Metodi asettaa kaikki passaukset epätosiksi. Tätä tarvitaan
     * huutokierroksen päätteksi, kun huudon voittaja on selvillä. Ja ei haluta
     * vaikuttaa kierroksen kulkuun, koska kierroksen aikana kaikkien täytyy
     * olla kykeneväisiä pelaamaan.
     */
    public void asetaPassauksetFalse() {
        for (int i = 0; i < 4; i++) {
            passaukset[i] = false;
        }
    }

    /**
     * Metodi palauttaa toden mikäli kolme pelaajaa ovat passanneet
     * huutokierroksen aikana.
     *
     * @return tosi mikäi on kolme passausta.
     */
    public boolean passauksiaKolme() {
        int lkm = 0;
        for (int i = 0; i < 4; i++) {
            if (passaukset[i]) {
                lkm++;
            }
        }
        if (lkm == 3) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodi palauttaaa toden mikäli kierros päättyy.
     *
     * @return tosi mikäli kierros päätty
     */
    public boolean paattyykoKierros() {
        if (pelaajat.get(seuraavaPelaaja()).getKasi().getKortit().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodi asettaa oikean pelaajalle pelivuoron. Ensmmäisen kierroksen
     * aloittaa aina Pelaaja 1, toisen Pelaaja 2, jne.
     */
    public void aloitaUusiKierros() {
        vuorossaOlevaPelaaja = (kierrokset.size() - 1) % 4;
    }

    /**
     * Metodi palauttaa toden mikäli pelivuorossa oleva pelaaja voi pelata
     * kyseisen kortin kädestä.
     *
     * @param kortti kortti joka aiotaan pelata
     * @return tosi mikäli voi pelata, epätosi muulloin
     */
    public boolean vuorossaOlevaPelaajaPelaaKortin(int kortti) {
        Kierros kierros = kierrokset.get(kierrokset.size() - 1);
        return kierros.vuorossaOlevaPelaajaPelaaKortin(pelaajat.get(vuorossaOlevaPelaaja), kortti);
    }

}
