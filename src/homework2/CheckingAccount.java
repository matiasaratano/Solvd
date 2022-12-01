package homework2;

import homework2.persons.Client;

public class CheckingAccount extends Account implements IDeposit, IWithdrawal, ITransfer {

    private static final String ENTER_VALID_AMOUNT = "Enter a valid amount";

    public CheckingAccount(Client client) {
        super(client);
    }

    @Override
    public void depositMoney(long depositAmount) {
        if (depositAmount < 0) {
            System.out.println(ENTER_VALID_AMOUNT);
        } else {
            this.setBalance(getBalance() + depositAmount);
            System.out.println("You have deposit " + depositAmount + " to your account." + "\n" + "Balance is now: "
                    + this.getBalance());
        }
    }

    @Override
    public void withdrawal(long withdrawalAmount) {
        if (withdrawalAmount < 0) {
            System.out.println(ENTER_VALID_AMOUNT);
        } else if (this.getBalance() < withdrawalAmount) {
            System.out.println("You don't have enough funds.");
        } else {
            this.setBalance(getBalance() - withdrawalAmount);
            System.out.println("You have withdrawal " + withdrawalAmount + " from your account." + "\n"
                    + "Balance is now: " + this.getBalance());
        }

    }

    @Override
    public void transferMoney(Account thisAccount, Account toAccount, long amountToTransfer) {
        if (thisAccount.getID() == toAccount.getID()) {
            System.out.println("Same Account, not valid");
        } else if (amountToTransfer < 0) {
            System.out.println(ENTER_VALID_AMOUNT);
        } else if (thisAccount.getBalance() > amountToTransfer) {
            toAccount.setBalance(this.getBalance() + amountToTransfer);
            thisAccount.setBalance(this.getBalance() - amountToTransfer);
            System.out.println("You transferred: " + amountToTransfer + "\n"
                    + "Balance is now: " + this.getBalance());
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