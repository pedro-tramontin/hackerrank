package br.com.pedront.hackerrank.crackingthecodinginterview.sorting;

/**
 * @author pnakano
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 05/01/18 10:28
 */
public class MergeSort {

    static void mergesort(final Player[] array) {
        Player[] helper = new Player[array.length];
        mergesort(array, helper, 0, array.length - 1);
    }

    private static void mergesort(final Player[] array, Player[] helper, final int left, final int right) {
        if (left >= right) {
            return;
        }

        int med = (left + right) / 2;
        mergesort(array, helper, left, med);
        mergesort(array, helper, med + 1, right);
        merge(array, helper, left, med, right);
    }

    private static void merge(final Player[] array, Player[] helper, final int leftStart, final int med,
            final int rightEnd) {

        int leftEnd = med;
        int rightStart = med + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (compare(array[left], array[right]) <= 0) {
                helper[index] = array[left];
                left++;
            } else {
                helper[index] = array[right];
                right++;
            }
            index++;
        }

        System.arraycopy(array, left, helper, index, leftEnd - left + 1);
        System.arraycopy(array, right, helper, index, rightEnd - right + 1);
        System.arraycopy(helper, leftStart, array, leftStart, size);
    }

    private static int compare(Player p1, Player p2) {
        int compareResult = p2.score - p1.score;
        if (compareResult == 0) {
            compareResult = p1.name.compareTo(p2.name);
        }

        return compareResult;
    }

    static class Player {
        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            final StringBuilder builder = new StringBuilder()//
                    .append("Player [")//
                    .append("name=\"")//
                    .append(name).append("\"")//
                    .append(",score=")//
                    .append(score)//
                    .append("]");
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        Player[] players = {
                new Player("heraldo", 50),
                new Player("aakansha", 75),
                new Player("david", 100),
                new Player("amy", 100),
                new Player("aleksa", 150)
        };

        mergesort(players);

        for (Player player : players) {
            System.out.println(player);
        }
    }
}
