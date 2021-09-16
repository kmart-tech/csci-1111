/*
Kevin Martinsen
CSCI 1111 - OOP 1
09/13/2021

Exercise 11-01: Triangle Object Test
*/
import java.util.Scanner;

public class TestTriangle {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter three sides of a triangle separted by a space: ");
		double side1 = input.nextDouble();
		double side2 = input.nextDouble();
		double side3 = input.nextDouble();
		
		input.nextLine();
		System.out.print("Enter a color for the triangle: ");
		String color = input.nextLine();
		
		System.out.print("Enter 1 for a filled triangle or 0 for not filled: ");
		int filledInput = input.nextInt();
		boolean filled;
		
		if (filledInput == 0) {filled = false;}
		else if (filledInput == 1) {filled = true;}
		else {
			System.out.println("Invalid input. Please enter 0 or 1.");
			return;
		}
		
		Triangle userTriangle = new Triangle(color, filled, side1, side2, side3);
		//userTriangle.setColor(color);
		//userTriangle.setFilled(filled);
		
		System.out.println("The triangle created has the following information:");
		System.out.printf("Area: %.2f\n", userTriangle.getArea());
		System.out.printf("Perimeter: %.2f\n", userTriangle.getPerimeter());
		System.out.println("Color: " + userTriangle.getColor());
		System.out.println("Filled: " + userTriangle.isFilled());
		System.out.println("Date Created: " + userTriangle.getDateCreated());
	}
}