package homework2;

import java.util.Scanner;

import homework2.card.Card;
import homework2.card.CardType;
import homework2.card.Scheme;
import homework2.persons.Client;

public class Runner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = initBank();
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

    private static Bank initBank() {
        Address address1 = new Address("EEUU", "CA", "Venice", "ABC", "123");
        Address address2 = new Address("EEUU", "CA", "Santa Monica", "BCD", "234");
        Address address3 = new Address("EEUU", "CA", "Venice", "CDE", "345");
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
        bank.registerAccount(client1);
        bank.registerAccount(client2);
        bank.registerAccount(client3);
        return bank;

    }

}
