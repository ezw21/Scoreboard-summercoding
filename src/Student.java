
public class Student {
	// Init student's variable
	
	String name;
	String review;
	int exp;
	int level;


	/**
	 * 
	 * @param name					Store student name 
	 * @param review				Any possible review for parents
	 * @param exp					Current exp value on this level
	 * @param level					Student current level
	 */
	public Student(String name,String review, int exp, int level) {
		super();
		this.name = name;
		this.review = review;
		this.exp = exp;;
		this.level = level;
		
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
