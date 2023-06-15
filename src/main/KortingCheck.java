class KortingCheck {
    private final String klantID;
    private final KlantDatabase klantDatabase;

    public KortingCheck(String klantID, KlantDatabase klantDatabase) {
        this.klantID = klantID;
        this.klantDatabase = klantDatabase;
    }

    public boolean isUniek() {
        boolean isUnique = !klantDatabase.existsCustomer(klantID);

        return isUnique;
    }
}
