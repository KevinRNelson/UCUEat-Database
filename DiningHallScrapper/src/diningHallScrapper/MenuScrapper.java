package diningHallScrapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Document;

public interface MenuScrapper {
	
	public Document getDocument(String url);
	
	public Map<String, Map<String, List<MenuItem>>> scrapeMenu(String url) throws IOException;
	
}
