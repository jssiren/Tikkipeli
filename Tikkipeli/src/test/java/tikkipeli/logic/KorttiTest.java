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
public class KorttiTest {

    Kortti hertta6;
    Kortti hertta7;
    Kortti hertta8;
    Kortti hertta9;
    Kortti hertta10;
    Kortti herttaJ;
    Kortti herttaQ;
    Kortti herttaK;
    Kortti herttaA;

    Kortti risti6;
    Kortti risti7;
    Kortti risti8;
    Kortti risti9;
    Kortti risti10;
    Kortti ristiJ;
    Kortti ristiQ;
    Kortti ristiK;
    Kortti ristiA;

    Kortti ruutu6;
    Kortti ruutu7;
    Kortti ruutu8;
    Kortti ruutu9;
    Kortti ruutu10;
    Kortti ruutuJ;
    Kortti ruutuQ;
    Kortti ruutuK;
    Kortti ruutuA;

    Kortti pata6;
    Kortti pata7;
    Kortti pata8;
    Kortti pata9;
    Kortti pata10;
    Kortti pataJ;
    Kortti pataQ;
    Kortti pataK;
    Kortti pataA;

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
        hertta6 = new Kortti(Maa.HERTTA, KortinArvo.k6);
        hertta7 = new Kortti(Maa.HERTTA, KortinArvo.k7);
        hertta8 = new Kortti(Maa.HERTTA, KortinArvo.k8);
        hertta9 = new Kortti(Maa.HERTTA, KortinArvo.k9);
        hertta10 = new Kortti(Maa.HERTTA, KortinArvo.k10);
        herttaJ = new Kortti(Maa.HERTTA, KortinArvo.kJ);
        herttaQ = new Kortti(Maa.HERTTA, KortinArvo.kQ);
        herttaK = new Kortti(Maa.HERTTA, KortinArvo.kK);
        herttaA = new Kortti(Maa.HERTTA, KortinArvo.kA);

        risti6 = new Kortti(Maa.RISTI, KortinArvo.k6);
        risti7 = new Kortti(Maa.RISTI, KortinArvo.k7);
        risti8 = new Kortti(Maa.RISTI, KortinArvo.k8);
        risti9 = new Kortti(Maa.RISTI, KortinArvo.k9);
        risti10 = new Kortti(Maa.RISTI, KortinArvo.k10);
        ristiJ = new Kortti(Maa.RISTI, KortinArvo.kJ);
        ristiQ = new Kortti(Maa.RISTI, KortinArvo.kQ);
        ristiK = new Kortti(Maa.RISTI, KortinArvo.kK);
        ristiA = new Kortti(Maa.RISTI, KortinArvo.kA);

        ruutu6 = new Kortti(Maa.RUUTU, KortinArvo.k6);
        ruutu7 = new Kortti(Maa.RUUTU, KortinArvo.k7);
        ruutu8 = new Kortti(Maa.RUUTU, KortinArvo.k8);
        ruutu9 = new Kortti(Maa.RUUTU, KortinArvo.k9);
        ruutu10 = new Kortti(Maa.RUUTU, KortinArvo.k10);
        ruutuJ = new Kortti(Maa.RUUTU, KortinArvo.kJ);
        ruutuQ = new Kortti(Maa.RUUTU, KortinArvo.kQ);
        ruutuK = new Kortti(Maa.RUUTU, KortinArvo.kK);
        ruutuA = new Kortti(Maa.RUUTU, KortinArvo.kA);

        pata6 = new Kortti(Maa.PATA, KortinArvo.k6);
        pata7 = new Kortti(Maa.PATA, KortinArvo.k7);
        pata8 = new Kortti(Maa.PATA, KortinArvo.k8);
        pata9 = new Kortti(Maa.PATA, KortinArvo.k9);
        pata10 = new Kortti(Maa.PATA, KortinArvo.k10);
        pataJ = new Kortti(Maa.PATA, KortinArvo.kJ);
        pataQ = new Kortti(Maa.PATA, KortinArvo.kQ);
        pataK = new Kortti(Maa.PATA, KortinArvo.kK);
        pataA = new Kortti(Maa.PATA, KortinArvo.kA);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void maaJaArvoOikeinPadoilla() {
        assertTrue(pata6.getMaa().equals(Maa.PATA));
        assertTrue(pata7.getMaa().equals(Maa.PATA));
        assertTrue(pata8.getMaa().equals(Maa.PATA));
        assertTrue(pata9.getMaa().equals(Maa.PATA));
        assertTrue(pata10.getMaa().equals(Maa.PATA));
        assertTrue(pataJ.getMaa().equals(Maa.PATA));
        assertTrue(pataQ.getMaa().equals(Maa.PATA));
        assertTrue(pataK.getMaa().equals(Maa.PATA));
        assertTrue(pataA.getMaa().equals(Maa.PATA));
        assertEquals(pata6.getArvo(), KortinArvo.k6.getKortinArvo());
        assertEquals(pata7.getArvo(), KortinArvo.k7.getKortinArvo());
        assertEquals(pata8.getArvo(), KortinArvo.k8.getKortinArvo());
        assertEquals(pata9.getArvo(), KortinArvo.k9.getKortinArvo());
        assertEquals(pata10.getArvo(), KortinArvo.k10.getKortinArvo());
        assertEquals(pataJ.getArvo(), KortinArvo.kJ.getKortinArvo());
        assertEquals(pataQ.getArvo(), KortinArvo.kQ.getKortinArvo());
        assertEquals(pataK.getArvo(), KortinArvo.kK.getKortinArvo());
        assertEquals(pataA.getArvo(), KortinArvo.kA.getKortinArvo());
    }

