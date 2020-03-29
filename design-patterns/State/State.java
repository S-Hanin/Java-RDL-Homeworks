package State;

abstract class State {
    protected CoffeeMachine coffeeMachine;

    State(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    void Deposit(int MoneyAmount) {
        dispatchError();
    }

    void PrepareCoffee(CoffeeType coffeeType) {
        dispatchError();
    }

    void DeliverCoffee() {
        dispatchError();
    }

    void GiveChange() {
        dispatchError();
    }

    void dispatchError() {
        System.out.printf("Unsupported operation at %s\n", this.getClass().getName());
    }
}
