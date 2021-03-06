package diningHallScrapper;

import java.util.List;
import java.util.ArrayList;

public class DietaryInfo {

	private List<String> dietaryInfo;
//	boolean[] dietaryNeeds;
	
	// =============================================================================================
    //                                          Constructor
    // =============================================================================================
	
	DietaryInfo() {
		dietaryInfo = new ArrayList<>();
//		dietaryNeeds = new boolean[12];
	}
	
	
	void addDietaryNeed(String dietaryNeed) {
		dietaryInfo.add(dietaryNeed);
	}
	
	// =============================================================================================
    //                                          Getters
    // =============================================================================================
	
	
	public List<String> getDietaryInfo() {
		return dietaryInfo;
	}
	
	// =============================================================================================
    //                                        Boolean Methods
    // =============================================================================================
	
	boolean containsPork() {
		return dietaryInfo.contains("pork");
	}
	
	boolean containsBeef() {
		return dietaryInfo.contains("beef");
	}
	
	boolean containsFish() {
		return dietaryInfo.contains("fish");
	}
	
	boolean containsShellfish() {
		return dietaryInfo.contains("shellfish");
	}
	
	boolean containsNut() {
		return dietaryInfo.contains("treenut");
	}
	
	boolean containsMilk() {
		return dietaryInfo.contains("milk");
	}
	
	boolean containsEgg() {
		return dietaryInfo.contains("eggs");
	}
	
	boolean containsSoy() {
		return dietaryInfo.contains("soy");
	}
	
	boolean isGlutenFree() {
		return dietaryInfo.contains("gluten");
	}
	
	boolean isVegan() {
		return dietaryInfo.contains("vegan");
	}
	
	boolean isVegetarian() {
		return dietaryInfo.contains("veggie");
	}
	
	boolean isHalal() {
		return dietaryInfo.contains("halal");
	}

}
