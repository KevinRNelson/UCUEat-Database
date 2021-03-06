package diningHallScrapper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

class TestDietaryNeedsSpecification {

	private MenuScrapper menuScrapper = MenuScrapperFactory.createMenuScrapper("UcscDiningHall");
	private Menu menu = menuScrapper.scrapeMenu(
		"https://nutrition.sa.ucsc.edu/shortmenu.aspx?sName=UC+Santa+Cruz+Dining&locationNum=25&locationName=Porter+Kresge+Dining+Hall&naFlag=1"
	);
//	private Map<String, Map<String, List<MenuItem>>> result = ;
	
	@Test
	void testContainsEgg() {
		Specification containsEgg = new ContainsEggSpecification();
		List<MenuItem> menuItemsThatContainEgg = menu.selectSatisfying(containsEgg);
		
		assertTrue(menuItemsThatContainEgg.contains(new MenuItem("Cage-Free Scrambled Eggs")));
		assertTrue(menuItemsThatContainEgg.contains(new MenuItem("Hard-boiled Cage Free Egg (1)")));
		assertTrue(menuItemsThatContainEgg.contains(new MenuItem("Blueberry Muffin")));
		assertTrue(menuItemsThatContainEgg.contains(new MenuItem("Blondie Brownies")));
	}
	
	@Test
	void testContainsEggOrPork() {
		Specification containsEgg = new ContainsEggSpecification();
		Specification containsPork = new ContainsPorkSpecification();
		List<MenuItem> menuItemsThatContainEgg = menu.selectSatisfying(containsEgg.or(containsPork));
		
		assertTrue(menuItemsThatContainEgg.contains(new MenuItem("Cage-Free Scrambled Eggs")));
		assertTrue(menuItemsThatContainEgg.contains(new MenuItem("Bacon")));
		assertTrue(menuItemsThatContainEgg.contains(new MenuItem("Sausage Patties")));
	}
	
	@Test
	void testContainsEggAndMilk() {
		Specification containsEgg = new ContainsEggSpecification();
		Specification containsMilk = new ContainsMilkSpecification();
		List<MenuItem> menuItemsThatContainEgg = menu.selectSatisfying(containsEgg.and(containsMilk));
		
		assertTrue(menuItemsThatContainEgg.contains(new MenuItem("Halal Crispy Chicken Patty Sandwich")));
		assertTrue(menuItemsThatContainEgg.contains(new MenuItem("Buttermilk Pancakes")));
	}
	
	void testDoesNotContainEgg() {
		Specification containsEgg = new ContainsEggSpecification();
		List<MenuItem> menuItemsThatContainEgg = menu.selectSatisfying(containsEgg.not());
		
		assertFalse(menuItemsThatContainEgg.contains(new MenuItem("Cage-Free Scrambled Eggs")));
		assertFalse(menuItemsThatContainEgg.contains(new MenuItem("Hard-boiled Cage Free Egg (1)")));
		assertFalse(menuItemsThatContainEgg.contains(new MenuItem("Blueberry Muffin")));
		assertFalse(menuItemsThatContainEgg.contains(new MenuItem("Blondie Brownies")));
	}

}
