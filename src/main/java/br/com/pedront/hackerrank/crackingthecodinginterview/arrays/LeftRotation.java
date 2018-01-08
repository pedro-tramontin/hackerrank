package br.com.pedront.hackerrank.crackingthecodinginterview.arrays;

import java.util.Scanner;

/**
 * @author pnakano
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 22/12/17 16:28
 */
public class LeftRotation {

    private static void leftRotate(int a[], int d) {
        if (d == a.length) {
            printArray(a);
        }

        // n = 5
        // d = 2
        // a = [ 1 2 3 4 5 ]
        // newA = [ 3 4 5 1 2 ]

        // newA[0] = a[d]
        // newA[1] = a[d + 1]
        // newA[2] = a[d + 2]
        // ...
        // newA[n - d] = a[n]

        // newA[n - d + 1] = a[0]
        // newA[n - d + 2] = a[1]
        // newA[n - d + 3] = a[2]
        // ...
        // newA[n - d + d] = a[d - 1]

        int newA[] = new int[a.length];
        for (int i = 0, j = d; i < a.length; i++, j++) {
            if (j == a.length) {
                j = 0;
            }
            newA[i] = a[j];
        }

        printArray(newA);
    }

    private static void printArray(int array[]) {
        System.out.print(array[0]);

        for (int i = 1; i < array.length; i++) {
            System.out.print(String.format(" %d", array[i]));
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
    }
}
