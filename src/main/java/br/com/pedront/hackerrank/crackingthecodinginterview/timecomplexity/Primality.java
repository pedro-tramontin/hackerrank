package br.com.pedront.hackerrank.crackingthecodinginterview.timecomplexity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author pnakano
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 09/01/18 17:34
 */
public class Primality {

    static List<Boolean> sieve;

    static List<Integer> primes;

    static void initSieve(int cacheSize) {
        sieve = IntStream
                .rangeClosed(0, cacheSize)
                .mapToObj(i -> Boolean.TRUE)
                .collect(Collectors.toList());

        sieve.set(0, Boolean.FALSE);
        sieve.set(1, Boolean.FALSE);
    }

    static boolean checkPrime(int number) {
        if (number == 2) {
            return true;
        }

        if (number % 2 == 0) {
            return false;
        }

        calcSieve();

        return sieve.get(number);
    }

    private static void calcSieve() {
        int prime = 2;

        while (prime < sieve.size()) {
            crossOutMultiplesOf(prime);

            prime = findNextPrime(prime);
            if (prime == -1)
                return;
        }
    }

    private static void crossOutMultiplesOf(final int prime) {
        for (int i = prime * 2; i < sieve.size(); i += prime) {
            sieve.set(i, Boolean.FALSE);
        }
    }

    private static int findNextPrime(final int currentPrime) {
        int next = currentPrime + 1;
        if (currentPrime % 2 == 1) {
            next++;
        }

        while (next < sieve.size()) {
            if (sieve.get(next)) {
                return next;
            }

            next += 2;
        }

        return -1;
    }

    static boolean isPrime(int number) {
        int sqrt = (int) Math.sqrt(number);

        if (number < 2) {
            return false;
        }

        if (number == 2) {
            return true;
        }

        if (number % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= sqrt; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        // ArrayList<Integer> ints = new ArrayList<>();
        // int max = 0;

        try (InputStream inStream = new FileInputStream(
                new File("src/main/resources/br/com/pedront/hackerrank/crackingthecodinginterview"
                        + "/timecomplexity/TestCase9"))) {
            Scanner in = new Scanner(inStream);
            int p = in.nextInt();
            for (int a0 = 0; a0 < p; a0++) {
                int n = in.nextInt();

                // if (n > max) {
                // max = n;
                // }
                //
                // ints.add(n);

                System.out.println(isPrime(n) ? "Prime" : "Not prime");
            }

            // initSieve(max);
            // for (int i = 0; i < ints.size(); i++) {
            // System.out.println(checkPrime(ints.get(i)) ? "Prime" : "Not prime");
            // }
        }
    }
}
