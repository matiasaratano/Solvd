package homework2;

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
    public void depositMoney(long depositAmount) {

    }

    @Override
    public void withdrawal(long withdrawalAmount) {

    }

    @Override
    public void transferMoney(Account thisAccount, Account toAccount, long amountToTransfer) {

    }
}
