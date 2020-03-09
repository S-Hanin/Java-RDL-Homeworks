package person.hanin.factorial;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
        Optional<Long> cached = Optional.ofNullable(this.cache.get(n));
        //it's pretty convenient method
        Long result = cached.orElseGet(() -> n * calculate(n - 1));

        //not far from checking for null
//        if (cached.isPresent()) return cached.get();
//        Long result = n * calculate( n - 1);

        cache.put(n, result);
        return result;
    }
}
