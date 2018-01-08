package br.com.pedront.hackerrank.crackingthecodinginterview.trees;

/**
 * @author pnakano
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 02/01/18 18:23
 */
public class IsThisABinarySearchTree {

    enum OP {
        LESS, MORE
    }

    boolean checkBST(Node root) {
        if (root == null)
            return false;

        return checkNode(root.left, root.data, -1) && checkNode(root.right, Integer.MAX_VALUE, root.data);
    }

    private boolean checkNode(final Node node, final int lessThanValue, final int moreThanValue) {
        if (node == null) {
            return true;
        }

        if (node.data >= lessThanValue) {
            return false;
        } else if (node.data <= moreThanValue) {
            return false;
        }

        return checkNode(node.left, node.data, moreThanValue) && checkNode(node.right, lessThanValue, node.data);
    }

    public static void main(String[] args) {

    }

    static class Node {

        int data;

        Node left;

        Node right;
    }
}
