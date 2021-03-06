/*
Kevin Martinsen
CSCI 1111 - OOP 1
09/20/2021

Exercise 13_07: Triangle object for abstract GeometricObject and interface Colorable
*/

class Triangle extends GeometricObject implements Colorable {
	private double side1 = 1.0;
	private double side2 = 1.0;
	private double side3 = 1.0;
	
	Triangle(){}
	
	Triangle(double s1, double s2, double s3) {
		side1 = s1;
		side2 = s2;
		side3 = s3;
	}
	
	Triangle(String color, boolean filled, double s1, double s2, double s3) {
		super(color, filled);
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
	
	@Override
	public double getArea(){
		double s = (side1 + side2 + side3) / 2;
		return Math.pow(s * (s - side1) * (s - side2) * (s - side3),0.5);
	}
	
	@Override
	public double getPerimeter(){
		return side1 + side2 + side3;
	}
	
	//Maybe call the GeometricObject to string and add the sides info?
	@Override
	public String toString(){
		return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
	}
	
	public static boolean isValid(double s1, double s2, double s3) {
		return s1 + s2 > s3 && s1 + s3 > s2 && s2 + s3 > s1;
	}
	
	@Override
	public void howToColor() {
		System.out.print("Color all three sides.");
	}
}