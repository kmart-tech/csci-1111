/*
Kevin Martinsen
CSCI 1111 - OOP 1
09/15/2021

Exercise 12_15 - Reading and writing from file
*/
import java.io.*;
import java.util.*;

public class Exercise12_15 {
	public static void main(String[] args) throws Exception {
		// how many integers to print to file
		int numberOfIntegers = 100;
		
		File file = new File("Exercise12_15.txt");
		if (file.exists()) {
			System.out.println("File already exists.");
			System.exit(0);
		}
		
		try( 
			PrintWriter output = new PrintWriter(file); 
		){
			//write random positive integers to the file separted by a space
			for (int i = 0; i < numberOfIntegers; i++) {
				output.print((int)(Math.random() * 1000000) + " ");
			}
		}
		

		int[] myArray = new int[numberOfIntegers];
		int count = 0;
		
		try (
			Scanner input = new Scanner(file);
		) {
			while (input.hasNext()) {
				myArray[count] = input.nextInt();
				count++;
			}
		}
		
		Arrays.sort(myArray);
		
		for (int e: myArray) {
			System.out.println(e);
		}
	}
}