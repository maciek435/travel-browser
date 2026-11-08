package pl.travelbrowser.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.net.URI;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;

import pl.travelbrowser.model.Offer;

public class OfferCard extends RoundedPanel {

    private static final int IMAGE_HEIGHT = 140;
    private static final DateTimeFormatter DATE = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private final ImagePanel imagePanel = new ImagePanel();

    public OfferCard(Offer offer) {
        super(16, Theme.CARD_BG, Theme.BORDER);  
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(6, 6, 6, 6));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        imagePanel.setPreferredSize(new Dimension(0, IMAGE_HEIGHT));   
        imagePanel.setBackground(Theme.BORDER);                         
        add(imagePanel, BorderLayout.NORTH);


        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        info.setOpaque(false);
        info.setBorder(new EmptyBorder(10, 8, 8, 8));

        info.add(text(offer.getTitle(), Theme.CARD_TITLE_FONT, Theme.TEXT));
        info.add(text(offer.getTypeName() + " · " + offer.getCountry(), Theme.CARD_TEXT_FONT, Theme.TEXT_MUTED));
        info.add(text(offer.getStartDate().format(DATE) + " - " + offer.getEndDate().format(DATE), Theme.CARD_TEXT_FONT, Theme.TEXT_MUTED));
        info.add(text(String.format("od %.0f zł", offer.getPricePerPerson()), Theme.CARD_TITLE_FONT, Theme.ACCENT));

        add(info, BorderLayout.CENTER);

        if (!offer.getImages().isEmpty()) {
            loadImage(offer.getImages().get(0));
        }
    }

    private JLabel text(String value, Font font, Color color) {
        JLabel label = new JLabel(value);
        label.setForeground(color);
        label.setFont(font);

        return label;
    }

    private void loadImage(String url) {
        new SwingWorker<BufferedImage, Void>() {

            @Override
            protected BufferedImage doInBackground() throws Exception {
                return ImageIO.read(URI.create(url).toURL());
            }

            @Override
            protected void done() {
                try {
                    imagePanel.setImage(get()); 
                } catch (Exception e) {

                }
            }
        }.execute();
    }
}