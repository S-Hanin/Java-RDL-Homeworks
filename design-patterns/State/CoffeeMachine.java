package State;

import java.util.EnumMap;

public class CoffeeMachine implements ICoffeeMachine {

    CoffeeType currentChoice;
    Integer deposit = 0;
    Long proceeds = 0L;
    EnumMap<CoffeeType, Integer> menu;
    private State state;

    {
        menu = new EnumMap<>(CoffeeType.class);
        menu.put(CoffeeType.CAPPUCCINO, 10);
        menu.put(CoffeeType.AMERICANO, 5);
        menu.put(CoffeeType.ESPRESSO, 3);
    }

    @Override
    public void Deposit(int MoneyAmount) {
        state.Deposit(MoneyAmount);
    }

    @Override
    public void PrepareCoffee(CoffeeType coffeeType) {
        state.PrepareCoffee(coffeeType);
    }

    @Override
    public void DeliverCoffee() {
        state.DeliverCoffee();
    }

    @Override
    public void GiveChange() {
        state.GiveChange();
    }

    @Override
    public void dispatchError() {
        state.dispatchError();
    }

    @Override
    public void init() {
        System.out.println("Coffee machine initialized");
        state = new ReadyState(this);
    }

    @Override
    public void stop() {
        state = new StoppedState(this);
        System.out.println("Coffee machine stopped");
    }

    void changeState(State state) {
        System.out.printf("State changed to %s\n", state.getClass().getName());
        this.state = state;
    }

}
