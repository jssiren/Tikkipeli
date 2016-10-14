package tikkipeli.Logic;

import java.util.*;

public class Peli {

    private List<Pelipari> peliparit;
    private List<Pelaaja> pelaajat;
    private Pakka pakka;
    private List<Kierros> kierrokset;
    private int vuorossaOlevaPelaaja;
    private List<Huutokierros> huutokierrokset;
    private boolean[] passaukset;
    private int kierrostenLkm;

    public Peli() {
        this.pakka = new Pakka();
        kierrokset = new ArrayList<>();
        vuorossaOlevaPelaaja = 1;
        pelaajat = new ArrayList<>();
        huutokierrokset = new ArrayList<>();
        passaukset = new boolean[4];
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

    public Pelipari getPelipari(int i) {
        return peliparit.get(i);
    }

    public int getVuorossaOlevaPelaaja() {
        return vuorossaOlevaPelaaja;
    }

    public void setPeliparit(String nimi1, String nimi2, String nimi3, String nimi4) {
        pelaajat.add(new Pelaaja(nimi1));
        pelaajat.add(new Pelaaja(nimi2));
        pelaajat.add(new Pelaaja(nimi3));
        pelaajat.add(new Pelaaja(nimi4));
//        lisaaPelipari(nimi1, nimi3);
//        lisaaPelipari(nimi2, nimi4);
    }

    public void lisaaPelipari(String nimi1, String nimi2) {
        peliparit.add(new Pelipari(new Pelaaja(nimi1), new Pelaaja(nimi2)));
    }

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

    public void jarjestaPelaajienKortit() {
        for (Pelaaja pelaaja : pelaajat) {
            pelaaja.kortitJarjestykseen();
        }
    }

    public void poistaPelaajienKortit() {
        for (Pelipari pari : peliparit) {
            pari.poistaPelaajienKortit();
        }
    }

    public void setPelivuorossaOlevaPelaaja(int j) {
        if (j >= 0 && j <= 3) {
            this.vuorossaOlevaPelaaja = j;
        }
    }

    public void siirrySeuraavaanPelaajaan() {
        vuorossaOlevaPelaaja = seuraavaPelaaja();
    }
    
    public void setPassaukset(int i, boolean onko) {
        passaukset[i] = onko;
    }

    public void lisaaKierros(int pelaaja) {
        this.kierrokset.add(new Kierros(pelaaja));
        this.kierrokset.get(this.kierrokset.size() - 1).lisaaTikki();
    }

    public void lisaaHuutokierrosJaKierros(int voittohuuto, int pelaaja) {
        this.huutokierrokset.add(new Huutokierros(voittohuuto, pelaaja));
        lisaaKierros(pelaaja);
        asetaPassauksetFalse();

    }

    public void asetaPassauksetFalse() {
        for (int i = 0; i < 4; i++) {
            passaukset[i] = false;
        }
    }

    public int seuraavaPelaaja() {
        int seuraavaPelaaja = 1;
        while (true) {
            if (passaukset[(vuorossaOlevaPelaaja + seuraavaPelaaja) % 4]) {
                seuraavaPelaaja++;
            } else {
                break;
            }
        }
        return (vuorossaOlevaPelaaja + seuraavaPelaaja)%4;
    }
    
    public boolean kierrosPaattynyt() {
        if (pelaajat.get(seuraavaPelaaja()).getKasi().getKortit().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean lisaaKorttiViimeisimmanKierroksenViimeisimpaanTikkiin(int i, int pelaaja) {
        Kierros kierros = kierrokset.get(kierrokset.size() - 1);
        Tikki tikki = kierros.getTikit().get(kierros.getTikit().size() - 1);
        if (tikki.lisaaKorttiTikkiin(i, pelaajat.get(pelaaja))) {
            if (kierros.getTikit().get(kierros.getTikit().size() - 1).getKortit().size() == 4) {
                Kortti kortti = tikki.tikinVoittavaKortti();
                vuorossaOlevaPelaaja = tikki.getKortit().indexOf(kortti);
                kierros.lisaaTikki();
            }
            return true;
        } else {
            return false;
        }
    }

}
