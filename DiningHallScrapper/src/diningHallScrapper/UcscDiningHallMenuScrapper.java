package diningHallScrapper;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.nodes.Element;

public class UcscDiningHallMenuScrapper extends DiningHallMenuScrapper implements MenuScrapper {

	// =============================================================================================
    //                                      Overridden  Methods
    // =============================================================================================
	
	@Override
	Map<String, String> cookies() {
		Map<String, String> result = new HashMap<>();

		result.put("WebInaCartDates", "");
		result.put("WebInaCartMeals", "");
		result.put("WebInaCartRecipes", "");
		result.put("WebInaCartQtys", "");
		result.put("WebInaCartLocation", "25");
		
		return result;
	}
	
	
	@Override
	String mealTableSelector() {
		return "body > table:nth-of-type(2) > tbody > tr";
	}
	
	
	@Override
	String mealTextSelector() {
		return ".shortmenumeals";
	}
	
	
	@Override
	String mealTableRowSelector() {
		return "td > table > tbody > tr:nth-of-type(2) > td > table > tbody > tr";
	}
	
	
	@Override
	String mealCategorySelector() {
		return ".shortmenucats";
	}
	
	
	@Override
	String scrapeMealCategoryTitle(Element mealTableRow) {
		return mealTableRow.text().replace("-", "").trim();
	}
	
	
	@Override
	String dietaryInfoSelector() {
		return "img";
	}
	
	
	@Override
	String scrapeDietaryInfo(Element dietaryInfo) {
		return dietaryInfo.attr("src").replace("LegendImages/", "").replace(".gif", "");
	}
}
