import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
class KlantDatabase {
    private final List<Klant> klanten = new ArrayList<>();

    public Klant nieuweKlant(String naam, String postcode, String huisnummer) {
        String klantID = UUID.randomUUID().toString();
        String aanmaakdatum = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String pakketten = "";
        String addons = "";
        Klant klant = new Klant(klantID, naam, postcode, huisnummer, aanmaakdatum, pakketten, addons);
        klanten.add(klant);
        return klant;
    }

    public Klant getKlant(String postcode, String huisnummer) {
        for (Klant klant : klanten) {
            if (klant.getPostcode().equals(postcode) && klant.getHuisnummer().equals(huisnummer)) {
                return klant;
            }
        }
        return null;
    }
}