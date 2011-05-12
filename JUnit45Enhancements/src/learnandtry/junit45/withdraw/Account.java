package learnandtry.junit45.withdraw;

import java.math.BigDecimal;


public class Account {

    private BigDecimal balance = BigDecimal.ZERO;


    public Account(BigDecimal balance) {
        this.balance = balance;
    }

    public Boolean withdraw(BigDecimal amount) {
        if (!hasEnoughBalance(amount)) {
            return false;
        }

        balance = balance.subtract(amount);
        return true;
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public Boolean transfer(BigDecimal amount, Account toAccount) {
        if (!hasEnoughBalance(amount)) {
            return false;
        }

        balance = balance.subtract(amount);
        toAccount.deposit(amount);
        return true;
    }

    private Boolean hasEnoughBalance(BigDecimal amount) {
        return balance.compareTo(amount) >= 0;

    }

    public BigDecimal getBalance() {
        return this.balance;
    }

}
