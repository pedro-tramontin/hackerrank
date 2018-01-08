package br.com.pedront.hackerrank.crackingthecodinginterview.linkedlists;

import java.util.HashSet;

/**
 * @author pnakano
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 02/01/18 14:35
 */
public class DetectACycle {
    public static boolean hasCycle(Node head) {
        HashSet<Node> nodes = new HashSet<>();

        Node node = head;

        while (node != null) {
            if (nodes.contains(node)) {
                return true;
            }

            nodes.add(node);

            node = node.next;
        }

        return false;
    }

    public static void main(String[] args) {
        Node three = new Node();
        three.data = 3;

        Node two = new Node();
        two.data = 2;
        two.next = three;

        three.next = two;

        Node head = new Node();
        head.data = 1;
        head.next = two;

        System.out.println(hasCycle(head));
    }

    static class Node {
        int data;
        Node next;
    }
}
