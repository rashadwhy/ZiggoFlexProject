import java.util.Scanner;

public class KeuzeMenu {
    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("Welkom bij ZiggoFlex!");
        System.out.println("Bent u een nieuwe of bestaande klant?");
        System.out.println("1. Nieuwe klant");
        System.out.println("2. Bestaande klant");
        int keuze = scanner.nextInt();
        scanner.nextLine();

        KlantRegistratie registratie;

        if (keuze == 1) {
            registratie = new NieuweKlantRegistratie();
        } else if (keuze == 2) {
            registratie = new BestaandeKlantInlog();
        } else {
            System.out.println("Ongeldige keuze!");
            return;
        }

        registratie.klantRegistratie();
    }



    public static void main(String[] args) {
        KeuzeMenu menu = new KeuzeMenu();
        menu.run();
    }
}
