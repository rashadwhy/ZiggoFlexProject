
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TESTOpslaanKlantGegevens {
    @Test
    public void testGetNieuweklant() {
        Klant klant;
        klant = new Klant("1", "AnwarMuradin", "2152EP","22","1","1","1");
        assertEquals("AnwarMuradin", klant.getNaam());
        assertEquals("2152EP", klant.getPostcode());
        assertEquals("22", klant.getHuisnummer());
    }
}

