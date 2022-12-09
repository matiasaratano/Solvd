package homework2.interfaces;

import homework2.Account;
import homework2.exceptions.InsufficientFundsException;
import homework2.exceptions.InvalidAccountException;
import homework2.exceptions.InvalidAmountException;

public interface ITransfer {

    public void transferMoney(Account thisAccount, Account toAccount, long amountToTransfer) throws InvalidAmountException, InsufficientFundsException, InvalidAccountException;
}
