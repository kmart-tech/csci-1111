/*
Kevin Martinsen
CSCI 1111 - OOP 1
09/20/2021

Exercise 13_11: Test the Octagon class
*/

class TestOctagon {
	public static void main(String[] args) {
		Octagon octa1 = new Octagon(5.3, "Blue", true);
		Octagon octa2 = (Octagon)octa1.clone();
		
		System.out.println("Comparing Octagon objects octa1 and octa2: " + octa1.compareTo(octa2));
	}
}