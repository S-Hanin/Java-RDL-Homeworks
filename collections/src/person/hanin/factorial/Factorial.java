package person.hanin.factorial;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


// TODO task1: We use Optional for return values, is it a good idea
//  to use it as incoming parameters? Write down your thoughts.
//        1.Using Optional parameters causing conditional logic inside the methods
//          is literally contra-productive.
//        2.Needing to pack an argument in an Optional, is suboptimal for the compiler,
//          and does an unnecessary wrapping.
//        3.In comparison to nullable parameters Optional is more costly.

public class Factorial {
    private Map<Integer, Long> cache = new HashMap<>();

    /**
     * Calculates factorial of given number.
     *
     * @param n int
     * @return Long
     */
    public Long calculate(int n) {
        if (n == 0) return 1L;
        // TODO task1: Modify your Cache from previous task and return
        //  Optional#empty instead of null if element is missing
        Optional<Long> cached = Optional.ofNullable(this.cache.get(n));
        Long result = cached.orElseGet(() -> n * calculate(n - 1)); //it's pretty convenient method

        cache.put(n, result);
        return result;
    }
}
