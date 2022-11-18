package homework2;

public class Person {

	private String name;
	private String lastName;
	private String id;
	private Adress adress;

	public Person(String name, String lastName, String id, Adress adress) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.id = id;
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", lastName=" + lastName + ", id=" + id + ", adress=" + adress + "]";
	}
}
