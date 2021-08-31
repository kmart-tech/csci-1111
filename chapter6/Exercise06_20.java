/*
Kevin Martinsen
CSCI 1111 - OOP 1
08/31/2021

Exercise 6-20: string length and letter counter
*/
import java.util.Scanner;

public class Exercise06_20{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String userString = input.nextLine();
		
		System.out.printf("'%s' is %d characters long.\n", userString, userString.length());
		System.out.printf("There are %d letters in '%s'.\n", countLetters(userString), userString);
	}	

	public static int countLetters(String s) {
		int count = 0;
		
		for (int i = 0; i < s.length(); i ++) {
			char ch = s.charAt(i);
			if (Character.isLetter(ch)) count++;
		}
		
		return count;
	}
}