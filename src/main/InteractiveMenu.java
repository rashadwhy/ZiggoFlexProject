import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class InteractiveMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final KlantDatabase klantDatabase = new KlantDatabase();
    private final PostcodeCheck postcodeCheck = new PostcodeCheck(klantDatabase, "klantendatabase");

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

            Klant existingKlant = klantDatabase.getKlant(postcode, huisnummer);
            if (existingKlant != null) {
                System.out.println("Bestaande klant gevonden. De database zal worden bijgewerkt.");

                // Update the package and addons for the existing customer
                List<String> pakketten = selectPakketten();
                List<String> addons = selectAddons();
                existingKlant.setPakketten(pakketten);
                existingKlant.setAddons(addons);

                System.out.println("Klantgegevens bijgewerkt:");
                printKlantgegevens(existingKlant);
            } else {
                System.out.println("Geen bestaande klant gevonden. Nieuwe klant wordt geregistreerd...");

                String klantID = UUID.randomUUID().toString();
                String aanmaakdatum = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                List<String> pakketten = selectPakketten();
                List<String> addons = selectAddons();

                Klant klant = klantDatabase.nieuweKlant(klantID, naam, postcode, huisnummer, aanmaakdatum, pakketten, addons);
                System.out.println("Nieuwe klant geregistreerd!");
                System.out.println("Klantgegevens:");
                printKlantgegevens(klant);
            }
        } else {
            System.out.println("Sorry, het opgegeven postcodegebied wordt nog niet ondersteund, omdat hier nog geen verbindingslijnen zijn aangelegd.");
            System.out.println("Bedankt voor uw interesse in Ziggo. Probeer het later opnieuw.");
            System.exit(0);
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
                System.out.println("Pakketten succesvol gewijzigd!");
            }

            System.out.println("Wilt u uw addons wijzigen?");
            System.out.println("1. Ja");
            System.out.println("2. Nee");
            keuze = scanner.nextInt();
            scanner.nextLine();

            if (keuze == 1) {
                List<String> nieuweAddons = selectAddons();
                klant.setAddons(nieuweAddons);
                System.out.println("Addons succesvol gewijzigd!");
            }

            System.out.println("Nieuwe klantgegevens:");
            printKlantgegevens(klant);
        } else {
            System.out.println("Klant niet gevonden. Probeer het opnieuw of registreer als nieuwe klant.");
        }
    }


    private List<String> selectPakketten() {
        System.out.println("Maak alstublieft een keuze voor het pakket:");
        System.out.println("1. Internet & TV");
        System.out.println("2. Alleen TV");
        int pakketKeuze = scanner.nextInt();
        scanner.nextLine();

        PakketSelector pakketSelector;

        if (pakketKeuze == 1) {
            pakketSelector = new SelectiePakketInternetEnTV();
        } else if (pakketKeuze == 2) {
            pakketSelector = new SelectiePakketTVZonderInternet();
        } else {
            System.out.println("Ongeldige keuze!");
            return new ArrayList<>();
        }

        pakketSelector.selecteerPakketten(scanner);
        List<String> pakketten = pakketSelector.getPakketten();
        List<String> addons = pakketSelector.getAddons();

        System.out.println("Geselecteerde pakketten:");
        for (String pakket : pakketten) {
            System.out.println(pakket);
        }

        System.out.println("Geselecteerde addons:");
        for (String addon : addons) {
            System.out.println(addon);
        }

        return pakketten;
    }

    private List<String> selectAddons() {
        List<String> addons = new ArrayList<>();

        System.out.println("Maak alstublieft een keuze voor de addons:");
        System.out.println("1. Ziggo Sport Totaal");
        System.out.println("2. Film1");
        System.out.println("3. ESPN Compleet");
        System.out.println("4. FOX Sports Compleet");
        System.out.println("0. Stoppen met het toevoegen van addons");

        int addonChoice;
        do {
            addonChoice = scanner.nextInt();
            scanner.nextLine();

            switch (addonChoice) {
                case 1:
                    addons.add("Ziggo Sport Totaal");
                    break;
                case 2:
                    addons.add("Film1");
                    break;
                case 3:
                    addons.add("ESPN Compleet");
                    break;
                case 4:
                    addons.add("FOX Sports Compleet");
                    break;
                case 0:
                    System.out.println("Addons selectie gestopt.");
                    break;
                default:
                    System.out.println("Ongeldige keuze!");
                    break;
            }
        } while (addonChoice != 0);

        return addons;
    }



    private void printKlantgegevens(Klant klant) {
        SamenvattingVoorVerkoper.printKlantgegevens(klant);
    }


    public static void main(String[] args) {
        InteractiveMenu menu = new InteractiveMenu();
        menu.run();
    }
}
