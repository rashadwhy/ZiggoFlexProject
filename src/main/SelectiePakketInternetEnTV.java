import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
class SelectiePakketInternetEnTV {
    private final Scanner scanner = new Scanner(System.in);
    private final List<String> pakketten = new ArrayList<>();

    public void selecteerPakketten() {
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
        }
    }

    public List<String> getPakketten() {
        return pakketten;
    }
}