package homework2;

import java.util.Objects;

public class Card {

	private String cardNumber;
	private String dateExp;
	private String dateFrom;
	private String name;
	private int cvv;
	private String bank;
	private Scheme scheme;
	private CardType type;

	public Card(String cardNumber, String dateExp, String dateFrom, String name, String bank, Scheme scheme,
			CardType type) {
		this.cardNumber = cardNumber;
		this.dateExp = dateExp;
		this.dateFrom = dateFrom;
		this.name = name;
		this.bank = bank;
		this.scheme = scheme;
		this.type = type;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getName() {
		return name;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bank, cardNumber, cvv, dateExp, dateFrom, name, scheme, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Card other = (Card) obj;
		return Objects.equals(bank, other.bank) && Objects.equals(cardNumber, other.cardNumber) && cvv == other.cvv
				&& Objects.equals(dateExp, other.dateExp) && Objects.equals(dateFrom, other.dateFrom)
				&& Objects.equals(name, other.name) && scheme == other.scheme && type == other.type;
	}

	@Override
	public String toString() {
		return "Card [cardNumber=" + cardNumber + ", dateExp=" + dateExp + ", dateFrom=" + dateFrom + ", name=" + name
				+ ", bank=" + bank + ", scheme=" + scheme + ", type=" + type + "]";
	}

}
