import java.util.List;

class SamenvattingVoorVerkoper {
    public static void printKlantgegevens(Klant klant) {
        System.out.println("Klant ID: " + klant.getKlantID());
        System.out.println("Naam: " + klant.getNaam());
        System.out.println("Postcode: " + klant.getPostcode());
        System.out.println("Huisnummer: " + klant.getHuisnummer());
        System.out.println("Aanmaakdatum: " + klant.getAanmaakdatum());
        System.out.println("Geselecteerde pakketten:");
        for (String pakket : klant.getPakketten()) {
            System.out.println(pakket);
        }

        List<String> addons = klant.getAddons();
        if (!addons.isEmpty()) {
            System.out.println("Geselecteerde addons:");
            for (String addon : addons) {
                System.out.println(addon);
            }
        }
    }
}
