package br.com.pedront.hackerrank.crackingthecodinginterview.bitmanipulation;

import java.util.Scanner;

/**
 * @author pnakano
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 10/01/18 18:28
 */
public class LonelyInteger {
    public static int lonelyInteger(int[] a) {
        long[] indexes = new long[] { 0L, 0L };

        for (int i = 0; i < a.length; i++) {
            int index = 0;
            int val = a[i];
            if (val > 50) {
                val -= 50;
                index = 1;
            }

            if (isSet(indexes[index], val)) {
                indexes[index] = clearBit(indexes[index], val);
            } else {
                indexes[index] = setBit(indexes[index], val);
            }
        }

        if (indexes[0] > 0) {
            return getBitSetPosition(indexes[0]);
        } else {
            return getBitSetPosition(indexes[1]) + 50;
        }
    }

    static boolean isSet(long index, int bit) {
        return (index & (0x01L << bit)) > 0;
    }

    static long setBit(long index, int bit) {
        return index | (0x01L << bit);
    }

    static long clearBit(long index, int bit) {
        return index & ~(0x01L << bit);
    }

    static int getBitSetPosition(long index) {
        for (int i = 0; i <= 50; i++) {
            if (isSet(index, i)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }

        System.out.println(lonelyInteger(a));
    }
}
