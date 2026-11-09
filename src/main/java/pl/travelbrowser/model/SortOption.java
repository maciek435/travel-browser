package pl.travelbrowser.model;

public enum SortOption {

    DEFAULT("Domyślnie"),
    PRICE_ASC("Cena: od najniższej"),
    PRICE_DESC("Cena: od najwyższej"),
    RATING_DESC("Najlepiej oceniane"),
    DATE_ASC("Najbliższy termin");

    private final String label;

    SortOption(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}