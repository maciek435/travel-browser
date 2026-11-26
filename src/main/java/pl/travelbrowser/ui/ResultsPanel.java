package pl.travelbrowser.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import pl.travelbrowser.model.Offer;
import pl.travelbrowser.model.SortOption;


public class ResultsPanel extends JPanel {

    private final JLabel titleLabel = new JLabel();
    private final JPanel grid = new JPanel(new GridLayout(0, 4, 24, 24));
    private final JButton filtersButton = Theme.secondaryButton("Filtry");
    private final JComboBox<SortOption> sortBox = new JComboBox<>(SortOption.values());

    public ResultsPanel() {
        setLayout(new BorderLayout());
        setBackground(Theme.BACKGROUND);
        setBorder(new EmptyBorder(0, 60, 0, 60));

        titleLabel.setFont(Theme.SECTION_TITLE_FONT);
        titleLabel.setForeground(Theme.TEXT);
        
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setOpaque(false);
        topBar.setBorder(new EmptyBorder(0, 0, 16, 0));
        topBar.add(titleLabel, BorderLayout.WEST);
        add(topBar, BorderLayout.NORTH);

        JPanel controls = new JPanel(new FlowLayout(FlowLayout.RIGHT, 12, 0));
        controls.setOpaque(false);
        controls.add(sortBox);
        controls.add(filtersButton);
        topBar.add(controls, BorderLayout.EAST); 

        grid.setOpaque(false);

        JPanel gridHolder = new JPanel(new BorderLayout());
        gridHolder.setOpaque(false);
        gridHolder.add(grid, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(gridHolder);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setBackground(Theme.BACKGROUND);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);  
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void showOffers(List<Offer> offers) {
        titleLabel.setText("Znaleziono " + offers.size() + " ofert");
        grid.removeAll();
        for (Offer offer : offers) {
           grid.add(new OfferCard(offer));
        }
        grid.revalidate();
        grid.repaint();
    }

    public void addFiltersListener(ActionListener listener) {
        filtersButton.addActionListener(listener);
    }

    public SortOption getSelectedSort() {
        return (SortOption) sortBox.getSelectedItem();       
    }

    public void addSortListener(ActionListener listener) {
        sortBox.addActionListener(listener);
    }
}