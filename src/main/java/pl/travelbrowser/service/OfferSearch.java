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
        if (criteria.getHolidayType() != null && !offer.getTypeName().equalsIgnoreCase(criteria.getHolidayType())) {
            return false;
        }

        if (criteria.getCountry() != null && !offer.getCountry().equalsIgnoreCase(criteria.getCountry())) {
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

        if (criteria.getGuests() != null && offer.getMaxGuests() < (criteria.getGuests())) {
            return false;
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
