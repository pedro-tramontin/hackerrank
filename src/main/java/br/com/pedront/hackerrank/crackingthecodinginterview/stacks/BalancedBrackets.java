package br.com.pedront.hackerrank.crackingthecodinginterview.stacks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author pnakano
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 02/01/18 14:54
 */
public class BalancedBrackets {
    public static boolean isBalanced(String expression) {
        Deque<Character> brackets = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (isOpenBracket(ch)) {
                brackets.push(ch);
            } else {
                if (brackets.isEmpty() || !matchCloseBracket(brackets.peek(), ch)) {
                    return false;
                }

                brackets.pop();
            }
        }

        if (!brackets.isEmpty()) {
            return false;
        }

        return true;
    }

    static boolean isOpenBracket(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    static boolean matchCloseBracket(char openBracket, char closeBracket) {
        if (openBracket == '(' && closeBracket == ')') {
            return true;
        }

        if (openBracket == '[' && closeBracket == ']') {
            return true;
        }

        if (openBracket == '{' && closeBracket == '}') {
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        try (InputStream inStream = new FileInputStream(
                new File("src/main/resources/br/com/pedront/hackerrank/crackingthecodinginterview"
                        + "/stacks/TestCase4"))) {

            Scanner in = new Scanner(inStream);
            int t = in.nextInt();
            for (int a0 = 0; a0 < t; a0++) {
                String expression = in.next();
                System.out.println((isBalanced(expression)) ? "YES" : "NO");
            }
        }
    }
}
