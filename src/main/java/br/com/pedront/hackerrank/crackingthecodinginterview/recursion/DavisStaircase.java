package br.com.pedront.hackerrank.crackingthecodinginterview.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pnakano
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 10/01/18 15:33
 */
public class DavisStaircase {

    static Map<Integer, Long> cache = new HashMap<>();

    static Long findNumberOfWays(int n) {
        return findNumberOfWays(n, 0);
    }

    static Long findNumberOfWays(final int totalSteps, final int step) {
        if (step == totalSteps) {
            return 1L;
        }

        if (step > totalSteps) {
            return 0L;
        }

        int lastingSteps = totalSteps - step;

        Long value = cache.get(lastingSteps);
        if (value != null) {
            return value;
        }

        Long sum = findNumberOfWays(totalSteps, step + 1)
                + findNumberOfWays(totalSteps, step + 2)
                + findNumberOfWays(totalSteps, step + 3);

        cache.put(lastingSteps, sum);

        return sum;
    }

    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        // int s = in.nextInt();
        // for (int a0 = 0; a0 < s; a0++) {
        // int n = in.nextInt();
        // }

        System.out.println(findNumberOfWays(7));
    }
}
