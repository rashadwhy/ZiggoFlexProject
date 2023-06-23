import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class BestaandeKlantInlog implements KlantRegistratie {
    private final Scanner scanner = new Scanner(System.in);
    private final KlantDatabase klantDatabase = new KlantDatabase();

    public void klantRegistratie() {
        System.out.println("Voer uw postcode in:");
        String postcode = scanner.nextLine();

        System.out.println("Voer uw huisnummer in:");
        String huisnummer = scanner.nextLine();

        Klant klant = klantDatabase.getKlant(postcode, huisnummer);

        if (klant != null) {
            System.out.println("Klant gevonden!");
            System.out.println("Klantgegevens:");
            printKlantGegevens klantGegevens = new printKlantGegevens();
            klantGegevens.printKlantgegevens(klant);
            System.out.println("Wilt u uw pakketten wijzigen?");
            System.out.println("1. Ja");
            System.out.println("2. Nee");
            int keuze = scanner.nextInt();
            scanner.nextLine();

            if (keuze == 1) {
                PakkettenSelector pakketSelector = new PakkettenSelector();
                List<String> pakketten = pakketSelector.selectPakketten();
                klant.setPakketten(pakketten);
            } else {
                klant.setPakketten(Collections.emptyList());
            }

            System.out.println("Wilt u uw addons wijzigen?");
            System.out.println("1. Ja");
            System.out.println("2. Nee");
            keuze = scanner.nextInt();
            scanner.nextLine();

            if (keuze == 1) {
                SelectieAddonsPakket addonsSelector = new SelectieAddonsPakket();
                addonsSelector.selecteerAddons();
                String addons = addonsSelector.getAddons();
                klant.setAddons(addons);
            } else {
                klant.setAddons("");
            }

            System.out.println("Klantgegevens bijgewerkt!");
            System.out.println("Nieuwe klantgegevens:");
            printBewerkteGegevens bewerkteGegevens = new printBewerkteGegevens();
            bewerkteGegevens.printKlantgegevens(klant);

            klantDatabase.saveToXml(); // Update the customer information in the XML file
        } else {
            System.out.println("Klant niet gevonden.");
        }
    }
}
