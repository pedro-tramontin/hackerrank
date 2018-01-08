package br.com.pedront.hackerrank.crackingthecodinginterview.strings;

/**
 * @author pnakano
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 02/01/18 10:11
 */
public class MakingAnagrams {
    public static int numberNeeded(String first, String second) {
        int[] count = new int['z' - 'a' + 1];

        for (int i = 0; i < first.length(); i++) {
            count[first.charAt(i) - 'a']++;
        }

        for (int i = 0; i < second.length(); i++) {
            count[second.charAt(i) - 'a']--;
        }

        int needed = 0;

        for (int i = 0; i < count.length; i++) {

            int invert = 1;
            if (count[i] < 0) {
                invert = -1;
            }

            needed += count[i] * invert;
        }

        return needed;
    }

    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        // String a = in.next();
        // String b = in.next();

        String a = "fcrxzwscanmligyxyvym";
        String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";

        System.out.println(numberNeeded(a, b));
    }
}
