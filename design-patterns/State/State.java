package State;

public abstract class State {
    protected CoffeeMachine coffeeMachine;

    public State(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    public void Deposit(int MoneyAmount){
        dispatchError();
    }
    public void PrepareCoffee(CoffeeType coffeeType){
        dispatchError();
    }
    public void DeliverCoffee(){
        dispatchError();
    }
    public void GiveChange(int MoneyAmount){
        dispatchError();
    }

    public void dispatchError(){
        System.out.printf("Unsupported operation at %s", this.getClass().getName());
    }
}
