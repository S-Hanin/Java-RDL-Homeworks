package person.hanin.task1;

public class Bank {
    private Integer moneyAmount;

    public Bank(Integer moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public void transferMoney(int amount){

        if (!hasEnoughMoney(amount)){
            throw new IllegalArgumentException("not enough money");
        }
        moneyAmount -= amount;
        System.out.println(String.format("Withdrawed %s money, %s last", amount, moneyAmount));
    }

    public boolean hasEnoughMoney(int amount){
        return moneyAmount >= amount;
    }
}
