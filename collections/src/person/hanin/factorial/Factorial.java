package person.hanin.factorial;

import java.util.HashMap;
import java.util.Map;

public class Factorial {
    private Map<Integer, Long> cache = new HashMap<>();

    /**
     * Calculates factorial of given number.
     * @param n int
     * @return Long
     */
    public Long calculate(int n) {
        if (n == 0) return 1L;
        Long result = this.cache.get(n);

        if (result != null) return result;
        result = n * calculate( n - 1);

        cache.put(n, result);
        return result;
    }
}
