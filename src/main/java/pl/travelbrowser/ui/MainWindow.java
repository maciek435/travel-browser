package pl.travelbrowser.ui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pl.travelbrowser.model.Offer;
import pl.travelbrowser.model.SearchCriteria;
import pl.travelbrowser.service.OfferSearch;

public class MainWindow extends JFrame {

    private final List<Offer> offers;
    private final ResultsPanel resultsPanel;
    private final OfferSearch offerSearch = new OfferSearch();
    private final SearchPanel searchPanel = new SearchPanel();

    public MainWindow(List<Offer> offers) {
        super("Travel Browser");                                  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        setSize(1920, 1080);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        
        this.offers = offers;

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(new HeaderPanel(), BorderLayout.NORTH);
        topPanel.add(searchPanel, BorderLayout.CENTER);

        resultsPanel = new ResultsPanel();

        add(resultsPanel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);

        searchPanel.addSearchListener(e -> {
            SearchCriteria criteria = searchPanel.buildCriteria();
            List<Offer> suitedOffers = offerSearch.search(offers, criteria);
            resultsPanel.showOffers(suitedOffers);
        });

    }
}