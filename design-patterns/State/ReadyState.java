package State;

class ReadyState extends State {
    ReadyState(CoffeeMachine coffeeMachine) {
        super(coffeeMachine);
        coffeeMachine.currentChoice = null;
    }

    @Override
    void Deposit(int moneyAmount) {
        if (moneyAmount <= 0) {
            throw new IllegalArgumentException("unsupported money amount");
        }
        coffeeMachine.deposit += moneyAmount;
        System.out.printf("%s money given. Current deposit %s\n", moneyAmount, coffeeMachine.deposit);
    }

    @Override
    void PrepareCoffee(CoffeeType coffeeType) {
        if (coffeeMachine.deposit <= coffeeMachine.menu.get(coffeeType)) {
            System.out.println(String.format("Deposit is not enough for %s", coffeeType.name()));
            return;
        }
        coffeeMachine.currentChoice = coffeeType;
        System.out.println("Preparing coffee");
        coffeeMachine.changeState(new DeliverCoffeeState(coffeeMachine));
    }
}
