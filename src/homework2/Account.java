package homework2;

import homework2.persons.Client;

public class Account {

    private long balance;
    private static int uid = 0;
    private final int id;
    private final Client client;
    private static final String ENTER_VALID_AMOUNT = "Enter a valid amount";

    public Account(Client client) {
        this.client = client;
        //balance = new Money();
        this.balance = 0;
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
        return this.balance;
    }

    public void setBalance(long newBalance) {
        this.balance = newBalance;
    }

    public int getID() {
        return this.id;
    }

    public String getPhoneNumber() {
        return this.client.getPhoneNumber();
    }

    public Client getClient() {
        return client;
    }

    public void depositMoney(long depositAmount) {
        if (depositAmount < 0) {
            System.out.println(ENTER_VALID_AMOUNT);
        } else {
            this.balance = balance + depositAmount;
            System.out.println("You have deposit " + depositAmount + " to your account." + "\n" + "Balance is now: "
                    + this.balance);
        }
    }

    public void withdrawal(long withdrawalAmount) {
        if (withdrawalAmount < 0) {
            System.out.println(ENTER_VALID_AMOUNT);
        } else if (this.balance < withdrawalAmount) {
            System.out.println("You don't have enough funds.");
        } else {
            this.balance = balance - withdrawalAmount;
            System.out.println("You have withdrawal " + withdrawalAmount + " from your account." + "\n"
                    + "Balance is now: " + this.balance);
        }

    }

    public void transferMoney(Account thisAccount, Account toAccount, long amountToTransfer) {
        if (thisAccount.getID() == toAccount.getID()) {
            System.out.println("Same Account, not valid");
        } else if (amountToTransfer < 0) {
            System.out.println(ENTER_VALID_AMOUNT);
        } else if (thisAccount.getBalance() > amountToTransfer) {
            toAccount.setBalance(this.getBalance() + amountToTransfer);
            thisAccount.setBalance(this.getBalance() - amountToTransfer);
            System.out.println("You transferred: " + amountToTransfer + "\n"
                    + "Balance is now: " + this.balance);
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
