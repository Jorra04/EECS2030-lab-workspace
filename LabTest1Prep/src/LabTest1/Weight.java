package LabTest1;

public class Weight {
	public static final String KG = "kg";
	public static final String LB = "lb";
	public static final double KG_PER_LB = 0.45359237;
	public double weight;
	public String units;

	public Weight() {
		this.weight =0;
		this.units = Weight.KG;
	}

	public Weight(Weight other) {
		this.weight = other.weight;
		this.units = other.units;
	}

	public Weight(double weight, String units) {
		if((weight < 0) || !(units.equals(Weight.KG)||units.equals(Weight.LB))) {
			throw new IllegalArgumentException();
		}
		else {
			this.weight = weight;
			this.units = units;
		}
	}

	public double get() {
		return this.weight;
	}

	public final void set(double weight) {
		if(weight < 0 ) {
			throw new IllegalArgumentException();
		}
		else {
			this.weight = weight;
		}
	}

	public String getUnits() {
		return this.units;

	}

	public final void setUnits(String units) {
		if(!(units == Weight.KG || units == Weight.LB)) {
			throw new IllegalArgumentException();
		}
		if(this.units == Weight.KG && units == Weight.LB) {
			this.weight = toPounds(this.weight);
			this.units = units;
		}
		else if(this.units == Weight.LB && units == Weight.KG) {
			this.weight = toKilograms(this.weight);
			this.units = units;
		}
	}
	public static double toPounds(double kg) {
		return kg/Weight.KG_PER_LB;
	}
	public static double toKilograms(double lb) {
		return lb*Weight.KG_PER_LB;
	}


	public String toString() {
		return this.weight + " " + this.units; 

	}

	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(this.getClass()!=obj.getClass()) {
			return false;
		}
		Weight other = (Weight) obj;
		if(this.getUnits() == other.getUnits()) {
			if(this.get() != other.get()) {
				return false;
			}
			else {
				return true;
			}
		}
		if(this.getUnits() == Weight.KG) {
			double y = toKilograms(other.weight);
			if(this.get() != y) {
				return false;
			}
			else {
				return true;
			}
		}
		if(this.getUnits() == Weight.LB) {
			double y = toPounds(other.weight);
			if(this.get() != y) {
				return false;
			}
			else {
				return true;
			}

		}

		return false;
	}
}
