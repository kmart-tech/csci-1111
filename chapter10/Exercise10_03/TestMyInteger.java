/*
Kevin Martinsen
CSCI 1111 - OOP 1
09/02/2021

Exercise 10-3: MyInteger implementation and methods
*/
class TestMyInteger {
	public static void main(String[] args) {
		System.out.println("Testing MyInteger Class");
		MyInteger x = new MyInteger(11);
		
		System.out.println("The value for object x is: " + x.getValue());
		System.out.println("Is x even? " + x.isEven());
		System.out.println("Is x odd? " + x.isOdd());
		System.out.println("Is x prime? " + x.isPrime());
		System.out.println();
		
		System.out.println("Is 385 even? " + MyInteger.isEven(385));
		System.out.println("Is 298691 odd? " + MyInteger.isOdd(298691));
		System.out.println("Is 21211 prime? " + MyInteger.isPrime(21211));
		
		MyInteger y = new MyInteger(991);
		
		System.out.println("We can also do MyInteger.isEven(MyInteger): " + MyInteger.isEven(y));
		
		System.out.println("Is our new object y (991) equal to x? " + y.equals(x));
		System.out.println("Is y equal to 991? " + y.equals(991));
		
		System.out.print("Parse \"2921\" to an integer: ");
		int z = MyInteger.parseInt("2921");
		System.out.println(z);
		
		System.out.print("Parse character array \'821\' to an integer: ");
		char[] chArray = {'8', '2', '1'};
		int k = MyInteger.parseInt(chArray);
		System.out.println(k);
	}
}