package person.hanin.task1;

public class Bank {
    private Integer moneyAmount;

    public Bank(Integer moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public void transferMoney(int amount) {
        // this is a race condition so we should
        // synchronize this code
        synchronized (this) {
            if (!hasEnoughMoney(amount)) {
                throw new IllegalArgumentException("not enough money");
            }
            moneyAmount -= amount;
        }
    }

    public boolean hasEnoughMoney(int amount) {
        return moneyAmount >= amount;
    }
}
