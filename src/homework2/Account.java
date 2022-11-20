package homework2;

public class Account {

	private Money balance;
	private static int uid = 0;
	private String phoneNumber;
	private int id;
	private Client client;

	public Account(Client client, String phoneNumber) {
		this.client = client;
		this.phoneNumber = phoneNumber;
		balance = new Money();
		this.balance.setBalance(0);
		uid++;
		this.id = uid;
	}

	public String getFirstName() {
		return this.client.getName();
	}

	public String getLastName() {
		return this.client.getLastName();
	}

	public long getBalance() {
		return this.balance.getBalance();
	}

	public void setBalance(long newBalance) {
		this.balance.setBalance(newBalance);
	}

	public int getID() {
		return this.id;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void depositMoney(long depositAmount) {
		if (depositAmount < 0) {
			System.out.println("Enter a valid amount");
		} else {
			this.balance.setBalance(balance.getBalance() + depositAmount);
			System.out.println("You have deposit " + depositAmount + " to your account." + "\n" + "Balance is now: "
					+ this.balance);
		}
	}

	public void withdrawal(long withdrawalAmount) {
		if (withdrawalAmount < 0) {
			System.out.println("Enter a valid amount");
		} else if (this.balance.getBalance() < withdrawalAmount) {
			System.out.println("You don't have enough funds.");
		} else {
			this.balance.setBalance(balance.getBalance() - withdrawalAmount);
			System.out.println("You have withdrawal " + withdrawalAmount + " from your account." + "\n"
					+ "Balance is now: " + this.balance);
		}

	}

	public void transferMoney(Account thisAccount, Account toAccount, long amountToTransfer) {
		if (thisAccount.getID() == toAccount.getID()) {
			System.out.println("Same Account");
		} else if (amountToTransfer < 0) {
			System.out.println("Enter a valid amount");
		} else if (thisAccount.getBalance() > 0) {
			toAccount.setBalance(toAccount.getBalance() + amountToTransfer);
			thisAccount.setBalance(this.balance.getBalance() - amountToTransfer);
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
