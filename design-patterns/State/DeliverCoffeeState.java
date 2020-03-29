package State;

class DeliverCoffeeState extends State {
    DeliverCoffeeState(CoffeeMachine coffeeMachine) {
        super(coffeeMachine);
    }

    @Override
    void DeliverCoffee() {
        System.out.println("Delivering coffee");
        coffeeMachine.changeState(new GiveChangeState(coffeeMachine));
    }

}
