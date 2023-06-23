import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


public class NieuweKlantTest{


    @Test
    public void testGetNieuweklantNaam() {
        Klant klant;
        klant = new Klant("1", "Anwar Muradin", "2152EP","22","1", Arrays.asList("TV Start, Internet Start"),"FILM1");
        assertEquals("Anwar Muradin", klant.getNaam());
    }


    @Test
    public void testGetNieuweklantPostcode() {
        Klant klant;
        klant = new Klant("1", "Anwar Muradin", "2152EP","22","1", Arrays.asList("TV Start, Internet Start"),"FILM1");
        assertEquals("2152EP", klant.getPostcode());
    }


    @Test
    public void testGetNieuweklantHuisnummer() {
        Klant klant;
        klant = new Klant("1", "Anwar Muradin", "2152EP","22","1", Arrays.asList("TV Start, Internet Start"),"FILM1");
        assertEquals("2152EP", klant.getPostcode());
    }
}