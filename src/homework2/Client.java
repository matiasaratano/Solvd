package homework2;

public class Client {

	private String name;
	private String lastName;
	private String id;
	private Adress adress;
	private String email;
	private Account account;
	private Card card;

	public Client(String name, String lastName) {
		super();
		this.name = name;
		this.lastName = lastName;
	}
	
	public Client(String name, String lastName, Adress adress) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.adress = adress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



}
