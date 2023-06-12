package Pojo;

public enum Courses {
	DAC(90),DBDA(85),DITISS(80),AI(85);
	
	private int minscore;
	
	private Courses(int marks) {
		this.minscore=marks;
	}

	public int getMinscore() {
		return minscore;
	}

	public void setMinscore(int minscore) {
		this.minscore = minscore;
	}
	

}
