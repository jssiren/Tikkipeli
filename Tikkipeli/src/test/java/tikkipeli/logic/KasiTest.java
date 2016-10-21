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
public class KasiTest {

    Kasi kasi;

    public KasiTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        kasi = new Kasi();
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void konstruktoriLuoTyhjanKaden() {
        assertTrue(kasi.getKortit().isEmpty());
    }

    @Test
    public void lisattyKorttiKasvattaaKadenKorttienLukumaaraa() {
        Kortti kortti1 = new Kortti(Maa.HERTTA, KortinArvo.k10);
        kasi.lisaaKorttiKateen(kortti1);
        assertEquals(1, kasi.getKortit().size());
    }
    
    @Test
    public void lisattyKorttiKasvattaaKadenKorttienLukumaaraa2() {
        Kortti kortti1 = new Kortti(Maa.HERTTA, KortinArvo.k10);
        kasi.lisaaKorttiKateen(kortti1);
        kasi.lisaaKorttiKateen(kortti1);
        assertEquals(1, kasi.getKortit().size());
    }

    @Test
    public void kadessaOlevatKortitMenevatJarjestykseenSamaaMaata() {
        Kortti kortti1 = new Kortti(Maa.HERTTA, KortinArvo.kA);
        Kortti kortti2 = new Kortti(Maa.HERTTA, KortinArvo.k10);
        kasi.lisaaKorttiKateen(kortti1);
        kasi.lisaaKorttiKateen(kortti2);
        kasi.kortitJarjestykseen();
        assertTrue(kortti2.equals(kasi.getKortit().get(0)));
    }

    @Test
    public void kadessaOlevatKortitMenevatJarjestykseenEriMaata() {
        Kortti kortti1 = new Kortti(Maa.RUUTU, KortinArvo.k10);
        Kortti kortti2 = new Kortti(Maa.HERTTA, KortinArvo.kA);
        kasi.lisaaKorttiKateen(kortti1);
        kasi.lisaaKorttiKateen(kortti2);
        kasi.kortitJarjestykseen();
        assertTrue(kortti2.equals(kasi.getKortit().get(0)));
    }

    @Test
    public void tyhjastaKadestaEiPoistuMitaan() {
        Kortti kortti1 = new Kortti(Maa.HERTTA, KortinArvo.kA);
        assertFalse(kasi.poistaKorttiKadesta(kortti1));
    }

    @Test
    public void kysyttyaKorttiaEiVoiPoistaaKoskaEiKadessa() {
        Kortti kortti1 = new Kortti(Maa.HERTTA, KortinArvo.kA);
        kasi.lisaaKorttiKateen(kortti1);
        Kortti kortti2 = new Kortti(Maa.HERTTA, KortinArvo.kA);
        assertFalse(kasi.poistaKorttiKadesta(kortti2));
    }
    
    @Test
    public void kysyttyKorttiLoytyyJaPoistuuKadesta() {
        Kortti kortti1 = new Kortti(Maa.HERTTA, KortinArvo.kA);
        kasi.lisaaKorttiKateen(kortti1);
        assertTrue(kasi.getKortit().contains(kortti1));
        kasi.poistaKorttiKadesta(kortti1);
        assertFalse(kasi.getKortit().contains(kortti1));
    }

    @Test
    public void kysyttyaMaataEiLoydyKadesta() {
        Kortti kortti1 = new Kortti(Maa.HERTTA, KortinArvo.kA);
        kasi.lisaaKorttiKateen(kortti1);
        assertFalse(kasi.loytyykoKadestaMaata(Maa.PATA));
        assertFalse(kasi.loytyykoKadestaMaata(Maa.RUUTU));
        assertFalse(kasi.loytyykoKadestaMaata(Maa.RISTI));
    }

    @Test
    public void kysyttyaMaataLoytyyKadesta() {
        Kortti kortti1 = new Kortti(Maa.HERTTA, KortinArvo.kA);
        kasi.lisaaKorttiKateen(kortti1);
        assertTrue(kasi.loytyykoKadestaMaata(Maa.HERTTA));
    }

    @Test
    public void kysyttyaMaataJaIsompaaLoytyyKadesta() {
        Kortti kortti1 = new Kortti(Maa.HERTTA, KortinArvo.kA);
        Kortti kortti2 = new Kortti(Maa.HERTTA, KortinArvo.k10);
        kasi.lisaaKorttiKateen(kortti1);
        assertTrue(kasi.loytyykoKadestaSamaaMaataJaIsompaa(kortti2));
    }

