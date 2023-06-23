class printBewerkteGegevens extends printKlantGegevens {
    @Override
    public void printKlantgegevens(Klant klant) {
        System.out.println("KlantID: " + klant.getKlantID());
        System.out.println("Naam: " + klant.getNaam());
        System.out.println("Postcode: " + klant.getPostcode());
        System.out.println("Huisnummer: " + klant.getHuisnummer());
        System.out.println("");
        System.out.println("Uw Abonnement is aangepast als volgt:");
        System.out.println("");
        System.out.println("Pakketten: " + String.join(", ", klant.getPakketten()));

        String addons = klant.getAddons();
        if (addons != null && !addons.isEmpty()) {
            System.out.println("Addons: " + addons);
        }
    }
}