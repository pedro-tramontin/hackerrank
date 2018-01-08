package br.com.pedront.hackerrank.crackingthecodinginterview.sorting;

/**
 * @author pnakano
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 04/01/18 15:59
 */
public class QuickSort {

    static void quicksort(Player[] array) {
        quicksort(array, 0, array.length - 1);
    }

    static void quicksort(Player[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        Player pivot = array[(left + right) / 2];

        int index = partition(array, left, right, pivot);

        quicksort(array, left, index - 1);
        quicksort(array, index, right);

    }

    private static int partition(final Player[] array, int left, int right, final Player pivot) {
        while (left <= right) {
            while (compare(array[left], pivot) < 0) {
                left++;
            }

            while (compare(array[right], pivot) > 0) {
                right--;
            }

            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    private static void swap(Player[] array, int left, int right) {
        Player player = array[left];
        array[left] = array[right];
        array[right] = player;
    }

    private static int compare(Player p1, Player p2) {
        int compareScore = p2.score - p1.score;
        if (compareScore == 0) {
            return p1.name.compareTo(p2.name);
        }

        return compareScore;
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

        quicksort(players);

        for (Player player : players) {
            System.out.println(player);
        }
    }
}
