package LabTest1;

public class Temperature {
	public static final String CELCIUS = "C";
	public static final String FAHRENHEIT = "F";
	public String units = "";
	public double temp;
	
	
	public Temperature() {
		this.temp = 0;
		this.units = "C";
	}
	
	public Temperature(Temperature other) {
		this.temp = other.temp;
		this.units = other.units;
	}
	
	public Temperature(double temp,String units) {
		if(!(units.equals(Temperature.CELCIUS) || units.equals(Temperature.FAHRENHEIT))){
			throw new IllegalArgumentException();
		}
		this.temp = temp;
		this.units = units;
	}
	public double getTemperature() {
		return this.temp;
	}
	public final void setTemperature(double temp) {
		this.temp = temp;
	}
	
	public String getUnits() {
		return this.units;
	}
	public final void setUnits(String units) {
		if(!(units.equals(Temperature.CELCIUS) || units.equals(Temperature.FAHRENHEIT))) {
			throw new IllegalArgumentException();
		}
		if((this.units == Temperature.CELCIUS) && (units == Temperature.FAHRENHEIT)) {
			this.temp = toFahrenheit(this.temp);
			this.units = units;
			
		}
		else if( this.units == Temperature.FAHRENHEIT && units == Temperature.CELCIUS) {
			this.temp = toCelcius(this.temp);
			this.units = units;
		}
		
	}
	
	public static double toCelcius(double degF) {
		return (degF-32)*(5.0/9);
	}
	public static double toFahrenheit(double degC) {
		return (degC)*(9.0/5) +32;
	}
	@Override
	public String toString() {
		if(this.units == "F") {
			return this.temp+this.units;
		}
		return this.temp+ this.units;
	}
	@Override
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
		Temperature other = (Temperature) obj;
		if(this.getUnits() == other.getUnits()) {
			if(this.getTemperature() == other.getTemperature()) {
				return true;
			}
		}
		if(this.getUnits() == Temperature.CELCIUS) {
			double y = other.toCelcius(other.temp);
			if(this.temp == y) {
				return true;
			}
		}
		if(this.getUnits() == Temperature.FAHRENHEIT) {
			double y = toFahrenheit(other.temp);
			if(this.temp == y) {
				return true;
			}
		}

		
		return false;
	}
}
