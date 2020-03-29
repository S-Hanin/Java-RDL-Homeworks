package State;

public class GiveChangeState extends State {
    public GiveChangeState(CoffeeMachine coffeeMachine) {
        super(coffeeMachine);
    }

    @Override
    public void GiveChange(int MoneyAmount) {
        System.out.printf("%s money for return\n", MoneyAmount);
        if (MoneyAmount > 0 && MoneyAmount < coffeeMachine.deposit){
            coffeeMachine.deposit -= MoneyAmount;
            coffeeMachine.proceeds += coffeeMachine.deposit;
            coffeeMachine.deposit = 0;
        }
        coffeeMachine.changeState(new ReadyState(coffeeMachine));
    }

}
