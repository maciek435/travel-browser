package pl.travelbrowser.model;

import java.time.LocalDate;
import java.util.List;

public abstract class Offer {
    private final int id;
    private final String title;
    private final String description;
    private final String country;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String departureCity;
    private final String transportType;
    private final int maxGuests;
    private final String mealPlan;
    private final double pricePerPerson;
    private final double customerRating;
    private final List<String> images; 
    
    public Offer(int id, String title, String description, String country, LocalDate startDate, LocalDate endDate, String departureCity, String transportType, int maxGuests, String mealPlan, double pricePerPerson, double customerRating, List<String> images) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.country = country;
        this.startDate = startDate;
        this.endDate = endDate;
        this.departureCity = departureCity;
        this.transportType = transportType;
        this.maxGuests = maxGuests;
        this.mealPlan = mealPlan;
        this.pricePerPerson = pricePerPerson;
        this.customerRating = customerRating;
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCountry() {
        return country;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public String getTransportType() {
        return transportType;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public String getMealPlan() {
        return mealPlan;
    }

    public double getPricePerPerson() {
        return pricePerPerson;
    }

    public double getCustomerRating() {
        return customerRating;
    }

    public List<String> getImages() {
        return images;
    }

}
