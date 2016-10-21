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
public class KortinArvoTest {
    
    KortinArvo kuusi;
    KortinArvo seitseman;
    KortinArvo kahdeksan;
    KortinArvo yhdeksan;
    KortinArvo kymmenen;
    KortinArvo jatka;
    KortinArvo kuningatar;
    KortinArvo kuningas;
    KortinArvo assa;

    
    public KortinArvoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kuusi = KortinArvo.k6;
        seitseman = KortinArvo.k7;
        kahdeksan = KortinArvo.k8;
        yhdeksan = KortinArvo.k9;
        kymmenen = KortinArvo.k10;
        jatka = KortinArvo.kJ;
        kuningatar = KortinArvo.kQ;
        kuningas = KortinArvo.kK;
        assa = KortinArvo.kA;
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void korttiKonstruktorik6() {
        assertEquals(kuusi.getKortinArvo(),KortinArvo.k6.getKortinArvo());
        assertEquals(kuusi.getKortinArvoString(),KortinArvo.k6.getKortinArvoString());
        assertEquals(kuusi.getKortinArvonPisteet(),KortinArvo.k6.getKortinArvonPisteet());
    }
    
    @Test
    public void korttiKonstruktorik7() {
        assertEquals(seitseman.getKortinArvo(),KortinArvo.k7.getKortinArvo());
        assertEquals(seitseman.getKortinArvoString(),KortinArvo.k7.getKortinArvoString());
        assertEquals(seitseman.getKortinArvonPisteet(),KortinArvo.k7.getKortinArvonPisteet());
    }
    
    @Test
    public void korttiKonstruktorik8() {
        assertEquals(kahdeksan.getKortinArvo(),KortinArvo.k8.getKortinArvo());
        assertEquals(kahdeksan.getKortinArvoString(),KortinArvo.k8.getKortinArvoString());
        assertEquals(kahdeksan.getKortinArvonPisteet(),KortinArvo.k8.getKortinArvonPisteet());
    }
    
    @Test
    public void korttiKonstruktorik9() {
        assertEquals(yhdeksan.getKortinArvo(),KortinArvo.k9.getKortinArvo());
        assertEquals(yhdeksan.getKortinArvoString(),KortinArvo.k9.getKortinArvoString());
        assertEquals(yhdeksan.getKortinArvonPisteet(),KortinArvo.k9.getKortinArvonPisteet());
    }
    
    @Test
    public void korttiKonstruktorik10() {
        assertEquals(kymmenen.getKortinArvo(),KortinArvo.k10.getKortinArvo());
        assertEquals(kymmenen.getKortinArvoString(),KortinArvo.k10.getKortinArvoString());
        assertEquals(kymmenen.getKortinArvonPisteet(),KortinArvo.k10.getKortinArvonPisteet());
    }
    
    @Test
    public void korttiKonstruktorikJ() {
        assertEquals(jatka.getKortinArvo(),KortinArvo.kJ.getKortinArvo());
        assertEquals(jatka.getKortinArvoString(),KortinArvo.kJ.getKortinArvoString());
        assertEquals(jatka.getKortinArvonPisteet(),KortinArvo.kJ.getKortinArvonPisteet());
    }
    
    @Test
    public void korttiKonstruktorikQ() {
        assertEquals(kuningatar.getKortinArvo(),KortinArvo.kQ.getKortinArvo());
        assertEquals(kuningatar.getKortinArvoString(),KortinArvo.kQ.getKortinArvoString());
        assertEquals(kuningatar.getKortinArvonPisteet(),KortinArvo.kQ.getKortinArvonPisteet());
    }
    
    @Test
    public void korttiKonstruktorikK() {
        assertEquals(kuningas.getKortinArvo(),KortinArvo.kK.getKortinArvo());
        assertEquals(kuningas.getKortinArvoString(),KortinArvo.kK.getKortinArvoString());
        assertEquals(kuningas.getKortinArvonPisteet(),KortinArvo.kK.getKortinArvonPisteet());
    }
    
    @Test
    public void korttiKonstruktorikA() {
        assertEquals(assa.getKortinArvo(),KortinArvo.kA.getKortinArvo());
        assertEquals(assa.getKortinArvoString(),KortinArvo.kA.getKortinArvoString());
        assertEquals(assa.getKortinArvonPisteet(),KortinArvo.kA.getKortinArvonPisteet());
    }
    
    @Test
    public void suuruusJarjestyksessa67() {
        assertTrue(kuusi.getKortinArvo() < seitseman.getKortinArvo());
    }
    
    @Test
    public void suuruusJarjestyksessa78() {
        assertTrue(seitseman.getKortinArvo() < kahdeksan.getKortinArvo());
    }
    
    @Test
    public void suuruusJarjestyksessa89() {
        assertTrue(kahdeksan.getKortinArvo() < yhdeksan.getKortinArvo());
    }
    
    @Test
    public void suuruusJarjestyksessa9J() {
        assertTrue(yhdeksan.getKortinArvo() < jatka.getKortinArvo());
    }
    
    @Test
    public void suuruusJarjestyksessaJQ() {
        assertTrue(jatka.getKortinArvo() < kuningatar.getKortinArvo());
    }
    
    @Test
    public void suuruusJarjestyksessaQK() {
        assertTrue(kuningatar.getKortinArvo() < kuningas.getKortinArvo());
    }
    
    @Test
    public void suuruusJarjestyksessaKKymmenen() {
        assertTrue(kuningas.getKortinArvo() < kymmenen.getKortinArvo());
    }
    
    @Test
    public void suuruusJarjestyksessaKymmenenAssa() {
        assertTrue(kymmenen.getKortinArvo() < assa.getKortinArvo());
    }
    
    @Test
    public void kortinArvoGetStringTest() {
        assertEquals("6",kuusi.getKortinArvoString());
    }
    
    @Test
    public void kortinArvoGetStringTest2() {
        assertEquals("6",kuusi.toString());
    }

}
