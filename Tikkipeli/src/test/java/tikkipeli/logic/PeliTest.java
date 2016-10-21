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
public class PeliTest {

    Peli peli;
    Kortti kortti;

    public PeliTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        peli = new Peli();
        kortti = new Kortti(Maa.HERTTA, KortinArvo.k10);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriToimii() {
        assertTrue(!peli.getPakka().getKortit().isEmpty());
        assertTrue(peli.getKierrokset().isEmpty());
        assertEquals(0, peli.getVuorossaOlevaPelaaja());
        assertTrue(peli.getPelaajat().isEmpty());
        assertTrue(peli.getHuutokierrokset().isEmpty());
        assertTrue(peli.getPeliparienPisteet().isEmpty());
        assertEquals(4, peli.getPassaukset().length);
        assertFalse(peli.getHuutokierrosKaynnissa());
        assertFalse(peli.getKierrosKaynnissa());
        assertFalse(peli.getPelaajatLuotu());
        assertFalse(peli.getKorttiPelattu());
        assertEquals(50, peli.getMinimiHuuto());
    }

    @Test
    public void yksinkertaistenSetterienTestaus() {
        peli.setKorttiPelattu(true);
        assertTrue(peli.getKorttiPelattu());
        peli.setPelaajatLuotu(true);
        assertTrue(peli.getPelaajatLuotu());
        peli.setHuutokierrosKaynnissa(true);
        assertTrue(peli.getHuutokierrosKaynnissa());
        peli.setKierrosKaynnissa(true);
        assertTrue(peli.getKierrosKaynnissa());
    }

    @Test
    public void pelaajatLisataanJaNiitaOnNelja() {
        peli.setPelaajat("pelaaja1", "pelaaja2", "pelaaja3", "pelaaja4");
        assertEquals(4, peli.getPelaajat().size());
    }

    @Test
    public void alussaPeliparienPisteetNollissa() {
        peli.asetaPisteetNolliksi();
        assertEquals(peli.getPeliparienPisteet().get(0).intValue(), 0);
        assertEquals(peli.getPeliparienPisteet().get(1).intValue(), 0);
    }

    @Test
    public void pelaajienKortitPoistetaan() {
        peli.setPelaajat("pelaaja1", "pelaaja2", "pelaaja3", "pelaaja4");
        peli.jaaPelaajilleKortit();
        assertEquals(9, peli.getPelaajat().get(0).getKasi().getKortit().size());
        peli.poistaPelaajienKortit();
        assertTrue(peli.getPelaajat().get(0).getKasi().getKortit().isEmpty());
        assertFalse(peli.getPassaukset()[0]);
        assertFalse(peli.getPassaukset()[1]);
        assertFalse(peli.getPassaukset()[2]);
        assertFalse(peli.getPassaukset()[3]);
    }

    @Test
    public void pelaajilleKortienJakaminenKunYhdellaVielaKortti() {
        peli.setPelaajat("pelaaja1", "pelaaja2", "pelaaja3", "pelaaja4");
        peli.getPelaajat().get(0).lisaaKorttiKateen(kortti);
        assertEquals(1, peli.getPelaajat().get(0).getKasi().getKortit().size());
        peli.jaaPelaajilleKortit();
        assertEquals(9, peli.getPelaajat().get(0).getKasi().getKortit().size());
        peli.poistaPelaajienKortit();
        assertTrue(peli.getPelaajat().get(0).getKasi().getKortit().isEmpty());
    }

    @Test
    public void pelivuoronSaataminen() {
        peli.setPelivuorossaOlevaPelaaja(4);
        assertEquals(0, peli.getVuorossaOlevaPelaaja());
        peli.setPelivuorossaOlevaPelaaja(2);
        assertEquals(2, peli.getVuorossaOlevaPelaaja());
        peli.setPelivuorossaOlevaPelaaja(-1);
        assertEquals(2, peli.getVuorossaOlevaPelaaja());
    }

    @Test
    public void seuraavaPelivuorossaOlevaPelaaja() {
        assertEquals(0, peli.getVuorossaOlevaPelaaja());
        peli.siirrySeuraavaanPelaajaan();
        assertEquals(1, peli.getVuorossaOlevaPelaaja());
    }

    @Test
    public void setPassaukset() {
        peli.asetaPassauksetFalse();
        assertFalse(peli.getPassaukset()[2]);
        peli.setPassaukset(2, true);
        assertTrue(peli.getPassaukset()[2]);
    }

