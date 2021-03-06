package diningHallScrapper;

public abstract class AbstractSpecification implements Specification {
	
	public Specification and(Specification other) {
		return new AndSpecification(this, other);
	}
	
	public Specification or(Specification other) {
		return new OrSpecification(this, other);
	}
	
	public Specification not() {
		return new NotSpecification(this);
	}
	
}
