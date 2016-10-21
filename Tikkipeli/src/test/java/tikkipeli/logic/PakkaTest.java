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
public class PakkaTest {

    Pakka pakka;

    public PakkaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        pakka = new Pakka();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void pakassa36Korttia() {
        assertEquals(36, pakka.getKortit().size());
    }

    @Test
    public void pakassaNollaTyhjaaMaata() {
        int i = 0;
        for (Kortti kortti : pakka.getKortit()) {
            if (kortti.getMaa().equals(Maa.TYHJA)) {
                i++;
            }
        }
        assertEquals(0, i);
    }

    @Test
    public void pakassa9Herttaa() {
        int i = 0;
        for (Kortti kortti : pakka.getKortit()) {
            if (kortti.getMaa().equals(Maa.HERTTA)) {
                i++;
            }
        }
        assertEquals(9, i);
    }

    @Test
    public void pakassa9Ruutua() {
        int i = 0;
        for (Kortti kortti : pakka.getKortit()) {
            if (kortti.getMaa().equals(Maa.RUUTU)) {
                i++;
            }
        }
        assertEquals(9, i);
    }

    @Test
    public void pakassa9Ristia() {
        int i = 0;
        for (Kortti kortti : pakka.getKortit()) {
            if (kortti.getMaa().equals(Maa.RISTI)) {
                i++;
            }
        }
        assertEquals(9, i);
    }

    @Test
    public void pakassa9Pataa() {
        int i = 0;
        for (Kortti kortti : pakka.getKortit()) {
            if (kortti.getMaa().equals(Maa.PATA)) {
                i++;
            }
        }
        assertEquals(9, i);
    }

    @Test
    public void pakkaJarjestettynaHertta6EnsimmainenKortti() {
        pakka.jarjestaPakka();
        Kortti kortti1 = new Kortti(Maa.HERTTA, KortinArvo.k6);
        assertTrue(pakka.getKortit().get(0).equals(kortti1));
    }

    @Test
    public void pakkaJarjestettynaPataAssaViimeinenKortti() {
        pakka.jarjestaPakka();
        Kortti kortti1 = new Kortti(Maa.PATA, KortinArvo.kA);
        assertTrue(pakka.getKortit().get(pakka.getKortit().size() - 1).equals(kortti1));
    }

    @Test
    public void pakkaSekoittuu() {
        pakka.jarjestaPakka();
        Kortti kortti = pakka.getKortit().get(5);
        pakka.sekoitaPakka();
        assertFalse(kortti.equals(pakka.getKortit().get(5)));
    }

    @Test
    public void pakassaOikeaMaaraPistetiaYht() {
        int summa = 0;
        for (Kortti kortti : pakka.getKortit()) {
            summa = summa + kortti.getPisteet();
        }
        assertEquals(140, summa);
    }

    @Test
    public void numerokorttienPisteetOnNolla() {
        int pisteet = 0;
        for (Kortti kortti : pakka.getKortit()) {
            if (kortti.getArvo() < 11) {
                pisteet += kortti.getPisteet();
            }
        }
        assertEquals(0, pisteet);
    }
    
    @Test
    public void kuvakorttienPisteetOnViisi() {
        int pisteet = 0;
        for (Kortti kortti : pakka.getKortit()) {
            if (kortti.getArvo() >= 11 && kortti.getArvo() <= 13) {
                pisteet += kortti.getPisteet();
            }
        }
        assertEquals(60, pisteet);
    }
    
    @Test
    public void toppienPisteetOnKymmenen() {
        int pisteet = 0;
        for (Kortti kortti : pakka.getKortit()) {
            if (kortti.getArvo() >= 14) {
                pisteet += kortti.getPisteet();
            }
        }
        assertEquals(80, pisteet);
    }
    

}