    @Test
    public void seuraavaPelaaja() {
        peli.asetaPassauksetFalse();
        assertEquals(0, peli.getVuorossaOlevaPelaaja());
        assertEquals(1, peli.seuraavaPelaaja());
    }

    @Test
    public void seuraavaPelaaja2() {
        peli.asetaPassauksetFalse();
        assertEquals(0, peli.getVuorossaOlevaPelaaja());
        peli.setPassaukset(1, true);
        assertEquals(2, peli.seuraavaPelaaja());
    }

    @Test
    public void seuraavaPelaaja3() {
        peli.asetaPassauksetFalse();
        assertEquals(0, peli.getVuorossaOlevaPelaaja());
        peli.setPassaukset(1, true);
        peli.setPassaukset(2, true);
        assertEquals(3, peli.seuraavaPelaaja());
    }
    
    @Test
    public void seuraavaPelaaja4() {
        peli.asetaPassauksetFalse();
        assertEquals(0, peli.getVuorossaOlevaPelaaja());
        peli.setPassaukset(1, true);
        peli.setPassaukset(2, true);
        peli.setPassaukset(3, true);
        assertEquals(0, peli.seuraavaPelaaja());
    }
    
    @Test
    public void passauksia4() {
        peli.asetaPassauksetFalse();
        peli.setPassaukset(0, true);
        peli.setPassaukset(1, true);
        peli.setPassaukset(2, true);
        peli.setPassaukset(3, true);
        assertFalse(peli.passauksiaKolme());
    }
    
    @Test
    public void passauksia3() {
        peli.asetaPassauksetFalse();
        peli.setPassaukset(1, true);
        peli.setPassaukset(2, true);
        peli.setPassaukset(3, true);
        assertTrue(peli.passauksiaKolme());
    }
    
    @Test
    public void passauksia2() {
        peli.asetaPassauksetFalse();
        peli.setPassaukset(1, true);
        peli.setPassaukset(2, true);
        assertFalse(peli.passauksiaKolme());
    }
    
    @Test
    public void passauksia1() {
        peli.asetaPassauksetFalse();
        peli.setPassaukset(1, true);
        assertFalse(peli.passauksiaKolme());
    }
    
    @Test
    public void passauksia0() {
        peli.asetaPassauksetFalse();
        assertFalse(peli.passauksiaKolme());
    }
    
    @Test
    public void tarkistaanPaattyykoKierros() {
        peli.setPelaajat("pelaaja1", "pelaaja2", "pelaaja3", "pelaaja4");
        peli.asetaPisteetNolliksi();
        peli.lisaaHuutokierros(0);
        peli.getKierrokset().add(new Kierros());
        peli.getKierrokset().get(0).lisaaTikki();
        assertTrue(peli.paattyykoKierros());
        peli.jaaPelaajilleKortit();
        assertFalse(peli.paattyykoKierros());
    }
    
    @Test
    public void vuorossaOlevaPelaajaPelaaKortinTest() {
        peli.setPelaajat("pelaaja1", "pelaaja2", "pelaaja3", "pelaaja4");
        peli.asetaPisteetNolliksi();
        peli.getKierrokset().add(new Kierros());
        peli.getKierrokset().get(0).lisaaTikki();
        peli.poistaPelaajienKortit();
        peli.getPelaajat().get(0).lisaaKorttiKateen(new Kortti(Maa.HERTTA, KortinArvo.k10));
        assertTrue(peli.vuorossaOlevaPelaajaPelaaKortin(0));
    }
    
    @Test
    public void vuorossaOlevaPelaajaPelaaKortinTest2() {
        peli.setPelaajat("pelaaja1", "pelaaja2", "pelaaja3", "pelaaja4");
        peli.asetaPisteetNolliksi();
        peli.asetaPassauksetFalse();
        peli.getKierrokset().add(new Kierros());
        peli.getKierrokset().get(0).lisaaTikki();
        peli.poistaPelaajienKortit();
        peli.getPelaajat().get(0).lisaaKorttiKateen(new Kortti(Maa.HERTTA, KortinArvo.k8));
        assertTrue(peli.vuorossaOlevaPelaajaPelaaKortin(0));
        peli.siirrySeuraavaanPelaajaan();
        peli.getPelaajat().get(1).lisaaKorttiKateen(new Kortti(Maa.HERTTA, KortinArvo.k6));
        peli.getPelaajat().get(1).lisaaKorttiKateen(new Kortti(Maa.HERTTA, KortinArvo.k10));
        assertFalse(peli.vuorossaOlevaPelaajaPelaaKortin(0));
    }
    
