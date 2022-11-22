package homework2;

import java.util.ArrayList;
import java.util.Scanner;

import homework2.persons.Client;

public class Bank {

	private String name;
	private Adress adress;
	private ArrayList<Account> accounts;
	private Scanner scanner;

	public Bank(String name, Adress adress) {
		this.name = name;
		this.adress = adress;
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
			accounts.add(new Account(new Client(firstName, lastName), phoneNumber));
			System.out.println("You have created account successfully!" + "\n" + "Your account ID is: "
					+ accounts.get(accounts.size() - 1).getID());

		}
	}

	public Account readAccount() {
		Account selectedAccount = null;

		while (selectedAccount == null) {
			System.out.println("Please enter your ID:");

			// ver try catch porque se me rompe si pongo letra

			int accountID = scanner.nextInt();
			System.out.println("Please enter your phone number:");
			String phoneNumber = scanner.next();
			selectedAccount = lookupAccount(accountID, phoneNumber);
		}
		return selectedAccount;

	}

	public void manageAccount() {
		Account selectedAccount = readAccount();
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
						System.out.println("Same Account, not valid");
					} else {
						System.out.println("Enter the amount of money you would like to transfer:");
						long moneyToTransfer = (long) scanner.nextDouble();
						selectedAccount.transferMoney(selectedAccount, accountToTransfer, moneyToTransfer);
					}

				}
				break;
			case 5:
				if (isApproved(selectedAccount.getClient().getCreditSummary())) {
					selectedAccount.getClient().getCreditSummary().setHasCredit(true);
					selectedAccount.depositMoney(
							(long) selectedAccount.getClient().getCreditSummary().getSalary() * 5);
				}
				break;
			case 6:
				exitRequested = true;
				break;
			default:
				System.out.println("Wrong input");
				break;
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


	public boolean isApproved(CreditSummary creditSummary) {
		boolean isApproved = false;
		if (!creditSummary.isDefaulter() && !creditSummary.hasCredit() && creditSummary.getSalary() > 0
				&& creditSummary.getPatrimony() >= creditSummary.getSalary() * 5) {
			isApproved = true;
			System.out.println("Credit Approved, it will be equal to 5 salaries");
		} else {
			System.out.println("Credit Refused");
		}

		return isApproved;

	}

	public String getName() {
		return name;
	}

	public Adress getAdress() {
		return adress;
	}
}
