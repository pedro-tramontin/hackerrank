package br.com.pedront.hackerrank.algorithm.warmup;

/**
 * @author pnakano
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 05/01/18 10:56
 */
public class DiagonalDifference {
    static int diagonalDifference(int[][] a) {
        int n = a.length;

        if (n != a[0].length) {
            return -1;
        }

        int d1 = 0;
        int d2 = 0;
        for (int i = 0; i < n; i++) {
            d1 += a[i][i];
            d2 += a[n - i - 1][i];
        }

        return Math.abs(d1 - d2);
    }

    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        // int n = in.nextInt();
        // int[][] a = new int[n][n];
        // for (int a_i = 0; a_i < n; a_i++) {
        // for (int a_j = 0; a_j < n; a_j++) {
        // a[a_i][a_j] = in.nextInt();
        // }
        // }

        int[][] a = {
                { 11, 2, 4 },
                { 4, 5, 6 },
                { 10, 8, -12 }
        };

        int result = diagonalDifference(a);
        System.out.println(result);
    }
}
