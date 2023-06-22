import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class NieuweKlantRegistratie {

    private final Scanner scanner = new Scanner(System.in);

    public void klantRegistratie() {
        System.out.println("Voer uw naam in:");
        String naam = scanner.nextLine();

        System.out.println("Voer uw postcode in:");
        String postcode = scanner.nextLine();

        if (PostcodeCheck.isGeldig(postcode)) {
            System.out.println("Postcode geaccepteerd! Doorgaan met de registratie...");

            System.out.println("Voer uw huisnummer in:");
            String huisnummer = scanner.nextLine();

            // Create a new instance of KortingChecker
            KortingChecker kortingChecker = new KortingChecker(postcode, huisnummer);

            String klantID = UUID.randomUUID().toString();
            String aanmaakdatum = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

            // Offer a discount for new customers
            if (kortingChecker.isUniek()) {
                System.out.println("Gefeliciteerd! U komt in aanmerking voor een speciale korting in de vorm van Cashback, een MediaMarkt cadeaukaart of maandelijkse korting. Vraag de verkoper voor meer informatie.");
                // Apply the discount logic here
            }

            PakkettenSelector pakketSelector = new PakkettenSelector();
            List<String> pakketten = pakketSelector.selectPakketten();

            SelectieAddonsPakket addonsSelector = new SelectieAddonsPakket();
            addonsSelector.selecteerAddons();
            String addons = addonsSelector.getAddons();

            Klant klant = KlantDatabase.nieuweKlant(klantID, naam, postcode, huisnummer, aanmaakdatum, pakketten, addons);

            System.out.println("Nieuwe klant geregistreerd!");
            System.out.println("Klantgegevens:");
            SamenvattingVoorVerkoper.printKlantgegevens(klant); // Launch the summary for the salesperson
        } else {
            System.out.println("Sorry, het opgegeven postcodegebied wordt nog niet ondersteund.");
            System.out.println("Bedankt voor uw interesse in Ziggo. Probeer het later opnieuw.");
        }
    }
}
