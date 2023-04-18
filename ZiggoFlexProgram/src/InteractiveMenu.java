import java.util.Scanner;
import java.util.List;
class InteractiveMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final KlantDatabase database = new KlantDatabase();

    public void run() {
        System.out.println("Welkom bij Ubuy!");
        System.out.println("Bent u een nieuwe of bestaande klant?");
        System.out.println("1. Nieuwe klant");
        System.out.println("2. Bestaande klant");

        int keuze = scanner.nextInt();
        if (keuze == 1) {
            nieuweKlant();
        } else if (keuze == 2) {
            bestaandeKlant();
        } else {
            System.out.println("Ongeldige keuze!");
        }
    }

    private void nieuweKlant() {
        System.out.println("Voer uw naam in:");
        String naam = scanner.next();
        System.out.println("Voer uw postcode in:");
        String postcode = scanner.next();
        System.out.println("Voer uw huisnummer in:");
        String huisnummer = scanner.next();
        Klant klant = database.nieuweKlant(naam, postcode, huisnummer);
        selecteerPakketten(klant);
    }

    private void bestaandeKlant() {
        System.out.println("Voer uw postcode in:");
        String postcode = scanner.next();
        System.out.println("Voer uw huisnummer in:");
        String huisnummer = scanner.next();
        Klant klant = database.getKlant(postcode, huisnummer);
        if (klant == null) {
            System.out.println("We hebben uw informatie niet kunnen vinden. Probeer opnieuw of spreek een medewerker aan om u te helpen.");
        } else {
            PostcodeCheck postcodeCheck = new PostcodeCheck(postcode);
            if (!postcodeCheck.isGeldig()) {
                System.out.println("Helaas kunnen we op uw locatie geen verbinding leveren.");
                return;
            }
            KortingCheck kortingCheck = new KortingCheck(klant.getKlantID());
            if (kortingCheck.isUniek()) {
                System.out.println("Als klant met een uniek KlantID komt u in aanmerking voor korting, cashback of een media markt cadeaukaart.");
            }
            selecteerPakketten(klant);
        }
    }

    private void selecteerPakketten(Klant klant) {
        System.out.println("Welk pakket wilt u selecteren?");
        System.out.println("1. Internet en TV");
        System.out.println("2. TV zonder internet");
        int keuze = scanner.nextInt();

        if (keuze == 1) {
            SelectiePakketInternetEnTV selectiePakket = new SelectiePakketInternetEnTV();
            selectiePakket.selecteerPakketten();
            klant.setPakketten(selectiePakket.getPakketten());
        } else if (keuze == 2) {
            SelectiePakketTVZonderInternet selectiePakket = new SelectiePakketTVZonderInternet();
            selectiePakket.selecteerPakketten();
            klant.setPakketten(selectiePakket.getPakketten());
        } else {
            System.out.println("Ongeldige keuze!");
        }

        SelectieAddonsPakket selectieAddonsPakket = new SelectieAddonsPakket();
        selectieAddonsPakket.selecteerAddons();
        klant.setAddons(selectieAddonsPakket.getAddons());

        SamenvattingVoorVerkoper.print(klant);
    }
}

//Welkom klant
//Vraag of er een nieuwe of bestaande klant is

//Vraag of klant het pakket wilt wijzigen (als oude klant)
//Bij bestaande klant vraag naar postcode, huisnummer en naam.
//Controleer of dit overeenkomt met een KlantID. Als dit niet zo is,
//Vertel: "We hebben uw informatie niet kunnen vinden, probeer opnieuw
//of spreek onze medewerker aan om u te helpen".

//Als er een overeenkomst is met een KlantID, voer PostcodeCheck en KortingCheck uit
//en laat de klant een keuze maken

//tussen de verschillende pakketten met behulp van de SelectiePakketInternetEnTv of
//klasse of SelectiePakketTVZonderInternet als er geen Internet gewenst is.
//als laatste de keuze uit de klasse SelectieAddonsPakket

//Vraag of klant een nieuw pakket wilt samenstellen (als nieuwe klant)
//Vraag naar naam, postcode en huisnummer.

//Als er een KlantID is aangemaakt, laat de klant een keuze maken
//tussen de verschillende pakketten met behulp van de SelectiePakketInternetEnTv
//klasse of SelectiePakketTVZonderInternet en als laatste de keuze uit de klasse
//SelectieAddonsPakket

//Alle keuzes en/of wijzigingen worden geprint via SamenvattingVoorVerkoper
//ook wordt alle info van de klant (KlantID, Naam, Postcode) op de samenvatting
//gezet