import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
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
