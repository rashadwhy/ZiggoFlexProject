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
        List<String> pakketten = new ArrayList<>();
        List<String> addons = new ArrayList<>();
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

class Klant {
    private final String klantID;
    private final String naam;
    private final String postcode;
    private final String huisnummer;
    private final String aanmaakdatum;
    private String pakketten;
    private String addons;

    public Klant(String klantID, String naam, String postcode, String huisnummer, String aanmaakdatum, List<String> pakketten, List<String> addons) {
        this.klantID = klantID;
        this.naam = naam;
        this.postcode = postcode;
        this.huisnummer = huisnummer;
        this.aanmaakdatum = aanmaakdatum;
        setPakketten(pakketten);
        setAddons(addons);
    }

    public String getKlantID() {
        return klantID;
    }

    public String getNaam() {
        return naam;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getHuisnummer() {
        return huisnummer;
    }

    public String getAanmaakdatum() {
        return aanmaakdatum;
    }

    public List<String> getPakketten() {
        return List.of(pakketten.split(", "));
    }

    public void setPakketten(List<String> pakketten) {
        StringBuilder pakketStringBuilder = new StringBuilder();
        for (String pakket : pakketten) {
            pakketStringBuilder.append(pakket);
            pakketStringBuilder.append(", ");
        }
        this.pakketten = pakketStringBuilder.toString().trim();
    }

    public List<String> getAddons() {
        return List.of(addons.split(", "));
    }

    public void setAddons(List<String> addons) {
        StringBuilder addonsStringBuilder = new StringBuilder();
        for (String addon : addons) {
            addonsStringBuilder.append(addon);
            addonsStringBuilder.append(", ");
        }
        this.addons = addonsStringBuilder.toString().trim();
    }
}
