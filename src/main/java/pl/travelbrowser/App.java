package pl.travelbrowser;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.List;

import pl.travelbrowser.data.OfferLoader;
import pl.travelbrowser.model.Offer;
import pl.travelbrowser.model.SearchCriteria;
import pl.travelbrowser.service.OfferSearch;


public class App {
    private static void runTest(String name, OfferSearch search,
                            List<Offer> offers, SearchCriteria criteria) {
    List<Offer> results = search.search(offers, criteria);
    System.out.println(name + ": " + results.size());
    for (Offer item : results) {
        System.out.println(item);
    }
}
    public static void main(String[] args) {
        OfferLoader offerLoader = new OfferLoader();
        SearchCriteria stars = new SearchCriteria();
        SearchCriteria offerSearchText = new SearchCriteria();
        OfferSearch offerSearch = new OfferSearch();

        try {
            List<Offer> offers = offerLoader.load("data/offers.json");
            for (String error : offerLoader.getErrors()) {
                System.err.println(error);
            }

            // stars.setMinHotelStars(4);
            // offerSearchText.setSearchText("Palm");
            // runTest("min 4 gwiazdki", offerSearch, offers, offerSearchText);
            
            System.out.println("Liczba ofert: " + offers.size());
            // for (Offer offer : offers) {
            //     System.out.println(offer.getTypeName() + ": " + offer);
            // }
        } catch (NoSuchFileException e) {
            System.err.println("Nie znaleziono pliku: "+ e.getMessage());
        } catch (IOException e) {
            System.err.println("Blad: " + e.getMessage());
        }

        

    }
}