    public void vuoroSiirretaanOikeallePelaajalle() {
        peli.setPelaajat("pelaaja1", "pelaaja2", "pelaaja3", "pelaaja4");
        peli.asetaPisteetNolliksi();
        peli.asetaPassauksetFalse();
        peli.getKierrokset().add(new Kierros());
        assertEquals(1, peli.getKierrokset().size());
        peli.getKierrokset().get(0).lisaaTikki();
        peli.poistaPelaajienKortit();
        peli.getPelaajat().get(0).lisaaKorttiKateen(new Kortti(Maa.HERTTA, KortinArvo.k8));
        peli.vuorossaOlevaPelaajaPelaaKortin(0);
        peli.siirrySeuraavaanPelaajaan();
        peli.getPelaajat().get(1).lisaaKorttiKateen(new Kortti(Maa.HERTTA, KortinArvo.k6));
        peli.vuorossaOlevaPelaajaPelaaKortin(0);
        peli.siirrySeuraavaanPelaajaan();
        peli.siirrySeuraavaanPelaajaan();peli.getPelaajat().get(2).lisaaKorttiKateen(new Kortti(Maa.HERTTA, KortinArvo.k10));
        peli.vuorossaOlevaPelaajaPelaaKortin(0);
        peli.siirrySeuraavaanPelaajaan();
        peli.getPelaajat().get(3).lisaaKorttiKateen(new Kortti(Maa.HERTTA, KortinArvo.kA));
        peli.tikkiTaynnaSiirraVuoroVoittajalle();
        assertEquals(3,peli.getVuorossaOlevaPelaaja());
        
    }
    
    @Test
    public void viimeisinTikkiTyhjaTest() {
        peli.setPelaajat("pelaaja1", "pelaaja2", "pelaaja3", "pelaaja4");
        peli.asetaPisteetNolliksi();
        peli.asetaPassauksetFalse();
        peli.getKierrokset().add(new Kierros());
        peli.getKierrokset().get(0).lisaaTikki();
        assertTrue(peli.viimeisinTikkiTyhja());
    }
    
    @Test
    public void viimeisinTikkiEiTyhjaTest() {
        peli.setPelaajat("pelaaja1", "pelaaja2", "pelaaja3", "pelaaja4");
        peli.asetaPisteetNolliksi();
        peli.asetaPassauksetFalse();
        peli.getKierrokset().add(new Kierros());
        peli.getKierrokset().get(0).lisaaTikki();
        peli.getPelaajat().get(0).lisaaKorttiKateen(new Kortti(Maa.HERTTA, KortinArvo.k10));
        peli.vuorossaOlevaPelaajaPelaaKortin(0);
        assertFalse(peli.viimeisinTikkiTyhja());
    }
    
    @Test
    public void pelinAloitusMetodinTestaus() {
        peli.aloitaPeli("pelaaja1", "pelaaja2", "pelaaja3", "pelaaja4");
        assertTrue(peli.getHuutokierrosKaynnissa());
        assertTrue(peli.getPelaajatLuotu());
        assertFalse(peli.getPelaajat().get(0).getKasi().getKortit().isEmpty());
        assertEquals(0,peli.getPeliparienPisteet().get(0).intValue());
        assertEquals(0,peli.getVuorossaOlevaPelaaja());
    }
    
    @Test
    public void huutokierroksenAloitusmetodinTestaus() {
        peli.aloitaHuutokierros();
        assertEquals(0,peli.getVuorossaOlevaPelaaja());
    }
    
    @Test
    public void huutokierroksenAloitusmetodinTestaus2() {
        peli.lisaaHuutokierros(0);
        peli.aloitaHuutokierros();
        assertEquals(1,peli.getVuorossaOlevaPelaaja());
    }
    
    @Test
    public void pelinLopetusMetodinTestaus() {
        peli.lopetaPeli();
        assertFalse(peli.getPelaajatLuotu());
        assertFalse(peli.getKierrosKaynnissa());
        assertEquals(0,peli.getPeliparienPisteet().get(0).intValue());
    }
}
