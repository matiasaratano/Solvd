package homework2;

public class Money {

    private long balance;

    public Money() {
        this.balance = 0;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "" + balance + "";
    }

}
