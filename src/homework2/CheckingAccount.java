package homework2;

import homework2.exceptions.InvalidAmountException;
import homework2.persons.Client;

public class CheckingAccount extends Account implements IDeposit, IWithdrawal, ITransfer {

    private static final String ENTER_VALID_AMOUNT = "Enter a valid amount";
    private static final AccountType accType = AccountType.CHECKING;

    public CheckingAccount(Client client) {
        super(client);
    }


    @Override
    public void depositMoney(long depositAmount) throws InvalidAmountException {
        if (depositAmount < 0) {
            System.out.println(ENTER_VALID_AMOUNT);
            throw new InvalidAmountException("Enter a valid amount");
        } else {
            this.setBalance(getBalance() + depositAmount);
            System.out.println("You have deposit " + depositAmount + " to your account." + "\n" + "Balance is now: "
                    + this.getBalance());
        }
    }

    @Override
    public void withdrawal(long withdrawalAmount) throws InvalidAmountException {
        if (withdrawalAmount < 0) {
            System.out.println(ENTER_VALID_AMOUNT);
            throw new InvalidAmountException("Enter a valid amount");
        } else if (this.getBalance() < withdrawalAmount) {
            System.out.println("You don't have enough funds.");
        } else {
            this.setBalance(getBalance() - withdrawalAmount);
            System.out.println("You have withdrawal " + withdrawalAmount + " from your account." + "\n"
                    + "Balance is now: " + this.getBalance());
        }

    }

    @Override
    public void transferMoney(Account thisAccount, Account toAccount, long amountToTransfer) throws InvalidAmountException {
        if (thisAccount.getID() == toAccount.getID()) {
            System.out.println("Same Account, not valid");
        } else if (amountToTransfer < 0) {
            System.out.println(ENTER_VALID_AMOUNT);
            throw new InvalidAmountException("Enter a valid amount");
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
    public String getSummary() {
        return "ID: " + getID() + ", " + getClient().getFullName() + ", " + accType;
    }

    @Override
    public String toString() {
        return "Name: " + getFirstName() + "\n" + "Last name: " + getLastName() + "\n" + "Balance: " + getBalance()
                + "\n" + "ID: " + getID();
    }
}