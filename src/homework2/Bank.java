package homework2;

import java.util.ArrayList;

public class Bank {
	
	private String name;
	private Adress adress;
	private ArrayList<Client> clients;
	
	public Bank(String name, Adress adress) {
		super();
		this.name = name;
		this.adress = adress;
		clients = new ArrayList<>();
	}
	
	
}
