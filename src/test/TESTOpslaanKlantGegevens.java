
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TESTOpslaanKlantGegevens {


    @Test
    public void testGetNieuweklantNaam() {
        Klant klant;
        klant = new Klant("1", "AnwarMuradin", "2152EP","22","1","1","1");
        assertEquals("AnwarMuradin", klant.getNaam());
    }


    @Test
    public void testGetNieuweklantPostcode() {
        Klant klant;
        klant = new Klant("1", "AnwarMuradin", "2152EP","22","1","1","1");
        assertEquals("2152EP", klant.getPostcode());
    }


    @Test
    public void testGetNieuweklantHuisnummer() {
        Klant klant;
        klant = new Klant("1", "AnwarMuradin", "2152EP","22","1","1","1");
        assertEquals("2152EP", klant.getPostcode());
    }
}

