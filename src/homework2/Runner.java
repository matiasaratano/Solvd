package homework2;

import java.util.Scanner;

import homework2.card.Card;
import homework2.card.CardType;
import homework2.card.Scheme;
import homework2.persons.Client;

public class Runner {

	private static Bank bank;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Runner.createObjects();
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

		scanner.close();
	}

	private static void createObjects() {
		Adress adress1 = new Adress("EEUU", "CA", "Venice", "ABC", "123");
		Adress adress2 = new Adress("EEUU", "CA", "Santa Monica", "BCD", "234");
		Adress adress3 = new Adress("EEUU", "CA", "Venice", "CDE", "345");
		bank = new Bank("bank1", adress1);
		Card card1 = new Card("123456789", "202608", "202108", "Jhon Florence", "BBVA", Scheme.MASTER_CARD,
				CardType.DEBIT);
		CreditSummary credSummary1 = new CreditSummary(4000, 50000, false, false);
		CreditSummary credSummary2 = new CreditSummary(3000, 150000, false, true);
		CreditSummary credSummary3 = new CreditSummary(2000, 2000, false, false);
		Client client1 = new Client("Jhon", "Florence", "1231231231", adress2, credSummary1);
		Client client2 = new Client("Richard", "Rodriguez", "1234567899", adress3, credSummary2);
		Client client3 = new Client("Mark", "Zucke", "1234567899", adress3, credSummary3);
		client1.setCard(card1);
		bank.registerAccount(client1);
		bank.registerAccount(client2);
		bank.registerAccount(client3);
	}

}
