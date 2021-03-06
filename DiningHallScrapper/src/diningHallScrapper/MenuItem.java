package diningHallScrapper;

public class MenuItem {
	
	private final String name;
	private final DietaryInfo dietaryInfo;
	
	// =============================================================================================
    //                                          Constructor
    // =============================================================================================
	
	MenuItem(String name) {
		this.name = name;
		this.dietaryInfo = new DietaryInfo();
	}
	
	MenuItem(String name, DietaryInfo dietaryInfo) {
		this.name = name;
		this.dietaryInfo = dietaryInfo;
	}
	
	// =============================================================================================
    //                                          Getters
    // =============================================================================================
	
	public String getName() {
		return name;
	}
	
	public DietaryInfo getDietaryInfo() {
		return dietaryInfo;
	}
	
	// =============================================================================================
    //                                     Dietary  Info  Methods
    // =============================================================================================
	
	boolean containsPork() {
		return dietaryInfo.containsPork();
	}
	
	boolean containsBeef() {
		return dietaryInfo.containsBeef();
	}
	
	boolean containsFish() {
		return dietaryInfo.containsFish();
	}
	
	boolean containsShellfish() {
		return dietaryInfo.containsShellfish();
	}
	
	boolean containsNut() {
		return dietaryInfo.containsNut();
	}
	
	boolean containsMilk() {
		return dietaryInfo.containsMilk();
	}
	
	boolean containsEgg() {
		return dietaryInfo.containsEgg();
	}
	
	boolean containsSoy() {
		return dietaryInfo.containsSoy();
	}
	
	boolean isGlutenFree() {
		return dietaryInfo.isGlutenFree();
	}
	
	boolean isVegan() {
		return dietaryInfo.isVegan();
	}
	
	boolean isVegetarian() {
		return dietaryInfo.isVegetarian();
	}
	
	boolean isHalal() {
		return dietaryInfo.isHalal();
	}
	
	// =============================================================================================
    //                                  Overridden  Object  Methods
    // =============================================================================================
	
	
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
//		if (!this.name.equals(menuItem.name) || !(this.dietaryInfo.getDietaryInfo().size() == (menuItem.dietaryInfo.getDietaryInfo().size())))
//			return false;
//		
//		for (String info : dietaryInfo.getDietaryInfo())
//			if (!menuItem.dietaryInfo.getDietaryInfo().contains(info))
//				return false;
		
		return this.name.equals(menuItem.name);
	}
	
	@Override
	public int hashCode() {
		int result = name.hashCode();
		
		for (String info : dietaryInfo.getDietaryInfo())
			result += 31 * info.hashCode();
		
		return result;
	}
	
}
