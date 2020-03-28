package ChainOfResponsibility;

import java.math.BigInteger;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        final int MAX = 1000;
        final int MIN = 10;
        Set<Integer> numbers = Stream.generate(() -> (int) (Math.random() * (MAX - MIN) + MIN))
                .limit(100)
                .collect(Collectors.toSet());


        IHandler chainHead = new PrimeNumberHandler();
        chainHead.setNextHandler(new EvenNumberHandler())
                .setNextHandler(new DividedByThreeNumberHandler())
                .setNextHandler(new ErrorHandler());

        for (Integer number : numbers) {
            chainHead.handle(new Request(number));
        }
    }

    static class PrimeNumberHandler extends ABaseHandler {
        @Override
        public void handle(Request request) {
            if (validate(request)) {
                System.out.printf("%s handled by PrimeNumberHandler\n", request.value);
                return;
            }
            super.handle(request);
        }

        @Override
        public boolean validate(Request request) {
            return new BigInteger(String.valueOf(request.value)).isProbablePrime(2);
        }
    }

    static class EvenNumberHandler extends ABaseHandler {

        @Override
        public void handle(Request request) {
            if (validate(request)) {
                System.out.printf("%s handled by EvenNumberHandler\n", request.value);
                return;
            }
            super.handle(request);
        }

        @Override
        public boolean validate(Request request) {
            return request.value % 2 == 0;
        }
    }

    static class DividedByThreeNumberHandler extends ABaseHandler {

        @Override
        public void handle(Request request) {
            if (validate(request)) {
                System.out.printf("%s handled by DividedByThreeNumberHandler\n", request.value);
                return;
            }
            super.handle(request);
        }

        @Override
        public boolean validate(Request request) {
            return request.value % 3 == 0;
        }
    }

    static class ErrorHandler extends ABaseHandler {

        @Override
        public void handle(Request request) {
            if (validate(request)) {
                System.out.printf("%s handled by ErrorHandler\n", request.value);
                return;
            }
            super.handle(request);
        }

        @Override
        public boolean validate(Request request) {
            return true;
        }
    }
}
