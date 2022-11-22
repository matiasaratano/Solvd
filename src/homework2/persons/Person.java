package homework2.persons;

import java.util.Objects;

import homework2.Adress;

public abstract class Person {

	private String name;
	private String lastName;
	private Adress adress;

	protected Person(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
	}

	protected Person(String name, String lastName, Adress adress) {
		this.name = name;
		this.lastName = lastName;
		this.adress = adress;
	}

	public abstract void getFullName();

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

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}


	@Override
	public String toString() {
		return "Person [name=" + name + ", lastName=" + lastName + ", adress=" + adress + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(adress, lastName, name);
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
		Person other = (Person) obj;
		return Objects.equals(adress, other.adress) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(name, other.name);
	}

}
