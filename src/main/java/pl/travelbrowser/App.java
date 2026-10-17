package pl.travelbrowser;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.List;

import pl.travelbrowser.data.OfferLoader;
import pl.travelbrowser.model.Offer;

public class App {
    public static void main(String[] args) {
        OfferLoader offerLoader = new OfferLoader();
        try {
            List<Offer> offers = offerLoader.load("data/offers.json");
            for (String error : offerLoader.getErrors()) {
                System.err.println(error);
            }
        } catch (NoSuchFileException e) {
            System.err.println("Nie znaleziono pliku: "+ e.getMessage());
        } catch (IOException e) {
            System.err.println("Blad: " + e.getMessage());
        }

    }
}


