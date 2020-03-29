package State;

public class ReadyState extends State {
    public ReadyState(CoffeeMachine coffeeMachine) {
        super(coffeeMachine);
    }

    @Override
    public void Deposit(int MoneyAmount) {
        if (MoneyAmount <= 0){
            throw new IllegalArgumentException("unsupported money amount");
        }
        coffeeMachine.deposit += MoneyAmount;
        System.out.printf("%s money given. Current deposit %s", MoneyAmount, coffeeMachine.deposit);
    }

    @Override
    public void PrepareCoffee(CoffeeType coffeeType) {
        coffeeMachine.changeState(new MakingCoffeeState(coffeeMachine));
    }
}
