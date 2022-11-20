package homework2;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Adress adress1 = new Adress("EEUU", "CA", "Venice", "ABC", "123");
		Adress adress2 = new Adress("EEUU", "CA", "Santa Monica", "BCD", "234");
		Adress adress3 = new Adress("EEUU", "CA", "Venice", "CDE", "345");
		Bank bank = new Bank("Bank1", adress1);
		Client client1 = new Client ("Jhon", "Florence", adress2);
		Client client2 = new Client ("Richard", "Rodriguez", adress3);
		bank.registerAccount(client1, "1231231231");
		bank.registerAccount(client2, "1234567899");

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
