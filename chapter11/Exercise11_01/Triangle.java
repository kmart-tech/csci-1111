/*
Kevin Martinsen
CSCI 1111 - OOP 1
09/13/2021

Exercise 11-01: Triangle Object
*/

class Triangle extends GeometricObject {
	private double side1 = 1.0;
	private double side2 = 1.0;
	private double side3 = 1.0;
	
	Triangle(){}
	
	Triangle(double s1, double s2, double s3) {
		side1 = s1;
		side2 = s2;
		side3 = s3;
	}
	
	public void setSide1(double length) {side1 = length;}
	public void setSide2(double length) {side2 = length;}
	public void setSide3(double length) {side3 = length;}
	
	public double getSide1() {return side1;}
	public double getSide2() {return side2;}
	public double getSide3() {return side3;}
	
	public double getArea(){
		double s = (side1 + side2 + side3) / 2;
		return Math.pow(s * (s - side1) * (s - side2) * (s - side3),0.5);
	}
	
	public double getPerimeter(){
		return side1 + side2 + side3;
	}
	
	public String toString(){
		return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
	}
}