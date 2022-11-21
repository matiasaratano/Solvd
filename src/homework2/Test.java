package homework2;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Adress adress1 = new Adress("EEUU", "CA", "Venice", "ABC", "123");
		Adress adress2 = new Adress("EEUU", "CA", "Santa Monica", "BCD", "234");
		Adress adress3 = new Adress("EEUU", "CA", "Venice", "CDE", "345");

		Bank bank = new Bank("Bank1", adress1);

		Card card1 = new Card("123456789", "202608", "202108", "Jhon Florence", "BBVA", Scheme.MASTER_CARD,
				CardType.DEBIT);

		CreditSummary credSummary1 = new CreditSummary(4000, 50000, false, false);
		CreditSummary credSummary2 = new CreditSummary(3000, 150000, false, true);

		Client client1 = new Client("Jhon", "Florence", adress2, credSummary1, "1231231231");
		Client client2 = new Client("Richard", "Rodriguez", adress3, credSummary2, "1234567899");

		client1.setCard(card1);
		bank.registerAccount(client1, client1.getPhoneNumber());
		bank.registerAccount(client2, client2.getPhoneNumber());

		boolean exitRequested = false;
		while (!exitRequested) {
			Menu.printMenu();
			int choice = Integer.parseInt(scanner.next());
			switch (choice) {
			case 1:
				bank.registerAccount();
				break;
			case 2:
				bank.manageAccount();
				break;
			case 3:
				exitRequested = true;
				break;
			default:
				System.out.println("Wrong input");
				break;
			}
		}

	}

}
