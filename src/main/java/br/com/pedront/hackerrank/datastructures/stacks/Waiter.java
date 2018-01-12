package br.com.pedront.hackerrank.datastructures.stacks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author pnakano
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 12/01/18 16:55
 */
public class Waiter {
    static List<Integer> primes = new ArrayList<Integer>() {
        {
            add(2);
        }
    };

    static int ithPrime(int ith) {
        boolean found = false;

        int next = primes.get(primes.size() - 1);
        if (next % 2 == 1) {
            next++;
        }

        while (!found) {
            next++;
            boolean isPrime = true;

            int sqrt = (int) Math.sqrt(next);

            for (int i = 0; i < primes.size(); i++) {
                int prime = primes.get(i);

                if (prime > sqrt) {
                    break;
                }

                if (next % prime == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                int start = primes.get(primes.size() - 1) + 1;
                if (start % 2 == 0) {
                    start++;
                }

                for (int i = start; i <= sqrt; i += 2) {
                    if (next % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            if (isPrime) {
                found = true;

                primes.add(next);
            }
        }

        return primes.get(ith);
    }

    static Stack<Integer> getStack(List<Stack<Integer>> list, int index) {
        Stack<Integer> pile = list.get(index);
        if (pile == null) {
            pile = new Stack<>();
            list.add(pile);
        }

        return pile;
    }

    public static void main(String[] args) throws IOException {
        try (InputStream inStream = new FileInputStream(
                new File("src/main/resources/br/com/pedront/hackerrank/datastructures"
                        + "/stacks/TestCase6"))) {
            Scanner in = new Scanner(inStream);

            int n = in.nextInt();
            int q = in.nextInt();

            Stack<Integer> current = new Stack<Integer>();
            Stack<Integer> buffer = new Stack<Integer>();

            Stack<Integer>[] b = new Stack[q];

            for (int number_i = 0; number_i < n; number_i++) {
                current.push(in.nextInt());
            }

            for (int i = 0; i < q; i++) {
                Stack<Integer> bPile = new Stack<>();

                while (!current.isEmpty()) {
                    int prime = ithPrime(i);
                    int val = current.pop();

                    if (val % prime == 0) {
                        bPile.push(val);
                    } else {
                        buffer.push(val);
                    }
                }

                b[i] = bPile;

                Stack<Integer> aux = current;
                current = buffer;
                buffer = aux;
            }

            for (int i = 0; i < q; i++) {
                Stack<Integer> bPile = b[i];
                while (!bPile.isEmpty()) {
                    System.out.println(bPile.pop());
                }
            }

            while (!current.isEmpty()) {
                System.out.println(current.pop());
            }
        }
    }
}
