import java.util.List;

class Klant {
    private final String klantID;
    private final String naam;
    private final String postcode;
    private final String huisnummer;
    private final String aanmaakdatum;
    private final String pakketten;
    private final String addons;

    public Klant(String klantID, String naam, String postcode, String huisnummer, String aanmaakdatum, String pakketten, String addons) {
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

    public String getPakketten() {
        return pakketten;
    }

    public String getAddons() {
        return addons;
    }

    public void setPakketten(List<String> pakketten) {
    }

    public void setAddons(List<String> addons) {
    }
}

