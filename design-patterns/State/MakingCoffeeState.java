package State;

public class MakingCoffeeState extends State {
    public MakingCoffeeState(CoffeeMachine coffeeMachine) {
        super(coffeeMachine);
    }

    @Override
    public void PrepareCoffee(CoffeeType coffeeType) {
        System.out.println("Preparing coffee");
        coffeeMachine.changeState(new DeliverCoffeeState(coffeeMachine));
    }
}
