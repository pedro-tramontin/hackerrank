package br.com.pedront.hackerrank.crackingthecodinginterview.tries;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author pnakano
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 04/01/18 12:26
 */
public class Contacts {

    static class Node {
        char data;
        boolean end;
        int wordsCount;
        Map<Character, Node> children;

        Node() {
            data = '*';
            end = true;
            wordsCount = 0;
            children = new HashMap<>();
        }

        Node(char ch) {
            data = ch;
            end = true;
            wordsCount = 0;
            children = new HashMap<>();
        }

        boolean hasChild(Character ch) {
            return children.get(ch) != null;
        }

        Node addChild(Character ch) {
            if (end) {
                end = false;
            }

            Node node = new Node(ch);

            children.put(ch, node);

            return node;
        }

        Node getChild(Character ch) {
            return children.get(ch);
        }

        int childrenCount() {
            return children.size();
        }

        Collection<Node> getChildren() {
            return children.values();
        }
    }

    static Node root = new Node();

    static void add(String name) {

        Node node = root;

        for (int i = 0; i < name.length(); i++) {
            Node child = node.getChild(name.charAt(i));
            if (child == null) {
                child = node.addChild(name.charAt(i));
            }
            node.wordsCount++;

            node = child;
        }

        node.addChild('*');
        node.wordsCount++;
    }

    static int find(String partial) {

        Node node = root;

        for (int i = 0; i < partial.length(); i++) {
            Node child = node.getChild(partial.charAt(i));
            if (child == null) {
                return 0;
            }

            node = child;
        }

        return node.wordsCount;
    }

    public static void main(String[] args) throws IOException {
        try (InputStream inStream = new FileInputStream(
                new File("src/main/resources/br/com/pedront/hackerrank/crackingthecodinginterview"
                        + "/tries/TestCase1"))) {
            Scanner in = new Scanner(inStream);
            int n = in.nextInt();
            for (int a0 = 0; a0 < n; a0++) {
                String op = in.next();
                String contact = in.next();

                if ("add".equals(op)) {
                    add(contact);
                } else if ("find".equals(op)) {
                    System.out.println(find(contact));
                }
            }
        }
    }
}
