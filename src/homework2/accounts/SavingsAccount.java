package homework2.accounts;

import homework2.accounts.Account;
import homework2.accounts.AccountType;
import homework2.exceptions.InsufficientFundsException;
import homework2.exceptions.InvalidAmountException;
import homework2.interfaces.IDeposit;
import homework2.interfaces.IWithdrawal;
import homework2.persons.Client;

public class SavingsAccount extends Account implements IDeposit, IWithdrawal {

    private static final AccountType accType = AccountType.SAVINGS;
    //Not implemented yet

    public SavingsAccount(Client client) {
        super(client);
    }


    @Override
    public String getSummary() {
        //Not implemented
        return " ";
    }

    @Override
    public void depositMoney(long depositAmount) throws InvalidAmountException {

    }


    @Override
    public void withdrawal(long withdrawalAmount) throws InvalidAmountException, InsufficientFundsException {

    }

    @Override
    public void transferMoney(Account thisAccount, Account toAccount, long amountToTransfer) throws InvalidAmountException, InsufficientFundsException {

    }

}
