/*
Kevin Martinsen
CSCI 1111 - OOP 1
09/03/2021
*/
class Account {
	private int id = 0;
	private double balance = 0.0;
	private static double annualIntrestRate = 0.0; // saved as a percent
	private java.util.Date dateCreated;
	
	Account(){
		dateCreated = new java.util.Date();
	}
	
	Account(int newId, int startBalance) {
		id = newId;
		balance = startBalance;
		dateCreated = new java.util.Date();
	}
	
	int getId() {return id;}
	double getBalance() {return balance;}
	double getAnnualInterestRate() {return annualIntrestRate;}
	java.util.Date getDateCreated() {return dateCreated;}
	
	void setId(int newId) {
		id = newId;
	}
	
	void setBalance(double newBalance) {
		balance = newBalance;
	}
	
	static void setAnnualInterestRate(double newRate) {
		annualIntrestRate = newRate;
	}
	
	double getMonthlyInterestRate() {
		return annualIntrestRate / 12;
	}
	
	double getMonthlyInterest() {
		return balance * (this.getMonthlyInterestRate() / 100);
	}
	
	void withdraw(double amount) {
		balance -= Math.abs(amount);
	}
	
	void deposit(double amount) {
		balance += Math.abs(amount);
	}
}