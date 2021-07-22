package diningHallScrapper;

import org.jsoup.nodes.Document;

public interface MenuScrapper {
	
	public Document getDocument(String url);
	
	public Menu scrapeMenu(String url);
	
}
