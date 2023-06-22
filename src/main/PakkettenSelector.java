import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PakkettenSelector {
    private final Scanner scanner = new Scanner(System.in);

    public List<String> selectPakketten() {
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
}
