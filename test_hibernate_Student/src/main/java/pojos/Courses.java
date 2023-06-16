package pojos;

public enum Courses {
	DAC(90000),DBDA(100000),DITISS(80000);
	
	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	private double fees;
	
	private Courses(double fees) {
		this.fees=fees;
	}
}
