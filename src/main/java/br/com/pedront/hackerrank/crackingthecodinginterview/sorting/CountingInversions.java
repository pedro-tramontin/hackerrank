package br.com.pedront.hackerrank.crackingthecodinginterview.sorting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @author pnakano
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 08/01/18 10:05
 */
public class CountingInversions {

    static long bubblesort(int[] arr) {
        boolean isSorted = false;

        long count = 0;

        int lastPosition = arr.length - 1;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < lastPosition; i++) {
                if (arr[i] > arr[i + 1]) {
                    count++;
                    isSorted = false;
                    swap(arr, i, i + 1);
                }
            }
            lastPosition--;
        }

        return count;
    }

    static void swap(int[] arr, int i, int j) {
        int value = arr[i];
        arr[i] = arr[j];
        arr[j] = value;
    }

    static long mergesort(int[] arr) {
        int[] helper = new int[arr.length];
        return mergesort(arr, helper, 0, arr.length - 1);
    }

    static long mergesort(int[] arr, int[] helper, int left, int right) {
        if (left >= right) {
            return 0;
        }

        long count = 0;

        int middle = (left + right) / 2;
        count += mergesort(arr, helper, left, middle);
        count += mergesort(arr, helper, middle + 1, right);

        return count + merge(arr, helper, left, middle, right);
    }

    static long merge(int[] arr, int[] helper, int leftStart, int middle, int rightEnd) {
        long count = 0;

        int leftEnd = middle;
        int rightStart = middle + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (arr[left] <= arr[right]) {
                helper[index] = arr[left];
                left++;
            } else {
                helper[index] = arr[right];

                if (right != index) {
                    count += Math.abs(right - index);
                }

                right++;
            }
            index++;
        }

        System.arraycopy(arr, left, helper, index, leftEnd - left + 1);
        System.arraycopy(arr, right, helper, index, rightEnd - right + 1);
        System.arraycopy(helper, leftStart, arr, leftStart, size);

        return count;
    }

    static long countInversions(int[] arr) {
        return mergesort(arr);
    }

    public static void main(String[] args) throws IOException {
        try (InputStream inStream = new FileInputStream(
                new File("src/main/resources/br/com/pedront/hackerrank/crackingthecodinginterview"
                        + "/sorting/TestCase7"))) {
            Scanner in = new Scanner(inStream);
            int t = in.nextInt();
            for (int a0 = 0; a0 < t; a0++) {
                int n = in.nextInt();
                int[] arr = new int[n];
                for (int arr_i = 0; arr_i < n; arr_i++) {
                    arr[arr_i] = in.nextInt();
                }
                long result = countInversions(arr);
                System.out.println(result);
            }
            in.close();
        }

        // int[] arr = { 4, 3, 2, 1 };
        // System.out.println(countInversions(arr));
    }
}