    @Test
    public void kysyttyaMaataJaIsompaaLoytyyKadesta2() {
        Kortti kortti2 = new Kortti(Maa.HERTTA, KortinArvo.kA);
        Kortti kortti1 = new Kortti(Maa.HERTTA, KortinArvo.k10);
        kasi.lisaaKorttiKateen(kortti1);
        assertFalse(kasi.loytyykoKadestaSamaaMaataJaIsompaa(kortti2));
    }

    @Test
    public void kysyttyaMaataJaIsompaaLoytyyKadesta3() {
        Kortti kortti1 = new Kortti(Maa.HERTTA, KortinArvo.k10);
        Kortti kortti2 = new Kortti(Maa.HERTTA, KortinArvo.k10);
        kasi.lisaaKorttiKateen(kortti1);
        assertFalse(kasi.loytyykoKadestaSamaaMaataJaIsompaa(kortti2));
    }

    @Test
    public void kysyttyaMaataJaIsompaaEiLoydyKadesta() {
        Kortti kortti1 = new Kortti(Maa.PATA, KortinArvo.k10);
        Kortti kortti2 = new Kortti(Maa.HERTTA, KortinArvo.k10);
        kasi.lisaaKorttiKateen(kortti1);
        assertFalse(kasi.loytyykoKadestaSamaaMaataJaIsompaa(kortti2));
    }

    @Test
    public void kysyttyaMaataJaIsompaaEiLoydyKadesta2() {
        Kortti kortti2 = new Kortti(Maa.HERTTA, KortinArvo.kA);
        Kortti kortti1 = new Kortti(Maa.HERTTA, KortinArvo.k10);
        kasi.lisaaKorttiKateen(kortti1);
        assertFalse(kasi.loytyykoKadestaSamaaMaataJaIsompaa(kortti2));
    }

    @Test
    public void tyhjastaKadestaEiLoydyMaata() {
        assertFalse(kasi.loytyykoKadestaMaata(Maa.HERTTA));
        assertFalse(kasi.loytyykoKadestaMaata(Maa.RUUTU));
        assertFalse(kasi.loytyykoKadestaMaata(Maa.RISTI));
        assertFalse(kasi.loytyykoKadestaMaata(Maa.PATA));
    }
    
    @Test
    public void tyhjastaKadestaEiLoydyMaataJaIsompaa() {
        assertFalse(kasi.loytyykoKadestaSamaaMaataJaIsompaa(new Kortti(Maa.HERTTA,KortinArvo.k10)));
        assertFalse(kasi.loytyykoKadestaSamaaMaataJaIsompaa(new Kortti(Maa.RUUTU,KortinArvo.k10)));
        assertFalse(kasi.loytyykoKadestaSamaaMaataJaIsompaa(new Kortti(Maa.RISTI,KortinArvo.k10)));
        assertFalse(kasi.loytyykoKadestaSamaaMaataJaIsompaa(new Kortti(Maa.PATA,KortinArvo.k10)));
    }
    
    @Test
    public void kadestaPoistetaanKortit() {
        Kortti kortti2 = new Kortti(Maa.HERTTA, KortinArvo.kA);
        Kortti kortti1 = new Kortti(Maa.HERTTA, KortinArvo.k10);
        kasi.lisaaKorttiKateen(kortti1);
        kasi.lisaaKorttiKateen(kortti2);
        kasi.poistaKortit();
        assertTrue(kasi.getKortit().isEmpty());
    }
    
    @Test
    public void kasiToStringTestTyhjaKasi() {
        assertEquals("",kasi.toString());
    }
    
    @Test
    public void kasiToStringTestKadessaKortteja() {
        Kortti kortti2 = new Kortti(Maa.HERTTA, KortinArvo.kA);
        Kortti kortti1 = new Kortti(Maa.HERTTA, KortinArvo.k10);
        kasi.lisaaKorttiKateen(kortti1);
        kasi.lisaaKorttiKateen(kortti2);
        assertEquals(" He10 HeA",kasi.toString());
        
    }
    
    @Test
    public void kateenLisataanNullKortti() {
        Kortti kortti1 = null;
        assertFalse(kasi.lisaaKorttiKateen(kortti1));
    }    

}
