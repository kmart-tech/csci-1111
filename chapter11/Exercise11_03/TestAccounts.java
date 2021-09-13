class TestAccounts {
	public static void main(String[] args) {
		System.out.println("Test Checking and Savings Accounts");
		
		Account myAccount = new Account(11, 100);
		CheckingAccount myChecking = new CheckingAccount(23, 300, 400);
		SavingsAccount mySavings = new SavingsAccount(62, 230);
		
		//test overdraft in both checking and savings
		
		myChecking.withdraw(800);
		mySavings.withdraw(400);
		
		System.out.println();
		System.out.println(myAccount);
		System.out.println();
		System.out.println(myChecking);
		System.out.println();
		System.out.println(mySavings);
	}
}