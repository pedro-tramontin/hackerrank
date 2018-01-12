package br.com.pedront.hackerrank.crackingthecodinginterview.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pnakano
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 10/01/18 15:20
 */
public class FibonacciNumbers {

    static Map<Integer, Long> cache = new HashMap<Integer, Long>() {
        {
            this.put(0, 0L);
            this.put(1, 1L);
        }
    };

    public static Long fibonacci(int n) {

        Long value = cache.get(n);
        if (value != null) {
            return value;
        }

        Long n1 = fibonacci(n - 1);
        Long n2 = fibonacci(n - 2);

        cache.put(n, n1 + n2);

        return n1 + n2;
    }

    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // int n = scanner.nextInt();
        // scanner.close();
        // System.out.println(fibonacci(n));

        System.out.println(fibonacci(30));
    }
}
