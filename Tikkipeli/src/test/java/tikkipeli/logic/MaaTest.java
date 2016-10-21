package tikkipeli.logic;

import tikkipeli.logic.Maa;

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
public class MaaTest {
    
    Maa hertta;
    Maa ruutu;
    Maa risti;
    Maa pata;
    Maa tyhja;
    
    public MaaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        hertta = Maa.HERTTA;
        ruutu = Maa.RUUTU;
        risti = Maa.RISTI;
        pata = Maa.PATA;
        tyhja = Maa.TYHJA;
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void hertanValtinArvotOikein() {
        assertEquals(this.hertta.getValtinArvo(), Maa.HERTTA.getValtinArvo());
    }
    
    @Test
    public void ruudunValtinArvotOikein() {
        assertEquals(this.ruutu.getValtinArvo(), Maa.RUUTU.getValtinArvo());
    }
    
    @Test
    public void ristinValtinArvotOikein() {
        assertEquals(this.risti.getValtinArvo(), Maa.RISTI.getValtinArvo());
    }
    
    @Test
    public void padanValtinArvotOikein() {
        assertEquals(this.pata.getValtinArvo(), Maa.PATA.getValtinArvo());
    }
    
    @Test
    public void tyhjanValtinArvotOikein() {
        assertEquals(this.tyhja.getValtinArvo(), Maa.TYHJA.getValtinArvo());
    }
    
    @Test
    public void hertanLyhenneOikein() {
        assertEquals(this.hertta.getLyhenne(), Maa.HERTTA.getLyhenne());
    }
    
    @Test
    public void ruudunLyhenneOikein() {
        assertEquals(this.ruutu.getLyhenne(), Maa.RUUTU.getLyhenne());
    }
    
    @Test
    public void ristinLyhenneOikein() {
        assertEquals(this.risti.getLyhenne(), Maa.RISTI.getLyhenne());
    }
    
    @Test
    public void padanLyhenneOikein() {
        assertEquals(this.pata.getLyhenne(), Maa.PATA.getLyhenne());
    }
    
    @Test
    public void tyhjanLyhenneOikein() {
        assertEquals(this.tyhja.getLyhenne(), Maa.TYHJA.getLyhenne());
    }
    
     @Test
    public void maanKonstruktoriToimii() {
        Maa maa = Maa.HERTTA;
        assertEquals(maa.getLyhenne(),"He");
        assertEquals(maa.getValtinArvo(), 100);
    }
    
    @Test
    public void maanKonstruktoriToimii2() {
        Maa maa = Maa.RUUTU;
        assertEquals(maa.getLyhenne(),"Ru");
        assertEquals(maa.getValtinArvo(), 80);
    }
    
    @Test
    public void maanKonstruktoriToimii3() {
        Maa maa = Maa.RISTI;
        assertEquals(maa.getLyhenne(),"Ri");
        assertEquals(maa.getValtinArvo(), 60);
    }
    
    @Test
    public void maanKonstruktoriToimii4() {
        Maa maa = Maa.PATA;
        assertEquals(maa.getLyhenne(),"Pa");
        assertEquals(maa.getValtinArvo(), 40);
    }
    
    @Test
    public void maanKonstruktoriToimiiTyhja() {
        Maa maa = Maa.TYHJA;
        assertEquals(maa.getLyhenne(),"X");
        assertEquals(maa.getValtinArvo(), 0);
    }

    @Test
    public void maatVeratutuvatOikein() {
        Maa maa1 = Maa.HERTTA;
        Maa maa2 = Maa.HERTTA;
        assertTrue(maa1.equals(maa2));
    }
}
