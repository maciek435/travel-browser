package pl.travelbrowser.model;

import java.time.LocalDate;

public class SearchCriteria {
    private String holidayType;
    private String country;
    private Double minPrice;
    private Double maxPrice;
    private LocalDate departureFrom;
    private LocalDate departureTo;
    private Integer minHotelStars;
    private Integer guests;
    private String searchText;

    public void setHolidayType(String holidayType) {
        this.holidayType = holidayType;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
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

    public String getHolidayType() {
        return holidayType;
    }

    public String getCountry() {
        return country;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
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
