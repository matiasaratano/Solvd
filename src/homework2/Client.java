package homework2;

public class Client extends Person {


	private Card card;
	private String phoneNumber;
	private CreditSummary creditSummary;

	public Client(String name, String lastName) {
		this.setName(lastName);
		this.setLastName(lastName);
	}

	public Client(String name, String lastName, Adress adress) {
		this.setName(lastName);
		this.setLastName(lastName);
		this.setAdress(adress);
	}

	public Client(String name, String lastName, Adress adress, CreditSummary creditSummary, String phoneNumber) {
		this.setName(lastName);
		this.setLastName(lastName);
		this.setAdress(adress);
		this.setCreditSummary(creditSummary);
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String getName() {
		return this.getName();
	}

	@Override
	public String getLastName() {
		return this.getLastName();
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
		return "Client [name=" + this.getName() + ", lastName=" + this.getLastName() + ", adress=" + this.getAdress()
				+ ", card=" + card
				+ ", phoneNumber=" + phoneNumber + ", creditSummary=" + creditSummary + "]";
	}

}
