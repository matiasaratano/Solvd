package homework2;

import java.util.Objects;

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
	public int hashCode() {
		return Objects.hash(country, province, streetAdress, town, zipCode);
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
		Adress other = (Adress) obj;
		return Objects.equals(country, other.country) && Objects.equals(province, other.province)
				&& Objects.equals(streetAdress, other.streetAdress) && Objects.equals(town, other.town)
				&& Objects.equals(zipCode, other.zipCode);
	}

	@Override
	public String toString() {
		return "Adress [country=" + country + ", province=" + province + ", town=" + town + ", streetAdress="
				+ streetAdress + ", zipCode=" + zipCode + "]";
	}

}
