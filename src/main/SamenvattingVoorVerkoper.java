class SamenvattingVoorVerkoper {
    public static void print(Klant klant) {
        System.out.println("KlantID: " + klant.getKlantID());
        System.out.println("Naam: " + klant.getNaam());
        System.out.println("Postcode: " + klant.getPostcode());
        System.out.println("Huisnummer: " + klant.getHuisnummer());
        System.out.println("Aanmaakdatum: " + klant.getAanmaakdatum());
        System.out.println("Pakketten: " + klant.getPakketten());
        System.out.println("Addons: " + klant.getAddons());
    }
}