    @Test
    public void maaJaArvoOikeinHertoilla() {
        assertTrue(hertta6.getMaa().equals(Maa.HERTTA));
        assertTrue(hertta7.getMaa().equals(Maa.HERTTA));
        assertTrue(hertta8.getMaa().equals(Maa.HERTTA));
        assertTrue(hertta9.getMaa().equals(Maa.HERTTA));
        assertTrue(hertta10.getMaa().equals(Maa.HERTTA));
        assertTrue(herttaJ.getMaa().equals(Maa.HERTTA));
        assertTrue(herttaQ.getMaa().equals(Maa.HERTTA));
        assertTrue(herttaK.getMaa().equals(Maa.HERTTA));
        assertTrue(herttaA.getMaa().equals(Maa.HERTTA));
        assertEquals(hertta6.getArvo(), KortinArvo.k6.getKortinArvo());
        assertEquals(hertta7.getArvo(), KortinArvo.k7.getKortinArvo());
        assertEquals(hertta8.getArvo(), KortinArvo.k8.getKortinArvo());
        assertEquals(hertta9.getArvo(), KortinArvo.k9.getKortinArvo());
        assertEquals(hertta10.getArvo(), KortinArvo.k10.getKortinArvo());
        assertEquals(herttaJ.getArvo(), KortinArvo.kJ.getKortinArvo());
        assertEquals(herttaQ.getArvo(), KortinArvo.kQ.getKortinArvo());
        assertEquals(herttaK.getArvo(), KortinArvo.kK.getKortinArvo());
        assertEquals(herttaA.getArvo(), KortinArvo.kA.getKortinArvo());
    }

    @Test
    public void maaOikeinRuuduilla() {
        assertTrue(ruutu6.getMaa().equals(Maa.RUUTU));
        assertTrue(ruutu7.getMaa().equals(Maa.RUUTU));
        assertTrue(ruutu8.getMaa().equals(Maa.RUUTU));
        assertTrue(ruutu9.getMaa().equals(Maa.RUUTU));
        assertTrue(ruutu10.getMaa().equals(Maa.RUUTU));
        assertTrue(ruutuJ.getMaa().equals(Maa.RUUTU));
        assertTrue(ruutuQ.getMaa().equals(Maa.RUUTU));
        assertTrue(ruutuK.getMaa().equals(Maa.RUUTU));
        assertTrue(ruutuA.getMaa().equals(Maa.RUUTU));
        assertEquals(ruutu6.getArvo(), KortinArvo.k6.getKortinArvo());
        assertEquals(ruutu7.getArvo(), KortinArvo.k7.getKortinArvo());
        assertEquals(ruutu8.getArvo(), KortinArvo.k8.getKortinArvo());
        assertEquals(ruutu9.getArvo(), KortinArvo.k9.getKortinArvo());
        assertEquals(ruutu10.getArvo(), KortinArvo.k10.getKortinArvo());
        assertEquals(ruutuJ.getArvo(), KortinArvo.kJ.getKortinArvo());
        assertEquals(ruutuQ.getArvo(), KortinArvo.kQ.getKortinArvo());
        assertEquals(ruutuK.getArvo(), KortinArvo.kK.getKortinArvo());
        assertEquals(ruutuA.getArvo(), KortinArvo.kA.getKortinArvo());
    }

    @Test
    public void maaJaArvoOikeinRisteillä() {
        assertTrue(risti6.getMaa().equals(Maa.RISTI));
        assertTrue(risti7.getMaa().equals(Maa.RISTI));
        assertTrue(risti8.getMaa().equals(Maa.RISTI));
        assertTrue(risti9.getMaa().equals(Maa.RISTI));
        assertTrue(risti10.getMaa().equals(Maa.RISTI));
        assertTrue(ristiJ.getMaa().equals(Maa.RISTI));
        assertTrue(ristiQ.getMaa().equals(Maa.RISTI));
        assertTrue(ristiK.getMaa().equals(Maa.RISTI));
        assertTrue(ristiA.getMaa().equals(Maa.RISTI));
        assertEquals(risti6.getArvo(), KortinArvo.k6.getKortinArvo());
        assertEquals(risti7.getArvo(), KortinArvo.k7.getKortinArvo());
        assertEquals(risti8.getArvo(), KortinArvo.k8.getKortinArvo());
        assertEquals(risti9.getArvo(), KortinArvo.k9.getKortinArvo());
        assertEquals(risti10.getArvo(), KortinArvo.k10.getKortinArvo());
        assertEquals(ristiJ.getArvo(), KortinArvo.kJ.getKortinArvo());
        assertEquals(ristiQ.getArvo(), KortinArvo.kQ.getKortinArvo());
        assertEquals(ristiK.getArvo(), KortinArvo.kK.getKortinArvo());
        assertEquals(ristiA.getArvo(), KortinArvo.kA.getKortinArvo());
    }
    
