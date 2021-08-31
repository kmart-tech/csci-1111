/*
Kevin Martinsen
CSCI 1111 - OOP 1
08/31/2021

Exercise 6-19: triangle methods (non-object approach)
*/
import java.util.Scanner;

public class Exercise06_19 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the length of 3 sides of a triangle: ");
		double side1 = input.nextDouble();
		double side2 = input.nextDouble();
		double side3 = input.nextDouble();
		
		if (isValid(side1, side2, side3)) {
			System.out.printf("The triangle's area is: %.3f\n", area(side1, side2, side3));
		}
		else System.out.println("This is not a valid triangle.");

	}	

	public static boolean isValid(double side1, double side2, double side3) {
		return side1 + side2 > side3 && side2 + side3 > side1 && side1 + side3 > side2;
	}
	
	public static double area(double side1, double side2, double side3) {
		double s = (side1 + side2 + side3) / 2;
		return Math.pow(s * (s - side1) * (s - side2) * (s - side3), 0.5);
	}
}