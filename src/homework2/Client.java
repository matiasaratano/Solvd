package homework2;

public class Client {

	private String name;
	private String lastName;
	private Adress adress;
	private Card card;
	private String phoneNumber;
	private CreditSummary creditSummary;

	public Client(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
	}

	public Client(String name, String lastName, Adress adress) {
		this.name = name;
		this.lastName = lastName;
		this.adress = adress;
	}

	public Client(String name, String lastName, Adress adress, CreditSummary creditSummary, String phoneNumber) {
		this.name = name;
		this.lastName = lastName;
		this.adress = adress;
		this.setCreditSummary(creditSummary);
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public CreditSummary getCreditSummary() {
		return creditSummary;
	}

	public void setCreditSummary(CreditSummary creditSummary) {
		this.creditSummary = creditSummary;
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", lastName=" + lastName + ", adress=" + adress + ", card=" + card
				+ ", phoneNumber=" + phoneNumber + ", creditSummary=" + creditSummary + "]";
	}

}