    @Test
    public void konstruktoriAsettaaPisteetOikein() {
        assertEquals(0, hertta6.getPisteet());
        assertEquals(0, hertta7.getPisteet());
        assertEquals(0, hertta8.getPisteet());
        assertEquals(0, hertta9.getPisteet());
        assertEquals(10, hertta10.getPisteet());
        assertEquals(5, herttaJ.getPisteet());
        assertEquals(5, herttaQ.getPisteet());
        assertEquals(5, herttaK.getPisteet());
        assertEquals(10, herttaA.getPisteet());
        
        assertEquals(0, ruutu6.getPisteet());
        assertEquals(0, ruutu7.getPisteet());
        assertEquals(0, ruutu8.getPisteet());
        assertEquals(0, ruutu9.getPisteet());
        assertEquals(10, ruutu10.getPisteet());
        assertEquals(5, ruutuJ.getPisteet());
        assertEquals(5, ruutuQ.getPisteet());
        assertEquals(5, ruutuK.getPisteet());
        assertEquals(10, ruutuA.getPisteet());
        
        assertEquals(0, risti6.getPisteet());
        assertEquals(0, risti7.getPisteet());
        assertEquals(0, risti8.getPisteet());
        assertEquals(0, risti9.getPisteet());
        assertEquals(10, risti10.getPisteet());
        assertEquals(5, ristiJ.getPisteet());
        assertEquals(5, ristiQ.getPisteet());
        assertEquals(5, ristiK.getPisteet());
        assertEquals(10, ristiA.getPisteet());
        
        assertEquals(0, pata6.getPisteet());
        assertEquals(0, pata7.getPisteet());
        assertEquals(0, pata8.getPisteet());
        assertEquals(0, pata9.getPisteet());
        assertEquals(10, pata10.getPisteet());
        assertEquals(5, pataJ.getPisteet());
        assertEquals(5, pataQ.getPisteet());
        assertEquals(5, pataK.getPisteet());
        assertEquals(10, pataA.getPisteet());
        
    }
    
    @Test
    public void jarjestyksessaKuusiEnnenJatkaa() {
        Kortti kortti1 = new Kortti(Maa.HERTTA, KortinArvo.k6);
        Kortti kortti2 = new Kortti(Maa.HERTTA, KortinArvo.kJ);
        assertEquals(-1, kortti1.compareTo(kortti2));
    }
    
    public void jarjestyksessaKuusiEnnenJatkaa2() {
        Kortti kortti1 = new Kortti(Maa.HERTTA, KortinArvo.k6);
        Kortti kortti2 = new Kortti(Maa.HERTTA, KortinArvo.kJ);
        assertEquals(1, kortti2.compareTo(kortti1));
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
    public void jarjestyksessaHerttaEnnenRuutua2() {
        Kortti kortti1 = new Kortti(Maa.HERTTA, KortinArvo.kJ);
        Kortti kortti2 = new Kortti(Maa.RUUTU, KortinArvo.kA);
        assertEquals(1, kortti2.compareTo(kortti1));
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
    public void jarjestyksessaPataViimeisena2() {
        Kortti kortti1 = new Kortti(Maa.RISTI, KortinArvo.k8);
        Kortti kortti2 = new Kortti(Maa.PATA, KortinArvo.kJ);
        assertEquals(1, kortti2.compareTo(kortti1));
    }
    
    @Test
    public void jarjestyksessaNolla() {
        Kortti kortti1 = new Kortti(Maa.RISTI, KortinArvo.k8);
        Kortti kortti2 = new Kortti(Maa.RISTI, KortinArvo.k8);
        assertEquals(0, kortti2.compareTo(kortti1));
    }
    
    @Test
    public void jarjestyksessaNolla2() {
        Kortti kortti1 = new Kortti(Maa.RISTI, KortinArvo.k8);
        Kortti kortti2 = new Kortti(Maa.RISTI, KortinArvo.k8);
        assertEquals(0, kortti1.compareTo(kortti2));
    }
    
    @Test
    public void toStringToimii() {
        assertEquals(hertta6.toString(), "He" + "6");
    }

}
