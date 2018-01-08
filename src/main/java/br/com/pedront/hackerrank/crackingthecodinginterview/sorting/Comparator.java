package br.com.pedront.hackerrank.crackingthecodinginterview.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author pnakano
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 04/01/18 15:54
 */
public class Comparator {

    static class Checker implements java.util.Comparator<Player> {

        @Override
        public int compare(final Player a, final Player b) {
            int compareResult = Integer.compare(b.score, a.score);
            if (compareResult == 0) {
                return a.name.compareTo(b.name);
            }

            return compareResult;
        }
    }

    static class Player {
        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for (int i = 0; i < n; i++) {
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for (int i = 0; i < player.length; i++) {
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
