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
public class HuutokierrosTest {

    Huutokierros huutokierros;
    
    public HuutokierrosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        huutokierros = new Huutokierros(123, 245);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriToimii() {
        assertEquals(huutokierros.getHuudonVoittaja(), 123);
        assertEquals(huutokierros.getVoittohuuto(),245);
    }
}
