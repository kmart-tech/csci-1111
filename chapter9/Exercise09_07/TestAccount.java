/*
Kevin Martinsen
CSCI 1111 - OOP 1
09/01/2021

Exercise 9-7: Account class
*/
class TestAccount {
	public static void main(String[] args) {
		Account.setAnnualInterestRate(4.5);
		Account myAccount = new Account(1122, 20000);
		java.util.Date dateCreated = myAccount.getDateCreated();
		System.out.println("Current balance: $" + myAccount.getBalance());
		
		myAccount.withdraw(2500);
		System.out.println("After withdrawing: $" + myAccount.getBalance());
		
		myAccount.deposit(3000);
		System.out.println("After depositing: $" + myAccount.getBalance());
		
		System.out.println("Account details: ");
		System.out.printf("Balance: $%.2f\n", myAccount.getBalance());
		System.out.printf("Montly Interest: $%.2f\n", myAccount.getMonthlyInterest());
		System.out.println("Account created on: " + dateCreated.toString());
	}
}