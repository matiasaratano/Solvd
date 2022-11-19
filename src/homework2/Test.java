package homework2;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    Adress adress = new Adress("EEUU","CA","Venice","ABC","123");
	    Bank bank = new Bank("Bank1",adress);
	    boolean exitRequested = false;
	    while(!exitRequested) {
	        PrintService.printMenu();
	        int choice = Integer.parseInt(sc.next());
	        switch (choice) {
	            case 1:
	                bank.registerAccount();
	                break;
	            case 2:
	                bank.loginAccount();
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
