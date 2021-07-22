package diningHallScrapper;

import java.util.List;

public class MenuItem {
	
	String name;
	DietaryInfo dietaryInfo;
	
	MenuItem(String name) {
		this.name = name;
	}
	
	MenuItem(String name, DietaryInfo dietaryNeeds) {
		this.name = name;
		this.dietaryInfo = dietaryNeeds;
	}
	
	@Override 
	public String toString() {
		return this.name;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		
		if (!(o instanceof MenuItem))
			return false;
		
		MenuItem menuItem = (MenuItem) o;
		return this.name.equals(menuItem.name);
	}
}
