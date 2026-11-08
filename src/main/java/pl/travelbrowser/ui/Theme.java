package pl.travelbrowser.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JButton;

public final class Theme {

    public static final Color HEADER_BG  = new Color(0x0F2541);  // granat nagłówka
    public static final Color BACKGROUND = new Color(0xF4F7FB);  // jasne tło strony
    public static final Color CARD_BG    = Color.WHITE;
    public static final Color BORDER     = new Color(0xDDE3EA);  // obramowanie kart
    public static final Color ACCENT     = new Color(0xFF6B4A);  // koralowy przycisk
    public static final Color TEXT       = new Color(0x1B2A3A);
    public static final Color TEXT_MUTED = new Color(0x5B6B7C);  // szary tekst w kartach
    private static final String FONT_FAMILY = "Inter";

    public static final Font CARD_TITLE_FONT = new Font(FONT_FAMILY, Font.BOLD, 16);
    public static final Font BUTTON_FONT = new Font(FONT_FAMILY, Font.BOLD, 18);
    public static final Font SECTION_TITLE_FONT = new Font(FONT_FAMILY, Font.BOLD, 22);
    public static final Font LOGO_FONT = new Font(FONT_FAMILY, Font.BOLD, 26);
    public static final Font CARD_TEXT_FONT = new Font(FONT_FAMILY, Font.PLAIN, 14);
    public static final Font LABEL_FONT = new Font(FONT_FAMILY, Font.PLAIN, 15);
    public static final Font NAV_FONT = new Font(FONT_FAMILY, Font.PLAIN, 16);
    public static final Font FIELD_FONT = new Font(FONT_FAMILY, Font.PLAIN, 17);

    public static JButton navButton(String text) {
        JButton button = new JButton(text);
        button.setFont(NAV_FONT);
        button.setForeground(Color.WHITE);
        button.setContentAreaFilled(false);   // bez tła
        button.setBorderPainted(false);       // bez ramki
        button.setFocusPainted(false);        // bez ramki po kliknięciu
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));  // "rączka" jak przy linku
        return button;
    }

    public static JButton accentButton(String text) {
        JButton button = new JButton(text);
        button.setFont(BUTTON_FONT);
        button.setForeground(Color.WHITE);
        button.setBackground(ACCENT);
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return button;
    }
    
    public static JButton secondaryButton(String text) {
        JButton button = new JButton(text);
        button.setFont(FIELD_FONT);
        button.setForeground(HEADER_BG);
        button.setBackground(Color.WHITE);
        button.putClientProperty("JButton.borderColor", BORDER);
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return button;
    }
    
}