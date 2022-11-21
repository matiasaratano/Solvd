package homework2;

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

	@Override
	public String toString() {
		return "Card [cardNumber=" + cardNumber + ", dateExp=" + dateExp + ", dateFrom=" + dateFrom + ", name=" + name
				+ ", bank=" + bank + ", scheme=" + scheme + ", type=" + type + "]";
	}

}
