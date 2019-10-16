package LabTest1;

import java.awt.Color;

public final class Gray extends Object implements Comparable<Gray> {
	public static final double MIN_DOUBLE_VALUE = 0.0;
	public static final double MAX_DOUBLE_VALUE = 1.0;
	public static final double MIN_INT_VALUE = 0;
	public static final double MAX_INT_VALUE = 255;
	
	private double grayDouble;
	private int grayInt;
	boolean isInt = false;
	
	public Gray(double g) {
		if(g < MIN_DOUBLE_VALUE || g > MAX_DOUBLE_VALUE) {
			throw new IllegalArgumentException();
		}
		else {
			this.grayDouble = g;
			this.isInt = false;
		}
	}
	
	public Gray(int g) {
		if(g < MIN_INT_VALUE || g > MAX_INT_VALUE) {
			throw new IllegalArgumentException();
		}
		else {
			this.grayInt = g;
			this.isInt = true;
			
		}
	}
	
	public Gray(Gray other) {
		this.grayDouble = other.grayDouble;
		this.grayInt = other.grayInt;
		this.isInt = other.isInt;
	}
	
	public int asInt() {
		if(this.isInt == true) {
			return this.grayInt;
		}
		else {//this is a double, convert double to int and return
			int result = toInt(this.grayDouble);
			return result;
		}
	}
	
	public double asDouble() {
		if(this.isInt == true) { //Its an int,  convert to double and return
			double result = (double)this.grayInt / 255;
			return result;
		}
		else {
			return this.grayDouble;
		}
	}
	
	public static double toDouble(int value) {
		if(value < Gray.MIN_DOUBLE_VALUE || value > Gray.MAX_DOUBLE_VALUE) {
			throw new IllegalArgumentException();
		}
		double result = (double)value / MAX_INT_VALUE;
		
		return result;
		
		
	}
	
	public static int toInt(double value) {
		if(value < Gray.MIN_INT_VALUE || value > Gray.MAX_INT_VALUE) {
			throw new IllegalArgumentException();
		}
		
		int result = (int) Math.round(Gray.MAX_DOUBLE_VALUE * value);
		
		return result;
		
	}
	
	public static Gray fromRGB(Color c) {
		double gValue = 0.299 * c.getRed() + 0.587 * c.getGreen() + 0.144 * c.getBlue();
		
		return new Gray(gValue);
	}
	
	@Override
	public String toString() {
		if(this.isInt == true) {
			return "" + this.grayInt;
		}
		else {
			return "" + this.grayDouble;
		}
	}
	
	public int compareTo(Gray other) {
		if(this.asDouble() < other.asDouble()) {
			return -1;
		}
		else if(this.asDouble() > other.asDouble()) {
			return 1;
		}
		else {
			return 0; //they are equal
		}
	}
	
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
		Gray other = (Gray)obj;
		return this.asInt() == other.asInt();
		
	}
	
	
}
