package tikkipeli;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

/**
 *
 * @author janne
 */
public class KorttiTest {
    
    Kortti kortti;
    Pakka pakka;
    
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
        kortti = new Kortti(0,0);
        pakka = new Pakka();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriAsettaaPisteetNollaksi() {
        assertEquals(0,kortti.getPisteet());
    }
    
    @Test
    public void maaOikein() {
        assertEquals(0,kortti.getMaa());
    }
    
    @Test
    public void arvoOikein() {
        assertEquals(0,kortti.getArvo());
    }
    
    @Test
    public void oikeaLukumaaraPakassaJosLisattyYksi() {
        pakka.lisaaKortti();
        assertEquals(37, pakka.getKortit().size());
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
    public void pakassaOikeaMaaraMaataNolla() {
        ArrayList<Kortti> kortitNolla = new ArrayList<Kortti>();
        for (Kortti kortti : pakka.getKortit()) {
            if (kortti.getMaa() == 3) {
                kortitNolla.add(kortti);
            }
        }
        assertEquals(9,kortitNolla.size());
    }
    
    @Test
    public void pakassaOikeaMaaraMaataYksi() {
        ArrayList<Kortti> kortitYksi = new ArrayList<Kortti>();
        for (Kortti kortti : pakka.getKortit()) {
            if (kortti.getMaa() == 3) {
                kortitYksi.add(kortti);
            }
        }
        assertEquals(9,kortitYksi.size());
    }
    
    @Test
    public void pakassaOikeaMaaraMaataKaksi() {
        ArrayList<Kortti> kortitKaksi = new ArrayList<Kortti>();
        for (Kortti kortti : pakka.getKortit()) {
            if (kortti.getMaa() == 3) {
                kortitKaksi.add(kortti);
            }
        }
        assertEquals(9,kortitKaksi.size());
    }
    
    @Test
    public void pakassaOikeaMaaraMaataKolme() {
        ArrayList<Kortti> kortitKolme = new ArrayList<Kortti>();
        for (Kortti kortti : pakka.getKortit()) {
            if (kortti.getMaa() == 3) {
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
    
    
    
}
