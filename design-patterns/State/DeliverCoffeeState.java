package State;

public class DeliverCoffeeState extends State {
    public DeliverCoffeeState(CoffeeMachine coffeeMachine) {
        super(coffeeMachine);
    }

    @Override
    public void DeliverCoffee() {
        System.out.println("Delivering coffee");
        coffeeMachine.changeState(new GiveChangeState(coffeeMachine));
    }

}
