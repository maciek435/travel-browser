package pl.travelbrowser.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import pl.travelbrowser.model.Offer;

public class OfferLoader {

    public List<Offer> load(String fileName) throws IOException {
        String text = Files.readString(Path.of(fileName));
        System.out.println(text.length());
        return new ArrayList<>();
    }
}
