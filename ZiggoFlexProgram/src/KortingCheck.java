class KortingCheck {
    private final String klantID;

    public KortingCheck(String klantID) {
        this.klantID = klantID;
    }

    public boolean isUniek() {
        return true; // TODO: implementatie
    }
}

//In deze klasse wordt er nagekeken of de Klant een unieke KlantID heeft (bool)
//als dit wel het geval is krijgt de klant als antwoord dat deze in aanmerking
//komt voor korting, cashback of een mediamarkt cadeaukaart. (keuzemenu)