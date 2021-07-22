package diningHallScrapper;

public class OrSpecification extends AbstractSpecification {

	Specification one;
	Specification other;
	
	public OrSpecification(Specification one, Specification other) {
		this.one = one;
		this.other = other;
	}
	
	public boolean isSatisfiedBy(Object candidate) {
		return one.isSatisfiedBy(candidate) ||
				other.isSatisfiedBy(candidate);
	}

}
