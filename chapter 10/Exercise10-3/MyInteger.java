/*
Kevin Martinsen
CSCI 1111 - OOP 1
09/02/2021

Exercise 10-3: MyInteger implementation and methods
*/
public class MyInteger {
	int value;
	
	public MyInteger(int x) {
		value = x;
	}
	
	public int getValue() {return value;}
	
	public static boolean isEven(int x) {return (x % 2) == 0;}
	public static boolean isOdd(int x) {return (x % 2) != 0;}
	public static boolean isPrime(int x) {
		if (x % 2 == 0) return false;
		
		for (int i = 3; i < Math.pow((double)x, 0.5); i++) {
			if (i % 2 != 0) {
				// if i is odd then check if it divides x
				if (x % i == 0) return false;
			}
		}
		return true;
	}

	public static boolean isEven(MyInteger intObject) {return isEven(intObject.value);}
	public static boolean isOdd(MyInteger intObject) {return isOdd(intObject.value);}
	public static boolean isPrime(MyInteger intObject) {return isPrime(intObject.value);}
	
	public boolean isEven() {return isEven(value);}
	public boolean isOdd() {return isOdd(value);}
	public boolean isPrime() {return isPrime(value);}
	
	public boolean equals(int x) {return value == x;}
	public boolean equals(MyInteger intObject) {return value == intObject.value;}
	
	public static int parseInt(char[] chArray) {
		int outputValue = 0;
		int digits = chArray.length - 1;
		
		for (int i = 0; i <= digits; i++) {
			if (!Character.isDigit(chArray[i])) {
				System.out.println("Non-digit found in string.");
				continue;
			}
			outputValue += Math.pow(10, (digits - i)) * (chArray[i] - 48);
		}
		
		return outputValue;
	}
	
	public static int parseInt(String intString) {
		int outputValue = 0;
		int digits = intString.length() - 1;
		
		for (int i = 0; i <= digits; i++) {
			if (!Character.isDigit(intString.charAt(i))) {
				System.out.println("Non-digit found in string.");
				continue;
			}
			outputValue += Math.pow(10, (digits - i)) * (intString.charAt(i) - 48);
		}
		
		return outputValue;	
	}
}