package diningHallScrapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Menu {

	Map<String, Map<String, List<MenuItem>>> menu;
	
	Menu() {
		menu = new LinkedHashMap<>();
	}
	
	
	public List<MenuItem> selectSatisfying(Specification specification) {
//		Set<MenuItem> result = new HashSet<>();
		List<MenuItem> result = new ArrayList<>();
		
		for (String meal : menu.keySet()) {
			
			Map<String, List<MenuItem>> menuItems = menu.get(meal);
			for (String category : menuItems.keySet()) {
				
				for (MenuItem menuItem : menuItems.get(category)) {
					if (specification.isSatisfiedBy(menuItem)) result.add(menuItem);
				}
			}
		}
		
		return result;
	}
}
