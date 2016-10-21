package tikkipeli.logic;

import java.util.*;

/**
 * Peliluokka nivoo kaiken pelimekaanisen asian yhteen.
 *
 * @author janne
 */
public class Peli {

    private final List<Pelaaja> pelaajat;
    private final List<Integer> peliparienPisteet;
    private final Pakka pakka;
    private final List<Kierros> kierrokset;
    private int vuorossaOlevaPelaaja;
    private final List<Huutokierros> huutokierrokset;
    private final boolean[] passaukset;
    private boolean huutokierrosKaynnissa;
    private boolean kierrosKaynnissa;
    private boolean pelaajatLuotu;
    private boolean korttiPelattu;
    private final int minimiHuuto;

    /**
     * Peli luo kaiken oleellisen loogisen ja mekaanisen käytettäväksi.
     */
    public Peli() {
        this.pakka = new Pakka();
        kierrokset = new ArrayList<>();
        vuorossaOlevaPelaaja = 0;
        pelaajat = new ArrayList<>();
        huutokierrokset = new ArrayList<>();
        peliparienPisteet = new ArrayList<>();
        passaukset = new boolean[4];
        huutokierrosKaynnissa = false;
        kierrosKaynnissa = false;
        pelaajatLuotu = false;
        minimiHuuto = 50;

    }

    public List<Kierros> getKierrokset() {
        return this.kierrokset;
    }

