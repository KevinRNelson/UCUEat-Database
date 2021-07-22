package diningHallScrapper;

public class ContainsMilkSpecification extends DietaryNeedsSpecification {
	
	@Override
	public boolean isSatisfiedBy(Object candidate) {
		if (!super.isSatisfiedBy(candidate))
			return false;
		
		MenuItem menuItem = (MenuItem) candidate;
		
		return menuItem.containsMilk();
	}
	
}
