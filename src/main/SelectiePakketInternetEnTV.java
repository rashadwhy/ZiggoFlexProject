import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SelectiePakketInternetEnTV implements PakketSelector {
    private final List<String> pakketten = new ArrayList<>();
    private final List<String> addons = new ArrayList<>();

    public void selecteerPakketten(Scanner scanner) {
        System.out.println("Welk TV pakket wilt u?");
        System.out.println("1. TV Start €28,95,-");
        System.out.println("2. TV Complete €21,-");
        System.out.println("3. TV Max €33,-");
        int tvKeuze = scanner.nextInt();

        System.out.println("Welk Internet pakket wilt u?");
        System.out.println("1. Internet Start €43,-");
        System.out.println("2. Internet Complete €53,-");
        System.out.println("3. Internet Max €62,-");
        int internetKeuze = scanner.nextInt();

        switch (tvKeuze) {
            case 1:
                pakketten.add("TV Start");
                break;
            case 2:
                pakketten.add("TV Complete");
                break;
            case 3:
                pakketten.add("TV Max");
                break;
            default:
                System.out.println("Ongeldige keuze!");
                break;
        }

        switch (internetKeuze) {
            case 1:
                pakketten.add("Internet Start");
                break;
            case 2:
                pakketten.add("Internet Complete");
                break;
            case 3:
                pakketten.add("Internet Max");
                break;
            default:
                System.out.println("Ongeldige keuze!");
                break;
        }
    }

    public List<String> getPakketten() {
        return pakketten;
    }

    public List<String> getAddons() {
        return addons;
    }

    public void displayPakketten() {
        System.out.println("Geselecteerde pakketten:");
        for (String pakket : pakketten) {
            System.out.println(pakket);
        }
    }
}
