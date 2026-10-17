package pl.travelbrowser.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import pl.travelbrowser.model.Offer;

public class OfferLoader {
    private final List<String> errors = new ArrayList<>();

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

        for (int i = 0; i < offersArray.size(); i++) {
            try {
                JsonObject offerJson = offersArray.get(i).getAsJsonObject();
                String title = offerJson.get("title").getAsString();
                int id = offerJson.get("id").getAsInt();
                System.out.println(id + ": " + title);
            } catch (RuntimeException e) {
                errors.add("Pominięto oferte nr " + (i + 1) + ": " + e.getMessage());
            }
        }

        return new ArrayList<>();
    }
}
