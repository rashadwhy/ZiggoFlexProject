import java.util.Scanner;

public class KeuzeMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final KlantDatabase klantDatabase = new KlantDatabase();
    public void run() {
        System.out.println("Welkom bij ZiggoFlex!");
        System.out.println("Bent u een nieuwe of bestaande klant?");
        System.out.println("1. Nieuwe klant");
        System.out.println("2. Bestaande klant");
        int keuze = scanner.nextInt();
        scanner.nextLine();

        if (keuze == 1) {
            NieuweKlantRegistratie nieuweKlantRegistratie = new NieuweKlantRegistratie();
            nieuweKlantRegistratie.klantRegistratie();
        } else if (keuze == 2) {
            BestaandeKlantInlog bestaandeKlantInlog = new BestaandeKlantInlog();
            bestaandeKlantInlog.KlantInlog();
        } else {
            System.out.println("Ongeldige keuze!");
        }
    }


    public static void main(String[] args) {
        KeuzeMenu menu = new KeuzeMenu();
        menu.run();
    }
}
