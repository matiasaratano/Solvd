package homework2;

import homework2.exceptions.InvalidAmountException;

public interface IDeposit {

    public void depositMoney(long depositAmount) throws InvalidAmountException;
}
