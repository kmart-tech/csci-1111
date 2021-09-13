/*
Kevin Martinsen
CSCI 1111 - OOP 1
09/13/2021

Exercise 11_03: Checking and Savings accounts
*/
class CheckingAccount extends Account {
	private double overdraftLimit = 0.0; //Positive number
	
	CheckingAccount(){};
	
	CheckingAccount(int newId, int startBalance, double overdraftLimit) {
		super(newId, startBalance);
		this.overdraftLimit = Math.abs(overdraftLimit);
	}
	
	double getOverdraft() {return overdraftLimit;}
	void setOverdraft(double overdraftLimit) {this.overdraftLimit = Math.abs(overdraftLimit);}

	@Override
	void withdraw(double amount) {
		if (amount > balance + overdraftLimit) {
			System.out.println("Overdraft limit reached. Please try a different amount.");
		}
		else {
			super.withdraw(amount);
		}
	}
	
	@Override
	public String toString() {
		return "Checking " + super.toString() + "\nOverdraft Limit: $" + overdraftLimit;
	}
}