class PostcodeCheck {
    private final String postcode;

    public PostcodeCheck(String postcode) {
        this.postcode = postcode;
    }

    public boolean isGeldig() {
        return true; // TODO: implementatie
    }
}
//Hier wordt een controle uitgevoerd of de klant op een locatie woont
//waar er een verbinding mogelijk is en wat de maximale beschikbare snelheid is
//er wordt weergegeven of de snelheid wel/niet mogelijk is en de max. snelheid
//(1GBPS)


//beschikbare postcodes worden nog toegevoegd wanneer er een geldige lijst
//opgesteld kan worden, dus voor nu wordt aangenomen dat alle postcodes geldig
//zijn.