    public List<Pelaaja> getPelaajat() {
        return this.pelaajat;
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

    public Pakka getPakka() {
        return pakka;
    }

    public boolean[] getPassaukset() {
        return passaukset;
    }

    public List<Integer> getPeliparienPisteet() {
        return peliparienPisteet;
    }

    public int getMinimiHuuto() {
        return minimiHuuto;
    }

    public List<Huutokierros> getHuutokierrokset() {
        return huutokierrokset;
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
     * Metodi asettaa pelaajat.
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
     * Metodi asettaa peliparien pisteet nolliksi.
     */
    public void asetaPisteetNolliksi() {
        if (peliparienPisteet.isEmpty()) {
            peliparienPisteet.add(0);
            peliparienPisteet.add(0);
        }
        peliparienPisteet.set(0, 0);
        peliparienPisteet.set(1, 0);
    }

    /**
     * Metodi jakaa pelaajille kortit.
     */
    public void jaaPelaajilleKortit() {
        if (!pelaajat.get(0).getKasi().getKortit().isEmpty()) {
            poistaPelaajienKortit();
        }
        pakka.sekoitaPakka();
        for (Kortti kortti : pakka.getKortit()) {
            pelaajat.get(pakka.getKortit().indexOf(kortti) % 4).lisaaKorttiKateen(kortti);
        }
        jarjestaPelaajienKortit();
        asetaPassauksetFalse();
    }

    /**
     * Metodi järjestää pelaajien kortit.
     *
     * @see tikkipeli.logic.Pelaaja#kortitJarjestykseen()
     */
    public void jarjestaPelaajienKortit() {
        for (Pelaaja pelaaja : pelaajat) {
            pelaaja.kortitJarjestykseen();
        }
    }

    /**
     * Metodi poistaa kaikkien pelaajien kortit.
     *
     * @see tikkipeli.logic.Pelaaja#poistaKortit()
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
     * Metodi tarkistaa päättyykö kierros, eli onko seuraavalla pelaajalla enää
     * kortteja. Jos ei ole, niin kierros päättyy.
     *
     * @return Tosi mikäli kierros päättyy, epätosi muulloin
     */
    public boolean paattyykoKierros() {
        if (pelaajat.get(seuraavaPelaaja()).getKasi().getKortit().isEmpty()) {
            lopetaKierros();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodi palauttaa toden mikäli pelivuorossa oleva pelaaja voi pelata
     * kyseisen kortin kädestä. Jos kierros päättyy niin aloitetaan uusi
     * huutokierros. Muutoin jos aloitetaan uusi tikki, siirretään vuoro sille
     * pelaajalle joka voitti edellisen tikin.
     *
     * @param kortti kortti joka aiotaan pelata
     * @return tosi mikäli voi pelata, epätosi muulloin
     */
    public boolean vuorossaOlevaPelaajaPelaaKortin(int kortti) {
        Kasi pelaajanKasi = pelaajat.get(vuorossaOlevaPelaaja).getKasi();
        Kierros kierros = kierrokset.get(kierrokset.size() - 1);
        if (kierros.vuorossaOlevaPelaajaPelaaKortin(pelaajat.get(vuorossaOlevaPelaaja), pelaajanKasi.getKortit().get(kortti))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodi tarkistaa onko viimeisimmän kierroksen viimeisin tikki tyhjä. Jos
     * näin on pelivuoro siirretään sille pelaajalle, joka voitti aikaisemman
     * tikin.
     */
    public void tikkiTaynnaSiirraVuoroVoittajalle() {
        Kierros kierros = kierrokset.get(kierrokset.size() - 1);
        if (kierros.getTikit().get(kierros.getTikit().size() - 1).getKortit().isEmpty()) {
            Pelaaja seuraavaVuorossa = kierros.getVoittavatPelaajat().get(kierros.getVoittavatPelaajat().size() - 1);
            vuorossaOlevaPelaaja = pelaajat.indexOf(seuraavaVuorossa);
        }
    }

    /**
     * Metodi tarkistaa onko viimeisin tikki tyhjä, eli onko aloitettu uusi
     * tikki.
     *
     * @return tosi mikäli viimeisin tikki on tyhjä, epätosi muulloin
     */
    public boolean viimeisinTikkiTyhja() {
        if (kierrokset.get(kierrokset.size() - 1).viimeisinTikkiTyhja()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodi laskee peliaparien pisteet. Pelaajat, joiden indeksit on 0 ja 2
     * ovat ensimmäinen pelipari. Pelaajat, joiden indeksit ovat 1 ja 3 ovat
     * toinen pelipari.
     */
    public void laskePisteet() {
        ArrayList<Tikki> tikit = kierrokset.get(kierrokset.size() - 1).getTikit();
        ArrayList<Pelaaja> voittajat = kierrokset.get(kierrokset.size() - 1).getVoittavatPelaajat();
        int huudonVoittaja = huutokierrokset.get(huutokierrokset.size() - 1).getHuudonVoittaja();
        int voittohuuto = huutokierrokset.get(huutokierrokset.size() - 1).getVoittohuuto();
        int peliparin1Pisteet = 0;
        int peliparin2Pisteet = 0;
        for (int i = 0; i < voittajat.size(); i++) {
            Pelaaja voittaja = voittajat.get(i);
            Tikki tikki = tikit.get(i);
            if (pelaajanIndeksi(voittaja) % 2 == 0) {
                peliparin1Pisteet += tikki.tikinPisteet();
                if (tikit.indexOf(tikki) == 8) {
                    peliparin1Pisteet += 20;
                }
            } else {
                peliparin2Pisteet += tikki.tikinPisteet();
                if (tikit.indexOf(tikki) == 8) {
                    peliparin2Pisteet += 20;
                }
            }
        }
        if (huudonVoittaja % 2 == 0) {
            if (peliparin1Pisteet < voittohuuto) {
                peliparienPisteet.set(0, peliparienPisteet.get(0) - voittohuuto);
            } else {
                peliparienPisteet.set(0, peliparienPisteet.get(0) + voittohuuto);
            }
            peliparienPisteet.set(1, peliparienPisteet.get(1) + peliparin2Pisteet);
        } else {
            if (peliparin2Pisteet < voittohuuto) {
                peliparienPisteet.set(1, peliparienPisteet.get(1) - voittohuuto);
            } else {
                peliparienPisteet.set(1, peliparienPisteet.get(1) + voittohuuto);
            }
            peliparienPisteet.set(0, peliparienPisteet.get(0) + peliparin2Pisteet);
        }
    }

    /**
     * Metodi palauttaa argumenttina olevan pelaajan indeksin. Helpottaa
     * pisteenlaskua.
     *
     * @param pelaaja Haettava pelaaja
     * @return pelaajan indeksi
     */
    public int pelaajanIndeksi(Pelaaja pelaaja) {
        return pelaajat.indexOf(pelaaja);
    }

    /**
     * Metodi lisää käydyn huutokierroksen listalle.
     *
     * @param voittohuuto määrä jolla huutokierros voitettiin
     */
    public void lisaaHuutokierros(int voittohuuto) {
        this.huutokierrokset.add(new Huutokierros(vuorossaOlevaPelaaja, voittohuuto));
        asetaPassauksetFalse();
    }

    /**
     * Metodi aloittaa pelin parametrina annettujen pelaajien nimillä, jakaa
     * pelaajille kortit, ja aloittaa huutokierroksen.
     *
     * @param nimi1 Pelaajan 1 nimi
     * @param nimi2 Pelaajan 2 nimi
     * @param nimi3 Pelaajan 3 nimi
     * @param nimi4 Pelaajan 4 nimi
     */
    public void aloitaPeli(String nimi1, String nimi2, String nimi3, String nimi4) {
        setPelaajat(nimi1, nimi2, nimi3, nimi4);
        huutokierrosKaynnissa = true;
        pelaajatLuotu = true;
        jaaPelaajilleKortit();
        asetaPisteetNolliksi();
        aloitaHuutokierros();
    }

    /**
     * Metodi aloittaa uuden huutokierroksen ja määrää ensimmäiseksi huutajaksi
     * pelaajan huutokierrosten lukumäärän perusteella. Ensimmäisen
     * huutokierroksen aloittaa ensimmäinen pelaaja, toisen toinen ja niin
     * edelleen.
     */
    public void aloitaHuutokierros() {
        huutokierrosKaynnissa = true;
        if (huutokierrokset.isEmpty()) {
            setPelivuorossaOlevaPelaaja(0);
        } else {
            setPelivuorossaOlevaPelaaja(huutokierrokset.size());
        }

    }

    /**
     * Metodi lopettaa huutokierroksen ja siirtyy tikkien pelaamiseen.
     *
     * @see tikkipeli.logic.Peli#aloitaKierros()
     * @param voittohuuto Huutokierroksen voittohuuto
     */
    public void lopetaHuutokierros(int voittohuuto) {
        siirrySeuraavaanPelaajaan();
        lisaaHuutokierros(voittohuuto);
        huutokierrosKaynnissa = false;
        kierrosKaynnissa = true;
        asetaPassauksetFalse();
        aloitaKierros();
    }

    /**
     * Metodi aloittaa kierroksen.
     */
    public void aloitaKierros() {
        kierrokset.add(new Kierros());
        kierrokset.get(kierrokset.size() - 1).getTikit().add(new Tikki());
    }

    /**
     * Metodi lopettaa kierroksen, eli tikkien pelaamisen, laskee pisteet ja
     * toisen peliparin pisteiden yltäessä yli 500 pisteen, lopettaa pelin.
     */
    public void lopetaKierros() {
        kierrosKaynnissa = false;
        korttiPelattu = false;
        laskePisteet();
        int maksimiPisteet = 0;
        for (Integer pisteet : peliparienPisteet) {
            if (pisteet > maksimiPisteet) {
                maksimiPisteet = pisteet;
            }
        }
        if (maksimiPisteet > 500) {
            lopetaPeli();
        } else {
            aloitaHuutokierros();
        }
    }

    /**
     * Metodi lopettaa pelin.
     */
    public void lopetaPeli() {
        pelaajatLuotu = false;
        kierrosKaynnissa = false;
        asetaPisteetNolliksi();

    }

}
