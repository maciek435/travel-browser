package pl.travelbrowser.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import pl.travelbrowser.model.Offer;
import pl.travelbrowser.model.HotelOffer;
import pl.travelbrowser.model.RoundTripOffer;

public class OfferLoader {
    private final List<String> errors = new ArrayList<>();

    private List<String> toStringList(JsonArray array) {
        List<String> stringList = new ArrayList<>();

        for (JsonElement element : array) {
            String stringElement = element.getAsString();
            stringList.add(stringElement);
        }
        return stringList;
    }

    private JsonElement getRequired(JsonObject json, String field) {
        JsonElement value = json.get(field);
        if (value == null || value.isJsonNull()) {
            throw new IllegalArgumentException("brak pola '" + field + "'");
        }
        return value;
    }

    private String getOptionalString(JsonObject json, String field) {
        JsonElement value = json.get(field);
        if (value == null || value.isJsonNull()) {
            return null;
        } else {
            return value.getAsString();
        }
    }

    private String getString(JsonObject json, String field) {
        return getRequired(json, field).getAsString();
    }

    private int getInt(JsonObject json, String field) {
        return getRequired(json, field).getAsInt();
    }

    private double getDouble(JsonObject json, String field) {
        return getRequired(json, field).getAsDouble();
    }

    private LocalDate getDate(JsonObject json, String field) {
        String stringDate = getString(json, field);
        LocalDate date = LocalDate.parse(stringDate);
        return date;
    }

    private List<String> getStringList(JsonObject json, String field) {
        JsonElement value = getRequired(json, field);
        JsonArray valueArray = value.getAsJsonArray();
        List<String> result = toStringList(valueArray);
        return result;
    }

    public List<String> getErrors() {
        return errors;
    }

    public List<Offer> load(String fileName) throws IOException {
        errors.clear();
        String text = Files.readString(Path.of(fileName));

        JsonArray offersArray;
        try {
            offersArray = JsonParser.parseString(text).getAsJsonArray();
        } catch (JsonSyntaxException | IllegalStateException e) {
            throw new IOException("Plik nie zawiera poprawnej listy ofert w formacie JSON", e);
        }

        List<Offer> offers = new ArrayList<>();

        for (int i = 0; i < offersArray.size(); i++) {
            try {
                JsonObject offerJson = offersArray.get(i).getAsJsonObject();

                String type = getString(offerJson, "holidayType");
                String title = getString(offerJson, "title");
                int id = getInt(offerJson, "id");
                String departureCity = getOptionalString(offerJson, "departureCity");
                String description = getString(offerJson, "description");
                String country = getString(offerJson, "country");
                LocalDate startDate = getDate(offerJson, "startDate");
                LocalDate endDate = getDate(offerJson, "endDate");
                String transportType = getString(offerJson, "transportType");
                int maxGuests = getInt(offerJson, "maxGuests");
                String mealPlan = getString(offerJson, "mealPlan");
                double pricePerPerson = getDouble(offerJson, "pricePerPerson");
                double customerRating = getDouble(offerJson, "customerRating");
                List<String> images = getStringList(offerJson, "images");

                Offer offer;
                if (type.equals("HOLIDAY")) {
                    String city = getString(offerJson, "city");
                    int hotelStars = getInt(offerJson, "hotelStars");
                    List<String> facilities = getStringList(offerJson, "facilities");

                    offer = new HotelOffer(id, title, description, country, startDate, endDate, departureCity, transportType, maxGuests, mealPlan, pricePerPerson, customerRating, images, city, hotelStars, facilities);
               
                } else if (type.equals("ROUND_TRIP")) {
                    List<String> tripRoute = getStringList(offerJson, "tripRoute");

                    offer = new RoundTripOffer(id, title, description, country, startDate, endDate, departureCity, transportType, maxGuests, mealPlan, pricePerPerson, customerRating, images, tripRoute);
                } else {
                    throw new IllegalArgumentException("Oferta posiada zly typ: " + type);
                }

                offers.add(offer);
                
            } catch (RuntimeException e) {
                errors.add("Pominięto oferte nr " + (i + 1) + ": " + e.getMessage());
            }
        }

        return offers;
    }
}
