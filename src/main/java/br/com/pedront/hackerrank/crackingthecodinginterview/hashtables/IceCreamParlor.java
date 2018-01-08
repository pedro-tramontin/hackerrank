package br.com.pedront.hackerrank.crackingthecodinginterview.hashtables;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pnakano
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 08/01/18 16:41
 */
public class IceCreamParlor {

    static void solve(int[] arr, int money) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < money) {
                Integer diff = money - arr[i];

                Integer index = map.get(diff);
                if (index != null) {
                    printValues(index + 1, i + 1);

                    return;
                } else {
                    map.put(arr[i], i);
                }
            }
        }
    }

    static void printValues(Integer index1, Integer index2) {
        if (index1 < index2) {
            System.out.println(String.format("%d %d", index1, index2));
        } else {
            System.out.println(String.format("%d %d", index2, index1));
        }
    }

    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        // int t = in.nextInt();
        // for (int a0 = 0; a0 < t; a0++) {
        // int money = in.nextInt();
        // int n = in.nextInt();
        // int[] arr = new int[n];
        // for (int arr_i = 0; arr_i < n; arr_i++) {
        // arr[arr_i] = in.nextInt();
        // }
        // solve(arr, money);
        // }
        // in.close();

        solve(new int[] { 1, 4, 5, 3, 2 }, 4);
        solve(new int[] { 2, 2, 4, 3 }, 4);
    }

}
