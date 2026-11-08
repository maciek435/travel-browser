package pl.travelbrowser.service;

import pl.travelbrowser.model.SearchCriteria;
import pl.travelbrowser.model.HotelOffer;
import pl.travelbrowser.model.Offer;
import java.util.List;
import java.util.ArrayList;

public class OfferSearch {
    public List<Offer> search (List<Offer> offers, SearchCriteria criteria) {
        List<Offer> matchesList = new ArrayList<>();
        for (Offer offer : offers) {
            if (matches(offer, criteria)) {
                matchesList.add(offer);
            }
        }
        return matchesList;
    }

    private boolean matches (Offer offer, SearchCriteria criteria) {
        if (!criteria.getHolidayTypes().isEmpty() && !criteria.getHolidayTypes().contains(offer.getTypeName())) {
            return false;
        }

        if (!criteria.getCountries().isEmpty() && !criteria.getCountries().contains(offer.getCountry())) {
            return false;
        }

        if (!criteria.getDepartureCities().isEmpty() && !criteria.getDepartureCities().contains(offer.getDepartureCity())) {
            return false;
        }

        if (!criteria.getTransportTypes().isEmpty() && !criteria.getTransportTypes().contains(offer.getTransportType())) {
            return false;
        }

        if (!criteria.getMealPlans().isEmpty() && !criteria.getMealPlans().contains(offer.getMealPlan())) {
            return false;
        }

        if (criteria.getMinPrice() != null && offer.getPricePerPerson() < criteria.getMinPrice()) {
            return false;
        }

        if (criteria.getMaxPrice() != null && offer.getPricePerPerson() > criteria.getMaxPrice()) {
            return false;
        }

        if (criteria.getDepartureFrom() != null && offer.getStartDate().isBefore(criteria.getDepartureFrom())) {
            return false;
        }

        if (criteria.getDepartureTo() != null && offer.getStartDate().isAfter(criteria.getDepartureTo())) {
            return false;
        }

        if (criteria.getMinHotelStars() != null) {
            if (!(offer instanceof HotelOffer hotel)) {
                return false;
            }
            if (hotel.getHotelStars() < criteria.getMinHotelStars()) {
                return false;
            }
        }

        if (!criteria.getFacilities().isEmpty()) {
            if (!(offer instanceof HotelOffer hotel)) {
                return false;                      
            }
            if (!hotel.getFacilities().containsAll(criteria.getFacilities())) {
                return false;                      
            }
        }

        if (criteria.getSearchText() != null && !criteria.getSearchText().isBlank()) {
            String query = criteria.getSearchText().trim().toLowerCase();
            boolean result = offer.getTitle().toLowerCase().contains(query) ||
                offer.getDescription().toLowerCase().contains(query) ||
                offer.getCountry().toLowerCase().contains(query); 
            if (!result) {return false;}
        }

        return true;
    }
}
