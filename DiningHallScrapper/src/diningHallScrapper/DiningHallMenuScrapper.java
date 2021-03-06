package diningHallScrapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public abstract class DiningHallMenuScrapper implements MenuScrapper {
		
	// =============================================================================================
    //                                       Abstract  Methods
    // =============================================================================================
	
	abstract Map<String, String> cookies();
		
	abstract String mealTableSelector();
	
	abstract String mealTextSelector();
	
	abstract String mealTableRowSelector();
	
	abstract String mealCategorySelector();
		
	abstract String scrapeMealCategoryTitle(Element mealTableRow);
	
	abstract String dietaryInfoSelector();
	
	abstract String scrapeDietaryInfo(Element dietaryInfo);
	
	// =============================================================================================
    //                                       Template  Methods
    // =============================================================================================
	
	@Override
	public Menu scrapeMenu(String url) {
		Document document = getDocument(url);
		
		Menu result = new Menu();

		for (Element mealTable : document.select(mealTableSelector())) {
			String meal = scrapeMealTitle(mealTable);	
			
			result.menu.put(meal, scrapeMenuItemsForMeal(mealTable));
		}
		
		return result;
	}
	
	@Override
	public Document getDocument(String url) {
		Document document = null;
        try {
        	Connection con = Jsoup.connect(url)
    			.cookies(cookies());

            Connection.Response response = con.execute();

            if (response.statusCode() == 200) {
            	document = con.get();
            } else {
                System.out.println(response.statusCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return document;
	}
	
	// =============================================================================================
    //                                        Private  Methods
    // =============================================================================================
	
	private String scrapeMealTitle(Element mealTable) {
		return mealTable.select(mealTextSelector()).text();
	}
		
	
	private Map<String, List<MenuItem>> scrapeMenuItemsForMeal(Element mealTable) {
		Map<String, List<MenuItem>> result = new LinkedHashMap<>();
		
		List<MenuItem> categoryItems = null;
		for (Element mealTableRow : mealTable.select(mealTableRowSelector())) {
			if (rowContainsCategoryTitle(mealTableRow)) {
				categoryItems = new ArrayList<>();
				addCategoryMenuItemsToMenu(result, scrapeMealCategoryTitle(mealTableRow), categoryItems);
			} else {
				addMenuItem(categoryItems, mealTableRow);
			}
		}
				
		return result;
	}
		
	
	private boolean rowContainsCategoryTitle(Element mealTableRow) {
		return !mealTableRow.select(mealCategorySelector()).isEmpty();
	}
	
	
	private void addCategoryMenuItemsToMenu(Map<String, List<MenuItem>> menu, String mealCategory, List<MenuItem> categoryItems) {
		menu.put(mealCategory, categoryItems);
	}
	
	
	private void addMenuItem(List<MenuItem> categoryItems, Element mealTableRow) {
		categoryItems.add(scrapeMenuItem(mealTableRow));
	}
	
	
	private MenuItem scrapeMenuItem(Element mealTableRow) {
		String menuItemTitle = mealTableRow.text();
		DietaryInfo dietaryNeeds = new DietaryInfo();
		
		for (Element dietaryInfo : mealTableRow.select(dietaryInfoSelector())) {
			dietaryNeeds.addDietaryNeed(scrapeDietaryInfo(dietaryInfo));
		}
		
		return new MenuItem(menuItemTitle, dietaryNeeds);
	}
	
}
