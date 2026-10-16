package pl.travelbrowser.model;

import java.time.LocalDate;
import java.util.List;

public class HotelOffer extends Offer {
    
    private final String city;
    private final int hotelStars;
    private final List<String> facilities;

    public HotelOffer(int id, String title, String description, String country, LocalDate startDate, LocalDate endDate, String departureCity, String transportType, int maxGuests, String mealPlan, double pricePerPerson, double customerRating, List<String> images, String city, int hotelStars, List<String> facilities) {
        super(id, title, description, country, startDate, endDate, departureCity, transportType, maxGuests, mealPlan, pricePerPerson, customerRating, images);
        this.city = city;
        this.hotelStars = hotelStars;
        this.facilities = facilities;
    }

    public String getCity() {
        return city;
    }

    public int getHotelStars() {
        return hotelStars;
    }

    public List<String> getFacilities() {
        return facilities;
    }

    @Override 
    public String toString() {
        return "#" + getId() + " " + getTitle() + ", " + city + ", " + getCountry() + ", " + hotelStars + "*, " + getPricePerPerson() + " zł";
    }
}
