package homework2;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

	private String name;
	private Adress adress;
	private ArrayList<Client> clients;
	private ArrayList<Account> accounts;
	private Scanner scanner;

	public Bank(String name, Adress adress) {
		super();
		this.name = name;
		this.adress = adress;
		clients = new ArrayList<>();
		accounts = new ArrayList<>();
		scanner = new Scanner(System.in);
	}

	public Account lookupAccount(int accountID, String phoneNumber) {
		for (Account account : accounts) {
			if (account.getID() == accountID && account.getPhoneNumber().equals(phoneNumber)) {
				return account;
			}
		}
		System.out.println("One of the details is incorrect");
		return null;
	}

	// overload method -
	public Account lookupAccount(String phoneNumber) {
		for (Account account : accounts) {
			if (account.getPhoneNumber().equals(phoneNumber)) {
				return account;
			}
		}
		System.out.println("One of the details is incorrect");
		return null;
	}

	public void registerAccount(Client client, String phoneNumber) {
		accounts.add(new Account(client, phoneNumber));
	}

	public void registerAccount() {
		System.out.println("First name?");
		String firstName = scanner.next();
		System.out.println("Last name?");
		String lastName = scanner.next();
		System.out.println("Phone number?");
		String phoneNumber = scanner.next();
		if (isPhoneNumberCorrect(phoneNumber)) {
			Client client = new Client(firstName, lastName);
			accounts.add(new Account(client, phoneNumber));
			System.out.println("You have created account successfully!" + "\n" + "Your account ID is: "
					+ accounts.get(accounts.size() - 1).getID());

		}
	}

	public void manageAccount() {
		System.out.println("Please enter your ID:");
		int accountID = scanner.nextInt();
		System.out.println("Please enter your phone number:");
		String phoneNumber = scanner.next();
		if (isPhoneNumberCorrect(phoneNumber)) {
			Account selectedAccount = lookupAccount(accountID, phoneNumber);
			boolean exitRequested = false;
			while (!exitRequested) {
				Menu.existAccountMenu();
				int choice = Integer.parseInt(scanner.next());
				switch (choice) {
				case 1:
					System.out.println(selectedAccount.toString());
					break;
				case 2:
					System.out.println("Please enter deposit amount:");
					long depositAmount = (long) scanner.nextDouble();
					selectedAccount.depositMoney(depositAmount);
					break;
				case 3:
					System.out.println("Please enter withdrawal amount:");
					long withdrawalAmount = (long) scanner.nextDouble();
					selectedAccount.withdrawal(withdrawalAmount);
					break;
				case 4:
					System.out.println("Please enter the phone number of the account you want to transfer to: ");
					String accountPhoneNumber = scanner.next();
					if (isPhoneNumberCorrect(accountPhoneNumber)) {
						Account accountToTransfer = lookupAccount(accountPhoneNumber);
						if (selectedAccount.getID() == accountToTransfer.getID()) {
							System.out.println("Same Account");
						} else {
							System.out.println("Enter the amount of money you would like to transfer:");
							long moneyToTransfer = (long) scanner.nextDouble();
							selectedAccount.transferMoney(selectedAccount, accountToTransfer, moneyToTransfer);
							break;
						}
					}
				case 5:
					exitRequested = true;
					break;
				default:
					System.out.println("Wrong input");
					break;
				}
			}
		}
	}

	public static boolean isPhoneNumberCorrect(String phoneNumber) {
		if (phoneNumber.length() != 10) {
			System.out.println("Phone number must be 10 digits.");
			return false;

		} else {
			return true;
		}
	}
}
