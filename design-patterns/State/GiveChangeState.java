package State;

class GiveChangeState extends State {
    GiveChangeState(CoffeeMachine coffeeMachine) {
        super(coffeeMachine);
    }

    @Override
    void GiveChange() {
        Integer moneyAmount = coffeeMachine.deposit - coffeeMachine.menu.get(coffeeMachine.currentChoice);
        if (moneyAmount > 0 && moneyAmount < coffeeMachine.deposit) {
            System.out.printf("%s money for return\n", moneyAmount);
            coffeeMachine.deposit -= moneyAmount;
            coffeeMachine.proceeds += coffeeMachine.deposit;
            coffeeMachine.deposit = 0;
        }
        coffeeMachine.changeState(new ReadyState(coffeeMachine));
    }

}
