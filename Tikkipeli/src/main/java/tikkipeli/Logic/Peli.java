package tikkipeli.Logic;

import java.util.*;

public class Peli {
    private Scanner lukija;
    private Pelipari[] peliparit;
    private Pakka pakka;
    private List<Kierros> kierrokset;

    public Peli() {
        lukija = new Scanner(System.in);
        this.pakka = new Pakka();
        kierrokset = new ArrayList<>();
        peliparit = new Pelipari[2];
    }

    public Pelipari[] getPeliparit() {
        return peliparit;
    }

    public Pelipari getPelipari(int i) {
        return peliparit[i];
    }

    public void setPelipari(int i, String nimi1, String nimi2) {
        peliparit[i] = new Pelipari(new Pelaaja(nimi1), new Pelaaja(nimi2));
    }
    
    public void jaaPelaajilleKortit() {
        List<Kasi> kadet = pakka.jaaPakkaNeljaan();
        peliparit[0].getPelaaja1().setKasi(kadet.get(0));
        peliparit[0].getPelaaja2().setKasi(kadet.get(1));
        peliparit[1].getPelaaja1().setKasi(kadet.get(2));
        peliparit[1].getPelaaja2().setKasi(kadet.get(3));
    }    
    
    public void kysyPelaajienNimet() {
        System.out.println("Anna ensimmäisen peliparin pelaajien nimet:");
        System.out.print("Pelaaja 1: ");
        String nimi1 = lukija.nextLine();
        System.out.print("Pelaaja 2: ");
        String nimi2 = lukija.nextLine();
        System.out.println("Anna toisen peliparin pelaajien nimet:");
        System.out.print("Pelaaja 1: ");
        String nimi3 = lukija.nextLine();
        System.out.print("Pelaaja 2: ");
        String nimi4 = lukija.nextLine();
        setPelipari(0, nimi1, nimi2);
        setPelipari(1, nimi3, nimi4);
    }    
}
