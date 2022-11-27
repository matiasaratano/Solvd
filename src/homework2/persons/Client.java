package homework2.persons;

import java.util.Objects;

import homework2.Adress;
import homework2.CreditSummary;
import homework2.card.Card;

public class Client extends Person {

	private Card card;
	private CreditSummary creditSummary;

	public Client(String name, String lastName, String phoneNumber) {
		super(name, lastName, phoneNumber);
	}

	public Client(String name, String lastName, String phoneNumber, Adress adress) {
		super(name, lastName, phoneNumber, adress);
	}

	public Client(String name, String lastName, String phoneNumber, Adress adress, CreditSummary creditSummary) {
		super(name, lastName, phoneNumber, adress);
		this.creditSummary = creditSummary;
	}

	public void setCard(Card card) {
		this.card = card;
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
		result = prime * result + Objects.hash(card, creditSummary, getPhoneNumber());
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
				&& Objects.equals(getPhoneNumber(), other.getPhoneNumber());
	}

	@Override
	public String toString() {
		return "Client [name=" + this.getName() + ", lastName=" + this.getLastName() + ", adress=" + this.getAdress()
		+ ", card=" + card
		+ ", phoneNumber=" + getPhoneNumber() + ", creditSummary=" + creditSummary + "]";
	}


}
