/*
Kevin Martinsen
CSCI 1111 - OOP 1
09/07/2021

Exercise 10-07: ATM
*/
import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {
		
		// intialize 10 accounts: 0 to 9
		Account[] accounts = new Account[10];
		for (int i = 0; i <=9; i++) {
			accounts[i] = new Account(i, 100);
		}
		
		while (true) {
			userPrompt(accounts);
		}
	}

	public static void userPrompt(Account[] accounts) {
		Scanner input = new Scanner(System.in);
		
		int userInput = 0;
		int id = 0;
		System.out.print("Enter an ID: ");
		id = input.nextInt();
		
		if (id < 0 || id > 9) {
			System.out.println("Invalid ID choice. Choose between 0 and 9.");
			return;
		}
		
		while (userInput != 4) {
			double amount = 0.0;
			printMenu();
			userInput = input.nextInt();
				
			switch (userInput) {
				case 1:
					System.out.printf("Balance is $%.2f\n", accounts[id].getBalance());
					break;
				case 2:
					System.out.print("Enter an amount to withdraw: $");
					amount = input.nextDouble();
					if (amount > accounts[id].getBalance()) {
						System.out.println("Amount to withdraw is more than account balance.");
						break;
					}
					else if (amount < 0) {
						System.out.println("Withdraw amount cannot be negative.");
						break;
					}
					accounts[id].withdraw(amount);
					break;
				case 3:
					System.out.print("Enter an amount to deposit: $");
					amount = input.nextDouble();
					if (amount < 0) {
						System.out.println("Deposit amount cannot be negative.");
						break;
					}
					accounts[id].deposit(amount);
					break;
				case 4:
					System.out.println("Thank you for using our ATM! :)");
					break;
				default:
					System.out.println("Invalid choice!");
					break;
			}
			System.out.println();
		}
	}
	
	public static void printMenu() {
		//print menu
		System.out.println("Main menu:");
		System.out.println("1: check balance");
		System.out.println("2: withdraw");
		System.out.println("3: deposit");
		System.out.println("4: exit");
		System.out.print("Enter a choice: ");
	}
}