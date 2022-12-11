package homework2.accounts;

import homework2.exceptions.InsufficientFundsException;
import homework2.exceptions.InvalidAccountException;
import homework2.exceptions.InvalidAmountException;
import homework2.interfaces.IDeposit;
import homework2.interfaces.ITransfer;
import homework2.interfaces.IWithdrawal;
import homework2.persons.Client;

public class CheckingAccount extends Account implements IDeposit, IWithdrawal, ITransfer {

    private static final AccountType accType = AccountType.CHECKING;

    public CheckingAccount(Client client) {
        super(client);
    }


    @Override
    public void depositMoney(long depositAmount) throws InvalidAmountException {
        if (depositAmount < 0) {
            throw new InvalidAmountException("Enter a valid amount");
        } else {
            this.setBalance(getBalance() + depositAmount);
            System.out.println("You have deposit " + depositAmount + " to your account." + "\n" + "Balance is now: "
                    + this.getBalance());
        }
    }

    @Override
    public void withdrawal(long withdrawalAmount) throws InvalidAmountException, InsufficientFundsException {
        if (withdrawalAmount < 0) {
            throw new InvalidAmountException("Enter a valid amount");
        } else if (this.getBalance() < withdrawalAmount) {
            throw new InsufficientFundsException("Insufficient funds in the account");
        } else {
            this.setBalance(getBalance() - withdrawalAmount);
            System.out.println("You have withdrawal " + withdrawalAmount + " from your account." + "\n"
                    + "Balance is now: " + this.getBalance());
        }

    }

    @Override
    public void transferMoney(Account thisAccount, Account toAccount, long amountToTransfer) throws InvalidAmountException, InsufficientFundsException, InvalidAccountException {
        if (thisAccount.getID() == toAccount.getID()) {
            throw new InvalidAccountException("Enter a valid account");
        } else if (amountToTransfer < 0) {
            throw new InvalidAmountException("Enter a valid amount");
        } else if (thisAccount.getBalance() > amountToTransfer) {
            toAccount.setBalance(this.getBalance() + amountToTransfer);
            thisAccount.setBalance(this.getBalance() - amountToTransfer);
            System.out.println("You transferred: " + amountToTransfer + "\n"
                    + "Balance is now: " + this.getBalance());
        } else {
            throw new InsufficientFundsException("Insufficient funds in the account");
        }

    }

    @Override
    public String getSummary() {
        return "ID: " + getID() + ", " + "Phone: " + getPhoneNumber() + ", " + getClient().getFullName() + ", Account Type: " + accType;
    }

    @Override
    public String toString() {
        return "Name: " + getFirstName() + "\n" + "Last name: " + getLastName() + "\n" + "Balance: " + getBalance()
                + "\n" + "ID: " + getID();
    }
}