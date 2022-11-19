package homework2;

public class Account {

	private String firstName;
	private String lastName;
	private double balance;
	private static int uid = 0;
	private String phoneNumber;
	private int id;

	public Account(String firstName, String lastName, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.balance = 0.0;
		uid++;
		this.id = uid;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double newBalance) {
		this.balance = newBalance;
	}

	public int getID() {
		return this.id;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void depositMoney(double depositAmount) {
		if (depositAmount < 0) {
			System.out.println("Enter a valid amount");
		} else {
			this.balance += depositAmount;
			System.out.println("You have deposit " + depositAmount + " to your account." + "\n" + "Balance is now: "
					+ this.balance);
		}
	}

	public void withdrawal(double withdrawalAmount) {
		if (withdrawalAmount < 0) {
			System.out.println("Enter a valid amount");
		} else if (this.balance < withdrawalAmount) {
			System.out.println("You don't have enough funds.");
		} else {
			this.balance -= withdrawalAmount;
			System.out.println("You have withdrawal " + withdrawalAmount + " from your account." + "\n"
					+ "Balance is now: " + this.balance);
		}

	}

	public void transferMoney(Account thisAccount, Account toAccount, double amountToTransfer) {
		if (amountToTransfer < 0) {
			System.out.println("Enter a valid amount");
		} else if (thisAccount.getBalance() > 0) {
			toAccount.setBalance(toAccount.balance += amountToTransfer);
			thisAccount.setBalance(this.balance -= amountToTransfer);
		} else {
			System.out.println("You don't have enough funds");
		}

	}

	@Override
	public String toString() {
		return "Name: " + getFirstName() + "\n" + "Last name: " + getLastName() + "\n" + "Balance: " + getBalance()
				+ "\n" + "ID: " + getID();
	}

}
