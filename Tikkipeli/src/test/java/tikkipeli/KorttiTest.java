package tikkipeli;

import tikkipeli.logic.Pelaaja;
import tikkipeli.logic.Peli;
import tikkipeli.logic.Maa;
import tikkipeli.logic.Tikki;
import tikkipeli.logic.KortinArvo;
import tikkipeli.logic.Kasi;
import tikkipeli.logic.Pakka;
import tikkipeli.logic.Kortti;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

public class KorttiTest {
    
    Kortti korttiH6;
    Pakka pakka;
    Tikki tikki;
    Kasi kasi;
    Pelaaja pelaaja;
    Peli peli;
    
    
    public KorttiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        korttiH6 = new Kortti(Maa.HERTTA,KortinArvo.k6);
        kasi = new Kasi();
        pakka = new Pakka();
        tikki = new Tikki();
        pelaaja = new Pelaaja("pelaaja1");
        peli = new Peli();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriAsettaaPisteetNollaksi() {
        assertEquals(0,korttiH6.getPisteet());
    }
    
    @Test
    public void maaOikein() {
        assertEquals(Maa.HERTTA,korttiH6.getMaa());
    }
    
    @Test
    public void arvoOikein() {
        assertEquals(6,korttiH6.getArvo());
    }
    
    @Test
    public void oikeaLukumaaraPakassaKunKaikkiLisatty() {
        assertEquals(36,pakka.getKortit().size());
    }
    
    @Test
    public void pakassaOikeaMaaraPistetiaYht() {
        int summa = 0;
        for (Kortti kortti : pakka.getKortit()) {
            summa = summa + kortti.getPisteet();
        }
        assertEquals(140,summa);
    }
    
    @Test
    public void pakassaOikeaMaaraHerttaa() {
        ArrayList<Kortti> kortitNolla = new ArrayList<Kortti>();
        for (Kortti kortti : pakka.getKortit()) {
            if (kortti.getMaa() == Maa.HERTTA) {
                kortitNolla.add(kortti);
            }
        }
        assertEquals(9,kortitNolla.size());
    }
    
    @Test
    public void pakassaOikeaMaaraRuutua() {
        ArrayList<Kortti> kortitYksi = new ArrayList<Kortti>();
        for (Kortti kortti : pakka.getKortit()) {
            if (kortti.getMaa() == Maa.RUUTU) {
                kortitYksi.add(kortti);
            }
        }
        assertEquals(9,kortitYksi.size());
    }
    
    @Test
    public void pakassaOikeaMaaraRistia() {
        ArrayList<Kortti> kortitKaksi = new ArrayList<Kortti>();
        for (Kortti kortti : pakka.getKortit()) {
            if (kortti.getMaa() == Maa.RISTI) {
                kortitKaksi.add(kortti);
            }
        }
        assertEquals(9,kortitKaksi.size());
    }
    
    @Test
    public void pakassaOikeaMaaraPataa() {
        ArrayList<Kortti> kortitKolme = new ArrayList<Kortti>();
        for (Kortti kortti : pakka.getKortit()) {
            if (kortti.getMaa() == Maa.PATA) {
                kortitKolme.add(kortti);
            }
        }
        assertEquals(9,kortitKolme.size());
    }
    
    @Test
    public void pelaajanNimiTulostuuOikein() {
        Pelaaja pelaaja = new Pelaaja("blaa");
        assertEquals("blaa",pelaaja.getNimi());
    }
    
    @Test
    public void hertanValttiarvoOikein() {
        assertEquals(100, Maa.HERTTA.getValtinArvo());
    }
    
    @Test
    public void ruudunValttiarvoOikein() {
        assertEquals(80, Maa.RUUTU.getValtinArvo());
    }
    
    @Test
    public void ristinValttiarvoOikein() {
        assertEquals(60, Maa.RISTI.getValtinArvo());
    }
    
    @Test
    public void pataValttiarvoOikein() {
        assertEquals(40, Maa.PATA.getValtinArvo());
    }
    
    @Test
    public void kymppinArvoSuurempiKuningas() {
        Kortti kymppi = new Kortti(Maa.HERTTA, KortinArvo.k10);
        Kortti kuningas = new Kortti(Maa.RISTI, KortinArvo.kK);
        assertEquals(1,kymppi.getArvo() - kuningas.getArvo());
    }
    
    public void assanArvoSuurempiKympin() {
        Kortti kymppi = new Kortti(Maa.HERTTA, KortinArvo.k10);
        Kortti assa = new Kortti(Maa.RISTI, KortinArvo.kA);
        assertEquals(1,assa.getArvo() - kymppi.getArvo());
    }
    
    @Test
    public void numerokorttienPisteetOnNolla() {
        int pisteet = 0;
        for (Kortti kortti : pakka.getKortit()) {
            if (kortti.getArvo() < 11) {
                pisteet += kortti.getPisteet();
            }
        }
        assertEquals(0,pisteet);
    }
    
