import java.util.ArrayList;
import java.util.List;

class Klant {
    private String klantID;
    private String naam;
    private String postcode;
    private String huisnummer;
    private String aanmaakdatum;
    private List<String> pakketten;
    private String addons;

    public Klant(String klantID, String naam, String postcode, String huisnummer, String aanmaakdatum,
                 List<String> pakketten, String addons) {
        this.klantID = klantID;
        this.naam = naam;
        this.postcode = postcode;
        this.huisnummer = huisnummer;
        this.aanmaakdatum = aanmaakdatum;
        this.pakketten = pakketten;
        this.addons = addons;
    }

    public String getKlantID() {
        return klantID;
    }

    public void setKlantID(String klantID) {
        this.klantID = klantID;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(String huisnummer) {
        this.huisnummer = huisnummer;
    }

    public String getAanmaakdatum() {
        return aanmaakdatum;
    }

    public void setAanmaakdatum(String aanmaakdatum) {
        this.aanmaakdatum = aanmaakdatum;
    }

    public List<String> getPakketten() {
        return pakketten;
    }

    public void setPakketten(List<String> pakketten) {
        this.pakketten = pakketten;
    }

    public String getAddons() {
        return addons;
    }

    public void setAddons(String addons) {
        this.addons = addons;
    }
}