package diningHallScrapper;

public class ContainsPorkSpecification extends DietaryNeedsSpecification {
	
	@Override
	public boolean isSatisfiedBy(Object candidate) {
		if (!super.isSatisfiedBy(candidate))
			return false;
		
		MenuItem menuItem = (MenuItem) candidate;
		
		return menuItem.containsPork();
	}


}
