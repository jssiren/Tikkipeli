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
public class KierrosTest {
    
    Kierros kierros;
    Pelaaja pelaaja;
    Kortti kortti;
    
    public KierrosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kierros = new Kierros();
        pelaaja = new Pelaaja("nimi1");
        kortti = new Kortti(Maa.HERTTA,KortinArvo.k10);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void konstruktoriToimii() {
        assertTrue(kierros.getTikit().isEmpty());
        assertTrue(kierros.getVoittavatPelaajat().isEmpty());
    }
    
    @Test
    public void vuorossaOlevaPelaaKortin() {
        pelaaja.lisaaKorttiKateen(kortti);
        assertTrue(kierros.vuorossaOlevaPelaajaPelaaKortin(pelaaja, kortti));
    }
    
    @Test
    public void vuorossaOlevaPelaaKortin2() {
        Kortti kortti1 = new Kortti(Maa.HERTTA, KortinArvo.k9);
        Kortti kortti2 = new Kortti(Maa.HERTTA, KortinArvo.k10);
        Kortti kortti3 = new Kortti(Maa.RUUTU, KortinArvo.kJ);
        Kortti kortti4 = new Kortti(Maa.RISTI, KortinArvo.kA);
        pelaaja.lisaaKorttiKateen(kortti1);
        pelaaja.lisaaKorttiKateen(kortti2);
        pelaaja.lisaaKorttiKateen(kortti3);
        pelaaja.lisaaKorttiKateen(kortti4);
        
        assertTrue(kierros.vuorossaOlevaPelaajaPelaaKortin(pelaaja, kortti4));
        assertTrue(kierros.vuorossaOlevaPelaajaPelaaKortin(pelaaja, kortti1));
        assertTrue(kierros.vuorossaOlevaPelaajaPelaaKortin(pelaaja, kortti2));
        assertTrue(kierros.vuorossaOlevaPelaajaPelaaKortin(pelaaja, kortti3));
        assertEquals(2,kierros.getTikit().size());
        assertEquals(1,kierros.getVoittavatPelaajat().size());
    }
    
    @Test
    public void vuorossaOlevaPelaaKortin3() {
        Kortti kortti1 = new Kortti(Maa.HERTTA, KortinArvo.k9);
        Kortti kortti2 = new Kortti(Maa.HERTTA, KortinArvo.k10);
        Kortti kortti3 = new Kortti(Maa.RUUTU, KortinArvo.kJ);
        Kortti kortti4 = new Kortti(Maa.RISTI, KortinArvo.kA);
        pelaaja.lisaaKorttiKateen(kortti1);
        pelaaja.lisaaKorttiKateen(kortti2);
        pelaaja.lisaaKorttiKateen(kortti3);
        pelaaja.lisaaKorttiKateen(kortti4);
        
        assertTrue(kierros.vuorossaOlevaPelaajaPelaaKortin(pelaaja, kortti1));
        assertFalse(kierros.vuorossaOlevaPelaajaPelaaKortin(pelaaja, kortti3));
        
    }
    
    @Test
    public void lisaaTikkiTest(){
        assertTrue(kierros.getTikit().isEmpty());
        kierros.lisaaTikki();
        assertEquals(kierros.getTikit().size(),1);
    }
    
    @Test
    public void viimeisinTikkiTyhja() {
        assertTrue(kierros.viimeisinTikkiTyhja());
        kierros.lisaaTikki();
        assertTrue(kierros.viimeisinTikkiTyhja());
    }
    
    @Test
    public void viimeisinTikkiEiTyhja() {
        assertTrue(kierros.viimeisinTikkiTyhja());
        kierros.lisaaTikki();
        kierros.getTikit().get(kierros.getTikit().size() - 1).lisaaKorttiTikkiin(kortti);
        assertFalse(kierros.viimeisinTikkiTyhja());
    }
 

}
