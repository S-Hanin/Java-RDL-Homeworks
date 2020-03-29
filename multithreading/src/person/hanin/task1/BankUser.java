package person.hanin.task1;

public class BankUser {
    private Bank bank;

    public BankUser(Bank bank) {
        this.bank = bank;
    }

    public void withdraw(int amount) {
        // this is a race condition in multithreading environment
        // so we can get an "not enough money" exception
        if (bank.hasEnoughMoney(amount)) {
            bank.transferMoney(amount);
            System.out.printf("%s takes %s money\n", this, amount);
        }
    }
}
