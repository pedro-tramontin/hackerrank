package br.com.pedront.hackerrank.crackingthecodinginterview.hashtables;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author pnakano
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 02/01/18 13:45
 */
public class RansomNote {

    public static void solve(String[] magazine, String[] ransom) {
        HashMap<String, Integer> magazineSet = new HashMap<>();
        for (String magazineWord : magazine) {
            Integer count = magazineSet.get(magazineWord);
            if (count == null) {
                count = 0;
            }

            count++;
            magazineSet.put(magazineWord, count);
        }

        for (String ransomWord : ransom) {
            Integer count = magazineSet.get(ransomWord);
            if (count == null || count == 0) {
                System.out.println("No");

                return;
            } else {
                count--;
                magazineSet.put(ransomWord, count);
            }
        }

        System.out.println("Yes");
    }

    public static void main(String[] args) throws IOException {
        try (InputStream inStream = new FileInputStream(
                new File("src/main/resources/br/com/pedront/hackerrank/crackingthecodinginterview"
                        + "/hashtables/TestCase13"))) {

            Scanner in = new Scanner(inStream);
            int m = in.nextInt();
            int n = in.nextInt();
            String magazine[] = new String[m];
            for (int magazine_i = 0; magazine_i < m; magazine_i++) {
                magazine[magazine_i] = in.next();
            }
            String ransom[] = new String[n];
            for (int ransom_i = 0; ransom_i < n; ransom_i++) {
                ransom[ransom_i] = in.next();
            }

            solve(magazine, ransom);
        }

        // String magazine[] = { "give", "me", "one", "grand", "today", "night" };
        // String ransom[] = { "give", "one", "grand", "today" };

        // String magazine[] = { "two", "times", "three", "is", "not", "four" };
        // String ransom[] = { "two", "times", "two", "is", "four" };

        // solve(magazine, ransom);
    }
}
