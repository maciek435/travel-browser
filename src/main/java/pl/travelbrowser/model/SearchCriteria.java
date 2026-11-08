package pl.travelbrowser.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class SearchCriteria {
    private final Set<String> holidayTypes = new HashSet<>();
    private final Set<String> countries = new HashSet<>();
    private final Set<String> departureCities = new HashSet<>();
    private final Set<String> transportTypes = new HashSet<>();
    private final Set<String> mealPlans = new HashSet<>();
    private final Set<String> facilities = new HashSet<>();

    private Double minPrice;
    private Double maxPrice;
    private Double minRating;
    private LocalDate departureFrom;
    private LocalDate departureTo;
    private Integer minHotelStars;
    private Integer guests;
    private String searchText;

    public Set<String> getHolidayTypes() {
        return holidayTypes;
    }

    public Set<String> getCountries() {
        return countries;
    }

    public Set<String> getDepartureCities() {
        return departureCities;
    }

    public Set<String> getTransportTypes() {
        return transportTypes;
    }

    public Set<String> getMealPlans() {
        return mealPlans;
    }

    public Set<String> getFacilities() {
        return facilities;
    }
    
    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public void setMinRating(Double minRating) {
        this.minRating = minRating;
    }

    public void setDepartureFrom(LocalDate departureFrom) {
        this.departureFrom = departureFrom;
    }

    public void setDepartureTo(LocalDate departureTo) {
        this.departureTo = departureTo;
    }

    public void setMinHotelStars(Integer minHotelStars) {
        this.minHotelStars = minHotelStars;
    }

    public void setGuests(Integer guests) {
        this.guests = guests;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public Double getMinRating() {
        return minRating;
    }

    public LocalDate getDepartureFrom() {
        return departureFrom;
    }

    public LocalDate getDepartureTo() {
        return departureTo;
    }

    public Integer getMinHotelStars() {
        return minHotelStars;
    }

    public Integer getGuests() {
        return guests;
    }

    public String getSearchText() {
        return searchText;
    }

    
}
