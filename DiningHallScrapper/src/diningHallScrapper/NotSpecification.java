package diningHallScrapper;

public class NotSpecification extends AbstractSpecification {

	Specification wrapped;
	
	public NotSpecification(Specification wrapped) {
		this.wrapped = wrapped;
	}
	
	public boolean isSatisfiedBy(Object candidate) {
		return !wrapped.isSatisfiedBy(candidate);
	}
	
}
