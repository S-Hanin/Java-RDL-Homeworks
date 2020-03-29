package State;

public class Main {
    public static void main(String[] args) {
        ICoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.init();
        coffeeMachine.Deposit(7);
        coffeeMachine.Deposit(5);

        coffeeMachine.PrepareCoffee(CoffeeType.CAPPUCCINO);
        coffeeMachine.DeliverCoffee();
        coffeeMachine.GiveChange();
        coffeeMachine.stop();

        coffeeMachine.Deposit(5);
    }
}
