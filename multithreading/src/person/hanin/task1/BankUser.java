package person.hanin.task1;

public class BankUser {
    private Bank bank;

    public BankUser(Bank bank) {
        this.bank = bank;
    }

    public void withdraw(int amount){
        if (bank.hasEnoughMoney(amount)){
            bank.transferMoney(amount);
        }
    }
}
