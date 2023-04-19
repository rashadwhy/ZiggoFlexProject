import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
class SelectiePakketTVZonderInternet {
    private final Scanner scanner = new Scanner(System.in);
    private final List<String> pakketten = new ArrayList<>();

    public void selecteerPakketten() {
        System.out.println("Welk TV pakket wilt u?");
        System.out.println("1. TV Start met mediabox €28,95");
        System.out.println("2. TV Start met CI+ module €29,45");
        System.out.println("Voor meer TV opties is een Internet pakket nodig.");
        int tvKeuze = scanner.nextInt();

        switch (tvKeuze) {
            case 1:
                pakketten.add("TV Start met mediabox");
                break;
            case 2:
                pakketten.add("TV Start met CI+ module");
                break;

            default:
                System.out.println("Ongeldige keuze!");
        }
    }

    public List<String> getPakketten() {
        return pakketten;
    }
}
