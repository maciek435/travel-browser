package pl.travelbrowser;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import pl.travelbrowser.data.OfferLoader;
import pl.travelbrowser.model.Offer;
import pl.travelbrowser.ui.MainWindow;


public class App {
    public static void main(String[] args) {
        OfferLoader offerLoader = new OfferLoader();
        
        try {
            List<Offer> offers = offerLoader.load("data/offers.json");
            for (String error : offerLoader.getErrors()) {
                System.err.println(error);
            }

            System.out.println("Liczba ofert: " + offers.size());

            FlatLightLaf.setup();
            UIManager.put("Button.arc", 12);       
            UIManager.put("Component.arc", 12);    
            UIManager.put("TextComponent.arc", 12);

            SwingUtilities.invokeLater(() -> new MainWindow(offers).setVisible(true));
            
        } catch (NoSuchFileException e) {
            System.err.println("Nie znaleziono pliku: "+ e.getMessage());
        } catch (IOException e) {
            System.err.println("Blad: " + e.getMessage());
        }

        

        

    }
}


