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
public class TikkiTest {

    Tikki tikki;
    Pelaaja pelaaja;

    public TikkiTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        tikki = new Tikki();
        pelaaja = new Pelaaja("pelaaja1");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriToimii() {
        assertTrue(tikki.getKortit().isEmpty());
        assertTrue(tikki.getPelaajat().isEmpty());
    }

    @Test
    public void oikeaKorttiVoittaaTikin() {
        Kortti kortti1 = new Kortti(Maa.HERTTA, KortinArvo.k9);
        Kortti kortti2 = new Kortti(Maa.HERTTA, KortinArvo.k10);
        Kortti kortti3 = new Kortti(Maa.RUUTU, KortinArvo.kJ);
        Kortti kortti4 = new Kortti(Maa.RISTI, KortinArvo.kA);
        tikki.lisaaKorttiTikkiin(kortti1);
        tikki.lisaaKorttiTikkiin(kortti2);
        tikki.lisaaKorttiTikkiin(kortti3);
        tikki.lisaaKorttiTikkiin(kortti4);
        Kortti voittaja = tikki.tikinVoittavaKortti();
        assertEquals(voittaja, kortti2);
    }

    @Test
    public void oikeaKorttiVoittaaTikin2() {
        Kortti kortti1 = new Kortti(Maa.HERTTA, KortinArvo.k10);
        Kortti kortti2 = new Kortti(Maa.HERTTA, KortinArvo.k9);
        Kortti kortti3 = new Kortti(Maa.RUUTU, KortinArvo.kJ);
        Kortti kortti4 = new Kortti(Maa.RISTI, KortinArvo.kA);
        tikki.lisaaKorttiTikkiin(kortti1);
        tikki.lisaaKorttiTikkiin(kortti2);
        tikki.lisaaKorttiTikkiin(kortti3);
        tikki.lisaaKorttiTikkiin(kortti4);
        Kortti voittaja = tikki.tikinVoittavaKortti();
        assertEquals(voittaja, kortti1);
    }

    @Test
    public void oikeaKorttiVoittaaTikin3() {
        Kortti kortti1 = new Kortti(Maa.HERTTA, KortinArvo.k10);
        Kortti kortti2 = new Kortti(Maa.HERTTA, KortinArvo.k9);
        Kortti kortti3 = new Kortti(Maa.RUUTU, KortinArvo.kJ);
        Kortti kortti4 = new Kortti(Maa.RISTI, KortinArvo.kA);
        tikki.lisaaKorttiTikkiin(kortti3);
        tikki.lisaaKorttiTikkiin(kortti1);
        tikki.lisaaKorttiTikkiin(kortti2);
        tikki.lisaaKorttiTikkiin(kortti4);
        Kortti voittaja = tikki.tikinVoittavaKortti();
        assertEquals(voittaja, kortti3);
    }
    
    @Test
    public void tikinPisteetOikein() {
        Kortti kortti1 = new Kortti(Maa.HERTTA, KortinArvo.k10);
        Kortti kortti2 = new Kortti(Maa.HERTTA, KortinArvo.k9);
        Kortti kortti3 = new Kortti(Maa.RUUTU, KortinArvo.kJ);
        Kortti kortti4 = new Kortti(Maa.RISTI, KortinArvo.kA);
        tikki.lisaaKorttiTikkiin(kortti3);
        tikki.lisaaKorttiTikkiin(kortti1);
        tikki.lisaaKorttiTikkiin(kortti2);
        tikki.lisaaKorttiTikkiin(kortti4);
        assertEquals(25, tikki.tikinPisteet());
    }
    
    @Test
    public void tikinPisteetOikein2() {
        assertEquals(0,tikki.tikinPisteet());
    }
    
    @Test
    public void pelaajanLisaaminenOnnistuuJaSittenEpaonnistuu() {
        assertTrue(tikki.lisaaKortinPelannutPelaaja(pelaaja));
        assertFalse(tikki.lisaaKortinPelannutPelaaja(pelaaja));
    }
    
    @Test
    public void pelaajaEiVoiPelataKorttiaTikkiin() {
        Kortti kortti1 = new Kortti(Maa.HERTTA,KortinArvo.k10);
        assertFalse(tikki.vuorossaOlevaPelaajaPelaaKortin(pelaaja, kortti1));
    }
    @Test
    public void pelaajaEiVoiPelataKortinTikkiin2() {
        Kortti kortti1 = new Kortti(Maa.HERTTA,KortinArvo.k10);
        Kortti kortti2 = new Kortti(Maa.PATA,KortinArvo.k10);
        pelaaja.lisaaKorttiKateen(kortti1);
        pelaaja.lisaaKorttiKateen(kortti2);
        tikki.lisaaKorttiTikkiin(kortti2);
        assertFalse(tikki.vuorossaOlevaPelaajaPelaaKortin(pelaaja, kortti2));
    }
    
    @Test
    public void pelaajaVoiPelataKortinTikkiin() {
        Kortti kortti1 = new Kortti(Maa.HERTTA,KortinArvo.k10);
        pelaaja.lisaaKorttiKateen(kortti1);
        assertTrue(tikki.vuorossaOlevaPelaajaPelaaKortin(pelaaja, kortti1));
    }

    @Test
    public void pelaajaVoiPelataKortinKadesta() {

    }
}
