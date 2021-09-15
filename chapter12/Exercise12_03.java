/*
Kevin Martinsen
CSCI 1111 - OOP 1
09/15/2021

Exercise 12_03 - Out of bounds exception example for arrays
*/
import java.util.Scanner;

public class Exercise12_03 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int[] randomArray = new int[100];
		
		for (int i = 0; i < randomArray.length; i++) {
			randomArray[i] = (int)(Math.random() * 1000);
		}
		
		System.out.print("Enter an index to see its contents: ");
		int index = input.nextInt();
		
		try {
			System.out.println(randomArray[index]);
		}
		catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Out of Bounds.");
		}
	}
}