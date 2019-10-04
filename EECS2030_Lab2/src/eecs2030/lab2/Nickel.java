package eecs2030.lab2;

public class Nickel implements Comparable<Nickel> {

	private int year;

	/**
	 * The monetary value of a nickel in cents.
	 */
	public final int CENTS = 5;
	
	Nickel(int year){
		if(year < 1858) {
			throw new IllegalArgumentException();
		}
		else {
			this.year = year;
		}
	}
	
	public int issueYear() {
		return this.year;
	}

	@Override
	public int compareTo(Nickel o) {
		if(this.year > o.year) {
			return this.year - o.year;
		}
		else if(this.year < o.year) {
			return this.year - o.year;
		}
		else {
			return 0;
		}
	}
	
	@Override
	
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		
		if(this.getClass() != obj.getClass()) {
			return false;
		}
		Nickel other = (Nickel) obj;
		return other == obj;
	}
	


}
