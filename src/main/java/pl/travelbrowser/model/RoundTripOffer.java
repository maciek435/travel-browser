package pl.travelbrowser.model;

import java.time.LocalDate;
import java.util.List;

public class RoundTripOffer extends Offer {
    private final List<String> tripRoute;

    public RoundTripOffer(int id, String title, String description, String country, LocalDate startDate,
            LocalDate endDate, String departureCity, String transportType, int maxGuests, String mealPlan,
            double pricePerPerson, double customerRating, List<String> images, List<String> tripRoute) {
        super(id, title, description, country, startDate, endDate, departureCity, transportType, maxGuests, mealPlan,
                pricePerPerson, customerRating, images);
        this.tripRoute = tripRoute;
    }

    public List<String> getTripRoute() {
        return tripRoute;
    }

    public String getStartCity() {
        if (tripRoute == null || tripRoute.isEmpty()) {
            return "";
        } else {
            return tripRoute.getFirst();
        }

    }

    @Override
    public String toString() {
        return "#" + getId() + " " + getTitle() + ", " + getCountry() + ", " + getStartCity() + ", "
                + getPricePerPerson() + " zł";
    }

}
