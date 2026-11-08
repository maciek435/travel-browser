package pl.travelbrowser.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.net.URL;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import pl.travelbrowser.model.SearchCriteria;
import raven.datetime.DatePicker;




public class SearchPanel extends ImagePanel {
    
    private final JTextField destinationField = new JTextField();
    private final DatePicker datePicker = new DatePicker();
    private final JFormattedTextField dateField = new JFormattedTextField();
    private final JComboBox<String> guestsBox = new JComboBox<>(new String[] {"Dowolnie", "1", "2", "3",
        "4", "5", "6"});
    private final JButton searchButton = Theme.accentButton("Szukaj ofert");   

    public SearchPanel() {
        setLayout(new GridBagLayout());
        setBackground(Theme.BACKGROUND);
        setPreferredSize(new Dimension(0, 250));
        
        URL url = getClass().getResource("/images/search_background.jpg");
        if (url != null) {
            setImage(new ImageIcon(url).getImage());
        }

        RoundedPanel card = new RoundedPanel(20, new Color(255, 255, 255, 190), null);
        card.setLayout(new FlowLayout(FlowLayout.LEFT, 16, 0));   
        card.setBorder(new EmptyBorder(16, 0, 16, 16));  
        add(card);

        destinationField.setFont(Theme.FIELD_FONT);
        destinationField.setPreferredSize(new Dimension(330, 50));
        destinationField.putClientProperty("JTextField.placeholderText", "Dokąd jedziesz?");

        datePicker.setDateSelectionMode(DatePicker.DateSelectionMode.BETWEEN_DATE_SELECTED);
        datePicker.setDateFormat("dd.MM.yyyy");
        datePicker.setSeparator(" – ");
        datePicker.setCloseAfterSelected(true);
        datePicker.setStartWeekOnMonday(true);
        datePicker.setColor(Theme.ACCENT);
        datePicker.setEditor(dateField);              

        dateField.setFont(Theme.FIELD_FONT);
        dateField.setPreferredSize(new Dimension(260, 28)); 

        guestsBox.setFont(Theme.FIELD_FONT);
        guestsBox.setPreferredSize(new Dimension(135, 28));

        searchButton.setPreferredSize(new Dimension(220, 50));

        card.add(destinationField);
        card.add(labeled("Data wyjazdu", dateField));
        card.add(labeled("Goście", guestsBox));
        card.add(searchButton);
        add(card);
    }

    private JPanel labeled(String text, JComponent field) {
        JLabel label = new JLabel(text);
        label.setFont(Theme.LABEL_FONT);
        label.setForeground(Theme.TEXT);

        JPanel group = new JPanel(new BorderLayout(0, 4));
        group.setOpaque(false);                              
        group.add(label, BorderLayout.NORTH);
        group.add(field, BorderLayout.CENTER);
        return group;
    }

    public SearchCriteria buildCriteria() {
        SearchCriteria criteria = new SearchCriteria();

        String destination = destinationField.getText();
        if (!destination.isBlank()) {
            criteria.setSearchText(destination);
        }

        if (datePicker.isDateSelected()) {
            LocalDate[] range = datePicker.getSelectedDateRange();
            criteria.setDepartureTo(range[1]);
            criteria.setDepartureFrom(range[0]);
        }

        if (guestsBox.getSelectedIndex() > 0) {
            int guests = Integer.parseInt((String) guestsBox.getSelectedItem());
            criteria.setGuests(guests);
        }

        return criteria;
    }

    public void addSearchListener(ActionListener listener) {
        searchButton.addActionListener(listener);
        destinationField.addActionListener(listener);
    }

    //gradient
    @Override 
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int gradientHeight = 90;                          
        int top = getHeight() - gradientHeight;

        Color end = Theme.BACKGROUND;                     
        Color start = new Color(end.getRed(), end.getGreen(), end.getBlue(), 0);
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(new GradientPaint(0, top, start, 0, getHeight(), end));
        g2.fillRect(0, top, getWidth(), gradientHeight);   

    }
}


