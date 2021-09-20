/*
Kevin Martinsen
CSCI 1111 - OOP 1
09/20/2021

Exercise 13_11: Regular Octagon class
*/

class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable {
	private double side = 1.0;
	
	Octagon(){}
	
	Octagon(double side) {
		this.side = side;
	}
	
	Octagon(double side, String color, boolean filled) {
		super(color, filled);
		this.side = side;
	}
	
	@Override
	public String toString(){
		return "Octagon: side " + side + " and area " + this.getArea();
	}
	
	@Override
	public double getArea(){
		return 2 * (1 + Math.pow(2, 0.5)) * Math.pow(side, 2);
	}
	
	@Override
	public double getPerimeter(){
		return 8 * side;
	}
	
	@Override
	public int compareTo(Octagon obj) {
		if (this.side > obj.side) return 1;
		else if (this.side < obj.side) return -1;
		else return 0;
	}
	
	@Override
	public Object clone() {
		try {
			return super.clone();
		}
		catch (CloneNotSupportedException ex) {
			return null;
		}
	}
}