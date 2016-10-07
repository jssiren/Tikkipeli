package tikkipeli.UI;

import java.util.*;
import tikkipeli.Logic.Peli;
import tikkipeli.Logic.Kasi;

public class Main {
    public static void main(String[] args) {
        Peli peli = new Peli();
        System.out.println("Heipparallaa ja hellät tunteet! Tervetuloa Tikkipelin äärelle. Kiusallista.");
        System.out.println("Aloitetaan pelaajien luomisella.");
        System.out.println("Huom! Ensimmäisen peliparin ensimmäinen pelaaja aloittaa pelin.");
        Scanner lukija = new Scanner(System.in);
        
        peli.kysyPelaajienNimet();
        peli.jaaPelaajilleKortit();
    }
}
