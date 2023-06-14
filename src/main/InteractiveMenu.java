
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class InteractiveMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final KlantDatabase klantDatabase = new KlantDatabase();
    private final PostcodeCheck postcodeCheck = new PostcodeCheck(klantDatabase, "klantendatabase"); // Replace "your-database-name" with the actual database name

    public void run() {
        System.out.println("Welkom bij ZiggoFlex!");
        System.out.println("Bent u een nieuwe of bestaande klant?");
        System.out.println("1. Nieuwe klant");
        System.out.println("2. Bestaande klant");
        int keuze = scanner.nextInt();
        scanner.nextLine();

        if (keuze == 1) {
            nieuweKlantRegistratie();
        } else if (keuze == 2) {
            bestaandeKlantInlog();
        } else {
            System.out.println("Ongeldige keuze!");
        }
    }

    public void nieuweKlantRegistratie() {
        System.out.println("Voer uw naam in:");
        String naam = scanner.nextLine();

        System.out.println("Voer uw postcode in:");
        String postcode = scanner.nextLine();

        if (postcodeCheck.isGeldig(postcode)) {
            System.out.println("Postcode geaccepteerd! Doorgaan met de registratie...");

            System.out.println("Voer uw huisnummer in:");
            String huisnummer = scanner.nextLine();

            String klantID = UUID.randomUUID().toString();
            String aanmaakdatum = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

            List<String> pakketten = selectPakketten();
            String addons = selectAddons();

            Klant klant = klantDatabase.nieuweKlant(klantID, naam, postcode, huisnummer, aanmaakdatum, pakketten, addons);
            System.out.println("Nieuwe klant geregistreerd!");
            System.out.println("Klantgegevens:");
            printKlantgegevens(klant);
        } else {
            System.out.println("Sorry, het opgegeven postcodegebied wordt nog niet ondersteund.");
            System.out.println("Bedankt voor uw interesse in Ziggo. Probeer het later opnieuw.");
            System.exit(0); // Terminate the program
        }
    }

    private void bestaandeKlantInlog() {
        System.out.println("Voer uw postcode in:");
        String postcode = scanner.nextLine();

        System.out.println("Voer uw huisnummer in:");
        String huisnummer = scanner.nextLine();

        Klant klant = klantDatabase.getKlant(postcode, huisnummer);

        if (klant != null) {
            System.out.println("Klant gevonden!");
            System.out.println("Klantgegevens:");
            printKlantgegevens(klant);

            System.out.println("Wilt u uw pakketten wijzigen?");
            System.out.println("1. Ja");
            System.out.println("2. Nee");
            int keuze = scanner.nextInt();
            scanner.nextLine();

            if (keuze == 1) {
                List<String> nieuwePakketten = selectPakketten();
                klant.setPakketten(nieuwePakketten);
            } else {
                klant.setPakketten(Collections.emptyList());
            }

            System.out.println("Wilt u uw addons wijzigen?");
            System.out.println("1. Ja");
            System.out.println("2. Nee");
            keuze = scanner.nextInt();
            scanner.nextLine();

            if (keuze == 1) {
                String nieuweAddons = selectAddons();
                klant.setAddons(nieuweAddons);
            } else {
                klant.setAddons("");
            }

            System.out.println("Klantgegevens bijgewerkt!");
            System.out.println("Nieuwe klantgegevens:");
            printKlantgegevens(klant);
        } else {
            System.out.println("Klant niet gevonden.");
        }
    }

    private void printKlantgegevens(Klant klant) {
        System.out.println("KlantID: " + klant.getKlantID());
        System.out.println("Naam: " + klant.getNaam());
        System.out.println("Postcode: " + klant.getPostcode());
        System.out.println("Huisnummer: " + klant.getHuisnummer());
        System.out.println("Aanmaakdatum: " + klant.getAanmaakdatum());
        System.out.println("Pakketten: " + klant.getPakketten());

        String addons = klant.getAddons();
        if (!addons.equals("Geen addons")) {
            System.out.println("Addons: " + addons);
        }
    }

    private List<String> selectPakketten() {
        System.out.println("Maak alstublieft een keuze voor het pakket:");
        System.out.println("1. Internet & TV");
        System.out.println("2. Alleen TV");
        int pakketKeuze = scanner.nextInt();
        scanner.nextLine();

        if (pakketKeuze == 1) {
            SelectiePakketInternetEnTV pakketSelector = new SelectiePakketInternetEnTV();
            pakketSelector.selecteerPakketten();
            return pakketSelector.getPakketten();
        } else if (pakketKeuze == 2) {
            SelectiePakketTVZonderInternet pakketSelector = new SelectiePakketTVZonderInternet();
            pakketSelector.selecteerPakketten();
            return pakketSelector.getPakketten();
        } else {
            System.out.println("Ongeldige keuze!");
            return new ArrayList<>();
        }
    }

    private String selectAddons() {
        SelectieAddonsPakket addonsSelector = new SelectieAddonsPakket();
        addonsSelector.selecteerAddons();
        return addonsSelector.getAddons();
    }

    public static void main(String[] args) {
        InteractiveMenu menu = new InteractiveMenu();
        menu.run();
    }
}