package tikkipeli.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author janne
 */
public class PelaajaTest {
    
    Pelaaja pelaaja;
    Kortti kortti;
    public PelaajaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pelaaja = new Pelaaja("nimi1");
        kortti = new Kortti(Maa.HERTTA,KortinArvo.k10);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriToimii() {
        assertEquals(pelaaja.getNimi(),"nimi1");
        assertTrue(pelaaja.getKasi().getKortit().isEmpty());
    }
    
    @Test
    public void kortinLisaaminenOnnistuu() {
        assertTrue(pelaaja.lisaaKorttiKateen(kortti));
        assertFalse(pelaaja.lisaaKorttiKateen(kortti));
        
    }
    
    @Test
    public void kortinPoistaminenOnnistuu() {
        pelaaja.lisaaKorttiKateen(kortti);
        assertTrue(pelaaja.getKasi().getKortit().contains(kortti));
        assertTrue(pelaaja.poistaKortti(kortti));
        assertFalse(pelaaja.poistaKortti(kortti));   
    }
    
    @Test
    public void kortitJarjestykseenOikein() {
        Kortti kortti1 = new Kortti(Maa.HERTTA, KortinArvo.k10);
        Kortti kortti2 = new Kortti(Maa.HERTTA, KortinArvo.kA);
        pelaaja.lisaaKorttiKateen(kortti1);
        pelaaja.lisaaKorttiKateen(kortti2);
        pelaaja.kortitJarjestykseen();
        assertEquals(kortti1, pelaaja.getKasi().getKortit().get(0));
    }
    
    @Test
    public void kortitJarjestykseenOikein2() {
        Kortti kortti1 = new Kortti(Maa.HERTTA, KortinArvo.kA);
        Kortti kortti2 = new Kortti(Maa.HERTTA, KortinArvo.k10);
        pelaaja.lisaaKorttiKateen(kortti1);
        pelaaja.lisaaKorttiKateen(kortti2);
        pelaaja.kortitJarjestykseen();
        assertEquals(kortti2, pelaaja.getKasi().getKortit().get(0));
    }
    
    @Test
    public void kortitJarjestykseenOikein3() {
        Kortti kortti1 = new Kortti(Maa.RUUTU, KortinArvo.k10);
        Kortti kortti2 = new Kortti(Maa.HERTTA, KortinArvo.kA);
        pelaaja.lisaaKorttiKateen(kortti1);
        pelaaja.lisaaKorttiKateen(kortti2);
        pelaaja.kortitJarjestykseen();
        assertEquals(kortti2, pelaaja.getKasi().getKortit().get(0));
    }
    
    @Test
    public void kortitJarjestykseenOikein4() {
        Kortti kortti1 = new Kortti(Maa.RISTI, KortinArvo.k10);
        Kortti kortti2 = new Kortti(Maa.RUUTU, KortinArvo.kA);
        pelaaja.lisaaKorttiKateen(kortti1);
        pelaaja.lisaaKorttiKateen(kortti2);
        pelaaja.kortitJarjestykseen();
        assertEquals(kortti2, pelaaja.getKasi().getKortit().get(0));
    }
    
    @Test
    public void kortitJarjestykseenOikein5() {
        Kortti kortti1 = new Kortti(Maa.PATA, KortinArvo.k10);
        Kortti kortti2 = new Kortti(Maa.RISTI, KortinArvo.kA);
        pelaaja.lisaaKorttiKateen(kortti1);
        pelaaja.lisaaKorttiKateen(kortti2);
        pelaaja.kortitJarjestykseen();
        assertEquals(kortti2, pelaaja.getKasi().getKortit().get(0));
    }
    
    @Test
    public void poistetaanKaikkiKortit() {
        Kortti kortti1 = new Kortti(Maa.PATA, KortinArvo.k10);
        Kortti kortti2 = new Kortti(Maa.RISTI, KortinArvo.kA);
        pelaaja.lisaaKorttiKateen(kortti1);
        pelaaja.lisaaKorttiKateen(kortti2);
        assertTrue(pelaaja.poistaKortit());
    }
    
    @Test
    public void poistetaanKaikkiKortit2() {
        assertFalse(pelaaja.poistaKortit());
    }
        
    @Test
    public void equalsTest1() {
       Pelaaja pelaaja2 = pelaaja;
       assertTrue(pelaaja2.equals(pelaaja));
    }
    
    @Test
    public void equalsTest2() {
        Pelaaja pelaaja2 = new Pelaaja("nimi2");
        assertFalse(pelaaja2.equals(pelaaja));
    }
    
    @Test
    public void equalsTest3() {
        Pelaaja pelaaja2 = new Pelaaja("nimi1");
        assertFalse(pelaaja2.equals(pelaaja));
    }
    
    
   
}
