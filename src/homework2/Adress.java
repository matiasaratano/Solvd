package homework2;

public class Adress {

	private String country;
	private String province;
	private String town;
	private String streetAdress;
	private String zipCode;

	public Adress(String country, String province, String town, String streetAdress, String zipCode) {
		this.country = country;
		this.province = province;
		this.town = town;
		this.streetAdress = streetAdress;
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Adress [country=" + country + ", province=" + province + ", town=" + town + ", streetAdress="
				+ streetAdress + ", zipCode=" + zipCode + "]";
	}

}
