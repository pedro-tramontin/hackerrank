package br.com.pedront.hackerrank.algorithm.recursion;

import java.math.BigInteger;

/**
 * @author pnakano
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 05/01/18 11:07
 */
public class RecursiveDigitSum {

    static StringBuilder buildP(String n, int k) {
        BigInteger bigInt = new BigInteger(n);

        return new StringBuilder(bigInt.multiply(BigInteger.valueOf(k)).toString());
    }

    static int digitSum(String n, int k) {
        StringBuilder p = buildP(n, k);

        return calcSuperDigit(p);
    }

    static int calcSuperDigit(StringBuilder p) {
        if (p.length() == 1) {
            return Integer.parseInt(p.toString());
        }

        int sum = calcSuperDigit(p, 0);

        return calcSuperDigit(new StringBuilder(Integer.toString(sum)));
    }

    static int calcSuperDigit(StringBuilder p, int index) {
        if (index == p.length()) {
            return 0;
        }

        return (p.charAt(index) - '0') + calcSuperDigit(p, index + 1);
    }

    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        // String n = in.next();
        // int k = in.nextInt();

        String n = "3546630947312051453014172159647935984478824945973141333062252613718025688716704470547449723886626736";
        int k = 100000;

        // String n = "148";
        // int k = 3;

        int result = digitSum(n, k);
        System.out.println(result);
    }
}
