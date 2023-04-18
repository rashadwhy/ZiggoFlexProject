import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
class SelectiePakketTVZonderInternet {
    private final Scanner scanner = new Scanner(System.in);
    private final List<String> pakketten = new ArrayList<>();

    public void selecteerPakketten() {
        System.out.println("Welk TV pakket wilt u?");
        System.out.println("1. TV Start");
        System.out.println("2. TV Complete");
        System.out.println("3. TV Max");
        int tvKeuze = scanner.nextInt();

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
    }

    public List<String> getPakketten() {
        return pakketten;
    }
}

//In deze klasse wordt er gekozen tussen TV pakketten als er geen internet pakket
//gewenst is door de klant. De keuze is:

//Internet start: bool
//Internet complete: bool
//Internet Max: bool

//een lijst van deze keuze wordt toegevoegd aan de klasse Klant
//en aan de print van de klasse SamenvattingVoorVerkoper