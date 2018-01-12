package br.com.pedront.hackerrank.crackingthecodinginterview.dp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author pnakano
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 10/01/18 15:52
 */
public class CoinChange {

    static Map<String, Long> memo = new HashMap<>();

    public static long makeChange(int[] coins, int money) {
        Arrays.sort(coins);

        return makeChange(coins, money, 0);
    }

    private static long makeChange(final int[] coins, final int balance, final int coin) {
        if (balance < 0) {
            return 0;
        }

        if (balance == 0) {
            return 1;
        }

        String key = String.format("%d-%d", coin, balance);
        Long cache = memo.get(key);
        if (cache != null) {
            return cache;
        }

        long sum = 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] >= coin) {
                sum += makeChange(coins, balance - coins[i], coins[i]);
            }
        }

        memo.put(key, sum);

        return sum;
    }

    public static void main(String[] args) throws IOException {
        try (InputStream inStream = new FileInputStream(
                new File("src/main/resources/br/com/pedront/hackerrank/crackingthecodinginterview"
                        + "/dp/TestCase2"))) {
            Scanner in = new Scanner(inStream);
            int n = in.nextInt();
            int m = in.nextInt();
            int coins[] = new int[m];
            for (int coins_i = 0; coins_i < m; coins_i++) {
                coins[coins_i] = in.nextInt();
            }
            System.out.println(makeChange(coins, n));
        }
    }
}
