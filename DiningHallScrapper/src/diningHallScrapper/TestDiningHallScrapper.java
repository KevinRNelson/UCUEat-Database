package diningHallScrapper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDiningHallScrapper {
	
	private Menu menu;
	private Map<String, Map<String, List<MenuItem>>> result;
	private MenuScrapper menuScrapper = MenuScrapperFactory.createMenuScrapper("UcscDiningHall");
	
	
	@BeforeEach
	void setUp() throws Exception {
		String porter_url = "https://nutrition.sa.ucsc.edu/shortmenu.aspx?sName=UC+Santa+Cruz+Dining&locationNum=25&locationName=Porter+Kresge+Dining+Hall&naFlag=1";
		menu = menuScrapper.scrapeMenu(porter_url);
		result = menu.menu;
	}
	
	
	@Test
	void testScrappedMealTitles() {
		assertTrue(result.containsKey("Breakfast"));
		assertTrue(result.containsKey("Lunch"));
		assertTrue(result.containsKey("Dinner"));
	}
	
	
	@Test
	void testScrappedCategoryTitles() {
		assertTrue(result.get("Breakfast").containsKey("Breakfast"));
		assertTrue(result.get("Breakfast").containsKey("Daily"));
		assertTrue(result.get("Breakfast").containsKey("Bakery"));
		
		assertTrue(result.get("Lunch").containsKey("Soups"));
		assertTrue(result.get("Lunch").containsKey("Salads"));
		assertTrue(result.get("Lunch").containsKey("Grill"));
		assertTrue(result.get("Lunch").containsKey("Clean Plate"));
		assertTrue(result.get("Lunch").containsKey("Open Bars"));
		assertTrue(result.get("Lunch").containsKey("Sandwiches"));

		assertTrue(result.get("Dinner").containsKey("Soups"));
		assertTrue(result.get("Dinner").containsKey("Salads"));
		assertTrue(result.get("Dinner").containsKey("Grill"));
		assertTrue(result.get("Dinner").containsKey("Clean Plate"));
		assertTrue(result.get("Dinner").containsKey("Bakery"));
		assertTrue(result.get("Dinner").containsKey("Open Bars"));
	}
	
	
	@Test
	void testScrapeBreakfastMenuItems() {
//		assertTrue(result.get("Breakfast").get("Breakfast").contains(new MenuItem("Biscuit and Gravy")));
//		assertTrue(result.get("Breakfast").get("Breakfast").contains(new MenuItem("Buttermilk Pancakes")));
//		assertTrue(result.get("Breakfast").get("Breakfast").contains(new MenuItem("Sausage Patties")));
//		assertTrue(result.get("Breakfast").get("Breakfast").contains(new MenuItem("Sweet Potato, Black Bean and Kale Hash")));
//		assertTrue(result.get("Breakfast").get("Breakfast").contains(new MenuItem("Triangle Hash Brown Patty")));
		
//		assertTrue(result.get("Breakfast").get("Daily").contains(new MenuItem("Cage-Free Scrambled Eggs")));
		assertTrue(result.get("Breakfast").get("Daily").contains(new MenuItem("Hard-boiled Cage Free Egg (1)")));
		assertTrue(result.get("Breakfast").get("Daily").contains(new MenuItem("Organic Oatmeal Gluten-Free")));
//		assertTrue(result.get("Breakfast").get("Daily").contains(new MenuItem("Steamed Rice")));
//		
//		assertTrue(result.get("Breakfast").get("Bakery").contains(new MenuItem("Apple Strudel")));
//		assertTrue(result.get("Breakfast").get("Bakery").contains(new MenuItem("Blueberry Muffin")));
	}
	
	
	@Test
	void testObtainsDietaryInfo() {
		MenuItem menuItem = result.get("Breakfast").get("Daily").get(0);
				
		assertTrue(menuItem.isVegetarian());
		assertTrue(menuItem.containsEgg());
		assertTrue(menuItem.isGlutenFree());
	}
	
	
	void printMenu(Map<String, Map<String, List<MenuItem>>> menu) {
		for (String mealKey : menu.keySet()) {
			System.out.println(mealKey);
			
			for (String categoryKey : menu.get(mealKey).keySet()) {
				System.out.println("\t" + categoryKey);
				
				for (MenuItem menuItem : menu.get(mealKey).get(categoryKey))
					System.out.println("\t\t" + menuItem);
			}
		}
	}
	
}
