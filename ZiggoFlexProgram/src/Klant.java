import java.util.List;
class Klant {
    private final String klantID;
    private final String naam;
    private final String postcode;
    private final String huisnummer;
    private final String aanmaakdatum;
    private final String pakketten;
    private final String addons;

    public Klant(String klantID, String naam, String postcode, String huisnummer, String aanmaakdatum, String addons) {
        this.klantID = klantID;
        this.naam = naam;
        this.postcode = postcode;
        this.huisnummer = huisnummer;
        this.aanmaakdatum = aanmaakdatum;
        this.pakketten = "";
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

    public void setPakketten(List<String> pakketten) {
        StringBuilder pakketStringBuilder = new StringBuilder();
        for (String pakket : pakketten) {
            pakketStringBuilder.append(pakket);
            pakketStringBuilder.append(", ");
        }
        this.pakketten = pakketStringBuilder.toString().trim();
    }

    public void setAddons(List<String> addons) {
        StringBuilder addonsStringBuilder = new StringBuilder();
        for (String addon : addons) {
            addonsStringBuilder.append(addon);
            addonsStringBuilder.append(", ");
        }
        this.addons = addonsStringBuilder.toString().trim();
    }

    public String getAddons() {
        return addons;
    }
}


//Naam, postcode en huisnummer wordt hier opgeslagen
//uniek KlantID wordt aangemaakt op basis van info klant
//klasse kan worden aangeroepen om dit te bekijken en aan te passen
//bonus: aanmaakdatum van klant wordt laten zien, en bijbehorende pakket zoals
//op de SamenvattingVoorVerkoper
