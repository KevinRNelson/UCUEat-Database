package diningHallScrapper;

public abstract class DietaryNeedsSpecification extends AbstractSpecification {

	@Override
	public boolean isSatisfiedBy(Object candidate) {
		if (candidate instanceof MenuItem) return true;
		
		return false;
	}
	
}
