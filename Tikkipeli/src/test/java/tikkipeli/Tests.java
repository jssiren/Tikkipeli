package tikkipeli;

import tikkipeli.logic.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

public class Tests {

//    KortinArvo kortinArvo;
//    Kortti kortti;
//    Maa maa;
//    Pakka pakka;
//    
//    Huutokierros huutokierros;
//    Kasi kasi;
//    Kierros kierros;
//    Pelaaja pelaaja;
//    Peli peli;
//    Tikki tikki;

    public Tests() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
//        kortti = new Kortti(Maa.HERTTA, KortinArvo.k6);
//        kasi = new Kasi();
//        pakka = new Pakka();
//        tikki = new Tikki();
//        pelaaja = new Pelaaja("pelaaja1");
//        peli = new Peli();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void maatVeratutuvatOikein() {
        Maa maa1 = Maa.HERTTA;
        Maa maa2 = Maa.HERTTA;
        assertTrue(maa1.equals(maa2));
    }

    @Test
    public void kymppiArvoltaanPienempiKuinAssa() {
        KortinArvo kymppi = KortinArvo.k10;
        KortinArvo assa = KortinArvo.kA;
        assertTrue(kymppi.getKortinArvo() < assa.getKortinArvo());
    }

    @Test
    public void kymppiArvoltaanSuurempiKuinKuningas() {
        KortinArvo kymppi = KortinArvo.k10;
        KortinArvo kuningas = KortinArvo.kK;
        assertTrue(kymppi.getKortinArvo() > kuningas.getKortinArvo());
    }

    @Test
    public void korttilleAsetettuArvoOikein() {
        Kortti kortti1 = new Kortti(Maa.HERTTA, KortinArvo.kA);
        assertTrue(kortti1.getArvo() == 15);
    }

    @Test
    public void korttilleAsetettuMaaOikein() {
        Kortti kortti1 = new Kortti(Maa.HERTTA, KortinArvo.kA);
        assertTrue(kortti1.getMaa().equals(Maa.HERTTA));
    }

    @Test
    public void jarjestyksessaKuusiEnnenJatkaa() {
        Kortti kortti1 = new Kortti(Maa.HERTTA, KortinArvo.k6);
        Kortti kortti2 = new Kortti(Maa.HERTTA, KortinArvo.kJ);
        assertEquals(-1, kortti1.compareTo(kortti2));
    }

    @Test
    public void jarjestyksessaJatkaEnnenAssaa() {
        Kortti kortti1 = new Kortti(Maa.HERTTA, KortinArvo.kJ);
        Kortti kortti2 = new Kortti(Maa.HERTTA, KortinArvo.kA);
        assertEquals(-1, kortti1.compareTo(kortti2));
    }

    @Test
    public void jarjestyksessaHerttaEnnenRuutua() {
        Kortti kortti1 = new Kortti(Maa.HERTTA, KortinArvo.kJ);
        Kortti kortti2 = new Kortti(Maa.RUUTU, KortinArvo.kA);
        assertEquals(-1, kortti1.compareTo(kortti2));
    }
    
    @Test
    public void jarjestyksessaRuutuEnnenRistia() {
        Kortti kortti1 = new Kortti(Maa.RUUTU, KortinArvo.k8);
        Kortti kortti2 = new Kortti(Maa.RISTI, KortinArvo.kJ);
        assertEquals(-1, kortti1.compareTo(kortti2));
    }
    
    @Test
    public void jarjestyksessaPataViimeisena() {
        Kortti kortti1 = new Kortti(Maa.RISTI, KortinArvo.k8);
        Kortti kortti2 = new Kortti(Maa.PATA, KortinArvo.kJ);
        assertEquals(-1, kortti1.compareTo(kortti2));
    }
    
    @Test
    public void pakassa36Korttia() {
        Pakka pakka = new Pakka();
        assertEquals(36, pakka.getKortit().size());
    }
    
    @Test
    public void pakkaJarjestettynaHertta6EnsimmainenKortti() {
        Pakka pakka = new Pakka();
        pakka.jarjestaPakka();
        Kortti kortti1 = new Kortti(Maa.HERTTA,KortinArvo.k6);
        assertTrue(pakka.getKortit().get(0).equals(kortti1));
    }
    
    @Test
    public void pakkaJarjestettynaPataAssaViimeinenKortti() {
        Pakka pakka = new Pakka();
        pakka.jarjestaPakka();
        Kortti kortti1 = new Kortti(Maa.PATA, KortinArvo.kA);
        assertTrue(pakka.getKortit().get(pakka.getKortit().size() - 1).equals(kortti1));
    }
    
    @Test
    public void lisattyKorttiKasvattaaKadenKorttienLukumaaraa() {
        Kasi kasi = new Kasi();
        Kortti kortti1 = new Kortti(Maa.HERTTA,KortinArvo.k10);
        kasi.lisaaKorttiKateen(kortti1);
        assertEquals(1,kasi.getKortit().size());
    }
    
}