    @Test
    public void herttaAssaVoittaaTikinIlmanValttia() {
        tikki.lisaaKorttiTikkiin(new Kortti(Maa.HERTTA,KortinArvo.k10),pelaaja);
        tikki.lisaaKorttiTikkiin(new Kortti(Maa.HERTTA,KortinArvo.kA),pelaaja);
        tikki.lisaaKorttiTikkiin(new Kortti(Maa.PATA,KortinArvo.k6),pelaaja);
        tikki.lisaaKorttiTikkiin(new Kortti(Maa.RISTI,KortinArvo.kJ),pelaaja);
        Kortti voittava = new Kortti(Maa.HERTTA,KortinArvo.kA);
        assertEquals(voittava.toString(), tikki.tikinVoittavaKortti().toString());
    }
    
    @Test
    public void pata6VoittaaTikinIlmanValttia() {
        tikki.lisaaKorttiTikkiin(new Kortti(Maa.PATA,KortinArvo.k6),pelaaja);
        tikki.lisaaKorttiTikkiin(new Kortti(Maa.HERTTA,KortinArvo.kA),pelaaja);
        tikki.lisaaKorttiTikkiin(new Kortti(Maa.HERTTA,KortinArvo.k10),pelaaja);
        tikki.lisaaKorttiTikkiin(new Kortti(Maa.RISTI,KortinArvo.kJ),pelaaja);
        Kortti voittava = new Kortti(Maa.PATA,KortinArvo.k6);
        assertEquals(voittava.toString(), tikki.tikinVoittavaKortti().toString());
    }
    
    @Test
    public void pata6AloittaaHerttaAVoittaaHerttavaltilla() {
        tikki.vaihdaValtti(Maa.HERTTA);
        tikki.lisaaKorttiTikkiin(new Kortti(Maa.PATA,KortinArvo.k6),pelaaja);
        tikki.lisaaKorttiTikkiin(new Kortti(Maa.HERTTA,KortinArvo.k10),pelaaja);
        tikki.lisaaKorttiTikkiin(new Kortti(Maa.HERTTA,KortinArvo.kA),pelaaja);
        tikki.lisaaKorttiTikkiin(new Kortti(Maa.RISTI,KortinArvo.kJ),pelaaja);
        Kortti voittava = new Kortti(Maa.HERTTA,KortinArvo.kA);
        assertEquals(voittava.toString(), tikki.tikinVoittavaKortti().toString());
    }
    
    @Test
    public void ristiJVoittaaRistivaltilla() {
        tikki.vaihdaValtti(Maa.RISTI);
        tikki.lisaaKorttiTikkiin(new Kortti(Maa.PATA,KortinArvo.k6),pelaaja);
        tikki.lisaaKorttiTikkiin(new Kortti(Maa.HERTTA,KortinArvo.k10),pelaaja);
        tikki.lisaaKorttiTikkiin(new Kortti(Maa.HERTTA,KortinArvo.kA),pelaaja);
        tikki.lisaaKorttiTikkiin(new Kortti(Maa.RISTI,KortinArvo.kJ),pelaaja);
        Kortti voittava = new Kortti(Maa.RISTI,KortinArvo.kJ);
        assertEquals(voittava.toString(), tikki.tikinVoittavaKortti().toString());
    }

    @Test
    public void kasiEiTyhja() {
        kasi.lisaaKorttiKateen(korttiH6);
        assertTrue(!kasi.getKortit().isEmpty());
    }
    
    
    @Test
    public void kortinVoiPelataKadestaTikkiinEiValttia() {
        tikki.lisaaKorttiTikkiin(korttiH6, pelaaja);
        Kortti kortti1 = new Kortti(Maa.HERTTA,KortinArvo.k9);
        Kortti kortti2 = new Kortti(Maa.HERTTA,KortinArvo.kA);
        pelaaja.getKasi().lisaaKorttiKateen(kortti1);
        pelaaja.getKasi().lisaaKorttiKateen(kortti2);
        assertTrue(tikki.voikoKortinPelataTikkiin(pelaaja.getKasi().getKortit().indexOf(kortti1), pelaaja));
    }
    
    @Test
    public void korttiaEiVoiPelataKadestaKoskaKadestaLoytyyOikeanlainen() {
        tikki.lisaaKorttiTikkiin(korttiH6, pelaaja);
        Kortti kortti1 = new Kortti(Maa.RISTI,KortinArvo.k9);
        Kortti kortti2 = new Kortti(Maa.HERTTA,KortinArvo.kA);
        pelaaja.getKasi().lisaaKorttiKateen(kortti1);
        pelaaja.getKasi().lisaaKorttiKateen(kortti2);
        assertFalse(tikki.voikoKortinPelataTikkiin(pelaaja.getKasi().getKortit().indexOf(kortti1), pelaaja));
    }
}
