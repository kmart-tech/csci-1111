/*
Kevin Martinsen
CSCI 1111 - OOP 1
09/13/2021

Exercise 11_03: Checking and Savings accounts
*/
class SavingsAccount extends Account{
	SavingsAccount(int newId, int startBalance) {
		super(newId, startBalance);
	}
	
	@Override
	void withdraw(double amount) {
		if (amount > balance) {
			System.out.println("Not enough funds to withdraw that amount.")
		}
		else {
			super.withdraw(amount);
		}
	}
	
	@Override
	void toString() {
		return "Savings " + super.toString();
	}
}
