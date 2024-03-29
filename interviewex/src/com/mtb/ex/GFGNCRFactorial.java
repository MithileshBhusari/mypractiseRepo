package com.mtb.ex;

import java.util.HashMap;

/**
 * @author MithileshB
 * @created 30/01/2022 - 1:38 PM
 * @project interviewex
 */
public class GFGNCRFactorial {

    static long mod = 1000003;

    public static int nCr(long n, long r) {
        return (int) lucas(n, r);
    }

    static long binary_expo(long a, long b) {
        if (b == 0)
            return 1;
        long res = (binary_expo(a, b / 2)) % mod;
        if ((b & 1) != 0)
            return ((res % mod * res % mod) % mod * a % mod) % mod;
        else
            return (res % mod * res % mod) % mod;
    }

    static long mod_inverse(long a) {
        return binary_expo(a, mod - 2);
    }

    static long fermat(long n, long r) {
        if (n < r) return 0;
        if (r == 0 || n == r) return 1;
        if (r == n - 1 || r == 1) return n;
        HashMap<Long, Long> fact = new HashMap<>();
        fact.put((long) 0, (long) 1);
        for (long i = 1; i <= n; i++) {
            long x = (fact.get(i - 1) * i) % mod;
            fact.put(i, x);
        }
        long a = fact.get(n);
        long b = mod_inverse(fact.get(n - r));
        long c = mod_inverse(fact.get(r));
        return ((a % mod * b % mod) % mod * c % mod) % mod;
    }

    static long lucas(long n, long r) {
        if (r == 0)
            return 1;
        long ni = n % mod, ri = r % mod;
        return (lucas(n / mod, r / mod) * fermat(ni, ri)) % mod;
    }
}

