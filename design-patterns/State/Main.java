package State;

public class Main {
    public static void main(String[] args) {
        ICoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.init();
        coffeeMachine.Deposit(10);
        coffeeMachine.Deposit(10);

        coffeeMachine.PrepareCoffee(CoffeeType.AMERICANO);
        coffeeMachine.DeliverCoffee();
        coffeeMachine.GiveChange(5);
        coffeeMachine.stop();

        coffeeMachine.Deposit(5);
    }
}
