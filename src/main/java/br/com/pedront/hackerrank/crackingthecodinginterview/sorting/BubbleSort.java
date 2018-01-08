package br.com.pedront.hackerrank.crackingthecodinginterview.sorting;

/**
 * @author pnakano
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 04/01/18 14:20
 */
public class BubbleSort {

    static int swaps;

    static void bubbleSort(int[] a) {

        swaps = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    static void swap(int[] a, int i, int j) {
        swaps++;

        int value = a[i];
        a[i] = a[j];
        a[j] = value;
    }

    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        // int n = in.nextInt();
        // int a[] = new int[n];
        // for (int a_i = 0; a_i < n; a_i++) {
        // a[a_i] = in.nextInt();
        // }

        int[] a = { 3, 2, 1 };

        bubbleSort(a);

        System.out.println(String.format("Array is sorted in %d swaps.", swaps));
        System.out.println(String.format("First Element: %d", a[0]));
        System.out.println(String.format("Last Element: %d", a[a.length - 1]));
    }
}
