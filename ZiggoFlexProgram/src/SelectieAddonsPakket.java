import java.util.Scanner;
import java.util.List;
class SelectieAddonsPakket {
    private final Scanner scanner = new Scanner(System.in);
    private final List<String> addons = new ArrayList<>();

    public void selecteerAddons() {
        System.out.println("Wilt u een vaste lijn?");
        System.out.println("1. Ja");
        System.out.println("2. Nee");
        int vasteLijnKeuze = scanner.nextInt();
        if (vasteLijnKeuze == 1) {
            addons.add("Vaste lijn");
        }

        System.out.println("Wilt u nummerbehoud voor uw vaste lijn?");
        System.out.println("1. Ja");
        System.out.println("2. Nee");
        int nummerbehoudKeuze = scanner.nextInt();
        if (nummerbehoudKeuze == 1) {
            addons.add("Nummerbehoud vaste lijn");
        }

        System.out.println("Wilt u extra TV boxen?");
        System.out.println("1. Ja");
        System.out.println("2. Nee");
        int extraTvBoxKeuze = scanner.nextInt();
        if (extraTvBoxKeuze == 1) {
            addons.add("Extra TV box");
        }
    }

    public List<String> getAddons() {
        return addons;
    }
}
//In deze klasse wordt er weergegeven welke addons de klant kan kiezen na een
//tv en/of internet pakket gekozen te hebben.
//Addons die uit deze klasse te kiezen zijn:
//Vaste lijn: bool
//Nummerbehoud vaste lijn: bool
//extra tv box (voor 2e televisie): bool
//een lijst van deze keuze wordt toegevoegd aan de klasse Klant
//en aan de print van de klasse SamenvattingVoorVerkoper