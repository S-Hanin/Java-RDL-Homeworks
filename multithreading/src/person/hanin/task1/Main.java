package person.hanin.task1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank(100000);

        ExecutorService pool = Executors.newFixedThreadPool(10);

        Runnable parasite = () -> {
            BankUser bankUser = new BankUser(bank);
            int withdrawAmount = 20000;
            while (bank.hasEnoughMoney(withdrawAmount)){
                try {
                    bankUser.withdraw(withdrawAmount);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    break;
                }
            }
        };

        // Can't catch any exception without synchronization,
        // but sometimes can withdraw more than available
        IntStream.range(0, 10).forEach(x -> pool.execute(parasite));
        pool.shutdown();
    }
}
