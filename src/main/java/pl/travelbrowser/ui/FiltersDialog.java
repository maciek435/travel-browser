package pl.travelbrowser.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import pl.travelbrowser.model.HotelOffer;
import pl.travelbrowser.model.Offer;
import pl.travelbrowser.model.SearchCriteria;

public class FiltersDialog extends JDialog {

    private final List<JCheckBox> transportBoxes = new ArrayList<>();
    private final List<JCheckBox> mealBoxes = new ArrayList<>();
    private final List<JCheckBox> typeBoxes = new ArrayList<>();
    private final List<JCheckBox> countryBoxes = new ArrayList<>();
    private final List<JCheckBox> cityBoxes = new ArrayList<>();
    private final List<JCheckBox> facilityBoxes = new ArrayList<>();

    private final JButton applyButton = Theme.accentButton("Zastosuj");
    private final JButton clearButton = new JButton("Wyczyść");

    public FiltersDialog(JFrame owner, List<Offer> offers) {
        super(owner, "Filtry", true);          
        setSize(700, 600);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout());

        JPanel groups = new JPanel();
        groups.setLayout(new BoxLayout(groups, BoxLayout.Y_AXIS));
        groups.setBorder(new EmptyBorder(16, 16, 16, 16));

        JPanel transport = group("Transport");
        addOption(transport, transportBoxes, "Samolot", "PLANE");
        addOption(transport, transportBoxes, "Autokar", "BUS");
        addOption(transport, transportBoxes, "Dojazd własny", "OWN");
        
        JPanel meals = group("Wyżywienie");
        addOption(meals, mealBoxes, "All inclusive", "ALL_INCLUSIVE");
        addOption(meals, mealBoxes, "Pełne wyżywienie", "FULL_BOARD");
        addOption(meals, mealBoxes, "Śniadania i obiadokolacje", "HALF_BOARD");
        addOption(meals, mealBoxes, "Śniadania", "BREAKFAST");
        addOption(meals, mealBoxes, "Bez wyżywienia", "ROOM_ONLY");
        
        JPanel facilitiesPanel = group("Udogodnienia");
        Set<String> facilities = new TreeSet<>();
        for (Offer offer : offers) {
             if (offer instanceof HotelOffer hotel) {
                facilities.addAll(hotel.getFacilities());
            }
        }
        for (String facility : facilities) {
            addOption(facilitiesPanel, facilityBoxes, facility, facility);
        }
        
        JPanel types = group("Rodzaj wycieczki");
        addOption(types, typeBoxes, "Wypoczynek", "Wypoczynek");
        addOption(types, typeBoxes, "Wycieczka objazdowa", "Wycieczka objazdowa");
        
        JPanel countriesPanel = group("Kraj");
        Set<String> countries = new TreeSet<>();
        for (Offer offer : offers) {
            countries.add(offer.getCountry());
        }
        for (String country : countries) {
            addOption(countriesPanel, countryBoxes, country, country);
        }
        
        JPanel departureCitiesPanel = group("Wylot z");
        Set<String> departureCities = new TreeSet<>();
        for (Offer offer : offers) {
            if (offer.getDepartureCity() != null) {
                departureCities.add(offer.getDepartureCity());
            }
        }
        for (String departureCity : departureCities) {
            addOption(departureCitiesPanel, cityBoxes, departureCity, departureCity);
        }
        
        groups.add(types);
        groups.add(countriesPanel);
        groups.add(departureCitiesPanel);
        groups.add(transport);
        groups.add(meals);
        groups.add(facilitiesPanel);

        add(new JScrollPane(groups), BorderLayout.CENTER);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT, 12, 12));
        buttons.add(clearButton);
        buttons.add(applyButton);
        add(buttons, BorderLayout.SOUTH);

        clearButton.addActionListener(e -> clear());
        applyButton.addActionListener(e -> setVisible(false)); 
    }

    private JPanel group(String title) {
        JPanel panel = new JPanel(new GridLayout(0, 3, 8, 4));
        panel.setBorder(BorderFactory.createTitledBorder(title));
        return panel;
    }

    private void addOption(JPanel panel, List<JCheckBox> boxes, String label, String code) {
        JCheckBox box = new JCheckBox(label);
        box.setActionCommand(code);
        boxes.add(box);
        panel.add(box);
    }

    public void applyTo(SearchCriteria criteria) {
        addSelected(transportBoxes, criteria.getTransportTypes());
        addSelected(mealBoxes, criteria.getMealPlans());
        addSelected(typeBoxes, criteria.getHolidayTypes());
        addSelected(countryBoxes, criteria.getCountries());
        addSelected(facilityBoxes, criteria.getFacilities());
        addSelected(cityBoxes, criteria.getDepartureCities());
    }

    private void addSelected(List<JCheckBox> boxes, Set<String> target) {
        for (JCheckBox box : boxes) {
            if (box.isSelected()) {
                target.add(box.getActionCommand());
            }
        }
    }

    private void clearBoxes(List<JCheckBox> boxes) {
        for (JCheckBox box : boxes) {
            box.setSelected(false);
        }
    }

    private void clear() {
        clearBoxes(mealBoxes);
        clearBoxes(transportBoxes);
        clearBoxes(typeBoxes);
        clearBoxes(countryBoxes);
        clearBoxes(facilityBoxes);
        clearBoxes(cityBoxes);
    }

    public void addApplyListener(ActionListener listener) {
        applyButton.addActionListener(listener);
    }
}