package homework2.persons;

import java.util.Objects;

import homework2.Adress;
import homework2.CreditSummary;
import homework2.card.Card;

public class Client extends Person {

	private Card card;
	private String phoneNumber;
	private CreditSummary creditSummary;

	public Client(String name, String lastName) {
		super(name, lastName);
	}

	public Client(String name, String lastName, Adress adress) {
		super(name, lastName, adress);
	}

	public Client(String name, String lastName, Adress adress, CreditSummary creditSummary, String phoneNumber) {
		super(name, lastName, adress);
		this.creditSummary = creditSummary;
		this.phoneNumber = phoneNumber;
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
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(card, creditSummary, phoneNumber);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Client other = (Client) obj;
		return Objects.equals(card, other.card) && Objects.equals(creditSummary, other.creditSummary)
				&& Objects.equals(phoneNumber, other.phoneNumber);
	}

	@Override
	public String toString() {
		return "Client [name=" + this.getName() + ", lastName=" + this.getLastName() + ", adress=" + this.getAdress()
		+ ", card=" + card
		+ ", phoneNumber=" + phoneNumber + ", creditSummary=" + creditSummary + "]";
	}

	@Override
	public void getFullName() {
		System.out.println(this.getName() + " " + this.getLastName());
	}

}
