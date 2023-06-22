import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SelectieAddonsPakket {
    private final Scanner scanner = new Scanner(System.in);
    private final List<String> addons = new ArrayList<>();

    public void selecteerAddons() {
        System.out.println("Wilt u addons toevoegen?");
        System.out.println("1. Ja");
        System.out.println("2. Nee");
        int keuze = scanner.nextInt();
        scanner.nextLine();

        if (keuze == 1) {
            System.out.println("Beschikbare addons:");
            System.out.println("1. Ziggo Sport Totaal €14,95,-");
            System.out.println("2. Film1 €9,95,-");
            System.out.println("3. ESPN Compleet €9,95,-");
            System.out.println("4. FOX Sports Compleet €17,95,-");

            System.out.println("Hoeveel addons wilt u toevoegen?");
            int aantalAddons = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < aantalAddons; i++) {
                System.out.println("Voer het nummer van de addon in:");
                int addonKeuze = scanner.nextInt();
                scanner.nextLine();

                switch (addonKeuze) {
                    case 1:
                        addons.add("Ziggo Sport Totaal");
                        break;
                    case 2:
                        addons.add("Film1");
                        break;
                    case 3:
                        addons.add("ESPN Compleet");
                        break;
                    case 4:
                        addons.add("FOX Sports Compleet");
                        break;
                    default:
                        System.out.println("Ongeldige keuze!");
                        break;
                }
            }
        }
    }

    public String getAddons() {
        if (!addons.isEmpty()) {
            return addons.toString();
        } else {
            return "Geen addons";
        }
    }
}