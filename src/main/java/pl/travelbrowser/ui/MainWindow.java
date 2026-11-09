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
    private final FiltersDialog filtersDialog;

    public MainWindow(List<Offer> offers) {
        super("Travel Browser");                                  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        setSize(1920, 1080);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        
        this.offers = offers;
        filtersDialog = new FiltersDialog(this, offers);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(new HeaderPanel(), BorderLayout.NORTH);
        topPanel.add(searchPanel, BorderLayout.CENTER);

        resultsPanel = new ResultsPanel();

        add(resultsPanel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);

        searchPanel.addSearchListener(e -> runSearch());
        filtersDialog.addApplyListener(e -> runSearch());
        resultsPanel.addFiltersListener(e -> filtersDialog.setVisible(true));
        resultsPanel.addSortListener(e -> runSearch());
    }

    private void runSearch() {
        SearchCriteria criteria = searchPanel.buildCriteria();
        filtersDialog.applyTo(criteria);
        List<Offer> results = offerSearch.search(offers, criteria);
        results = offerSearch.sort(results, resultsPanel.getSelectedSort());
        resultsPanel.showOffers(results);
    }
}