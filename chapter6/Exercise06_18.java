/*
Kevin Martinsen
CSCI 1111 - OOP 1
08/31/2021

Exercise 6-18: valid password check
*/
import java.util.Scanner;

public class Exercise06_18{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Password must be 8 characters long, only use letters and digits, and contain at least 2 digits.");
		System.out.print("Enter a password: ");
		String password = input.nextLine();
		
		if (isValid(password)) {
			System.out.println("Valid password entered.");
		}
		else {
			System.out.println("Invalid password entered.");
		}
	
	}	

	public static boolean isValid(String s) {
		if (s.length() < 8) return false;
		
		int digitCount = 0;
		
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				digitCount++;
			}
			else if (Character.isLetter(ch)); // do nothing
			else return false; // if its not a digit or letter its not valid
		}
		
		if (digitCount < 2) return false;
		else return true;		
	}
}