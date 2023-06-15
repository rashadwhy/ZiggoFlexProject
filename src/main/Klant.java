import java.util.List;

class Klant {
    private final String klantID;
    private final String naam;
    private final String postcode;
    private final String huisnummer;
    private final String aanmaakdatum;
    private List<String> pakketten;
    private List<String> addons;

    public Klant(String klantID, String naam, String postcode, String huisnummer, String aanmaakdatum,
                 List<String> pakketten, List<String> addons) {
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

    public List<String> getPakketten() {
        return pakketten;
    }

    public List<String> getAddons() {
        return addons;
    }

    public void setPakketten(List<String> pakketten) {
        this.pakketten = pakketten;
    }

    public void setAddons(List<String> addons) {
        this.addons = addons;
    }
}
