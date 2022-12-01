package homework2;

import homework2.persons.Client;

public class SavingsAccount extends Account implements IDeposit, IWithdrawal {

    //Not implemented yet

    public SavingsAccount(Client client) {
        super(client);
    }

    @Override
    public void depositMoney(long depositAmount) {

    }

    @Override
    public void withdrawal(long withdrawalAmount) {

    }
}
