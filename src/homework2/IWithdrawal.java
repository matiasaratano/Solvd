package homework2;

import homework2.exceptions.InvalidAmountException;

public interface IWithdrawal {

    public void withdrawal(long withdrawalAmount) throws InvalidAmountException;
}
