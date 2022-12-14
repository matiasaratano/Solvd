package homework2;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import homework2.card.Card;
import homework2.card.CardType;
import homework2.card.Scheme;
import homework2.exceptions.CustomInputMismatchException;
import homework2.exceptions.CustomNumberFormatException;
import homework2.exceptions.IncorrectDetailException;
import homework2.exceptions.IncorrectNumberException;
import homework2.exceptions.InsufficientFundsException;
import homework2.exceptions.InvalidAccountException;
import homework2.exceptions.InvalidAmountException;
import homework2.persons.Client;


public class Runner {


	private static final Logger LOGGER = LogManager.getLogger(Runner.class.getName());

	public static void main(String[] args) {
		LOGGER.info("Test");
		LOGGER.error("Error");
		LOGGER.debug("Debug");
		LOGGER.warn("Warn");

		Scanner scanner = new Scanner(System.in);
		Bank bank = initBank();
		boolean exitRequested = false;
		while (!exitRequested) {
			try {
				Menu.printMenu();
				int choice = Integer.parseInt(scanner.next());
				switch (choice) {
				case 1:
					try {
						bank.registerAccount();
					} catch (IncorrectNumberException e) {
						LOGGER.warn(e.getMessage());
					}
					break;
				case 2:
					try {
						bank.manageAccount();
					} catch (InvalidAmountException | InsufficientFundsException | InvalidAccountException |
							IncorrectNumberException | IncorrectDetailException e) {
						LOGGER.warn(e.getMessage());
					}
					break;
				case 3:
					bank.listAccounts();
					break;
				case 4:
					bank.IPrintBasicOperations();
					break;
				case 5:
					exitRequested = true;
					break;
				default:
					LOGGER.warn("Wrong input");
					break;
				}
			} catch (NumberFormatException e) {
				throw new CustomNumberFormatException("Invalid input. Please enter a valid number.");
			} catch (InputMismatchException e) {
				throw new CustomInputMismatchException("Invalid input.");
			}
		}
		scanner.close();
	}

	private static Bank initBank() {

		Address address1 = new Address("EEUU", "CA", "Venice", "ABCD", "123");
		Address address2 = new Address("EEUU", "CA", "Santa Monica", "BCDE", "234");
		Address address3 = new Address("EEUU", "CA", "Venice", "CDEF", "345");
		Bank bank = new Bank("bank1", address1);
		Card card1 = new Card("123456789", "202608", "202108", "John Florence", "BBVA", Scheme.MASTER_CARD,
				CardType.DEBIT);
		CreditSummary credSummary1 = new CreditSummary(4000, 50000, false, false);
		CreditSummary credSummary2 = new CreditSummary(3000, 150000, false, true);
		CreditSummary credSummary3 = new CreditSummary(2000, 200, true, false);
		Client client1 = new Client("John", "Florence", "1231231231", address2, credSummary1);
		Client client2 = new Client("Richard", "Rodriguez", "1234567899", address3, credSummary2);
		Client client3 = new Client("Mark", "Zucke", "1234567899", address3, credSummary3);
		client1.setCard(card1);
		bank.registerCheckingAccount(client1);
		bank.registerCheckingAccount(client2);
		bank.registerCheckingAccount(client3);
		return bank;
	}


}
