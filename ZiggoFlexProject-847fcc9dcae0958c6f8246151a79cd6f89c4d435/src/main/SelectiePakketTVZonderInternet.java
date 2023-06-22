import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SelectiePakketTVZonderInternet {
    private final Scanner scanner = new Scanner(System.in);
    private final List<String> pakketten = new ArrayList<>();

    public void selecteerPakketten() {
        System.out.println("Welk TV pakket wilt u?");
        System.out.println("1. TV Start €28,95,-");
        System.out.println("2. TV Complete €21,-");
        System.out.println("3. TV Max €33,-");
        int tvKeuze = scanner.nextInt();

        switch (tvKeuze) {
            case 1 -> pakketten.add("TV Start");
            case 2 -> pakketten.add("TV Complete");
            case 3 -> pakketten.add("TV Max");
            default -> System.out.println("Ongeldige keuze!");
        }
    }

    public List<String> getPakketten() {
        return pakketten;
    }
}