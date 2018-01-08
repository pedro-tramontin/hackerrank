package br.com.pedront.hackerrank.crackingthecodinginterview.queues;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author pnakano
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 02/01/18 16:12
 */
public class ATaleOfTwoStacks {

    public static class MyQueue<T> {

        Stack<T> stackNewestOnTop = new Stack<T>();

        Stack<T> stackOldestOnTop = new Stack<T>();

        T oldest = null;

        public void enqueue(T value) { // Push onto newest stack
            if (oldest == null && stackNewestOnTop.isEmpty() && stackOldestOnTop.isEmpty()) {
                oldest = value;
            } else {
                oldestToNewestIfNeeded();

                stackNewestOnTop.push(value);
            }
        }

        public T peek() {
            if (oldest != null) {
                return oldest;
            } else {
                newestToOldestIfNeeded();

                oldest = stackOldestOnTop.pop();

                return oldest;
            }
        }

        public T dequeue() {
            if (oldest != null) {
                T retValue = oldest;
                oldest = null;

                return retValue;
            } else {
                newestToOldestIfNeeded();

                T retValue = stackOldestOnTop.pop();

                oldest = stackOldestOnTop.pop();

                return retValue;
            }
        }

        private void oldestToNewestIfNeeded() {
            // if (!stackOldestOnTop.isEmpty())
            // System.out.println("oldest to newest");

            while (!stackOldestOnTop.isEmpty()) {
                stackNewestOnTop.push(stackOldestOnTop.pop());
            }
        }

        private void newestToOldestIfNeeded() {
            // if (!stackNewestOnTop.isEmpty())
            // System.out.println("newest to oldest");

            while (!stackNewestOnTop.isEmpty()) {
                stackOldestOnTop.push(stackNewestOnTop.pop());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        int[] opCache = new int[20];
        int index = 0;

        try (InputStream inStream = new FileInputStream(
                new File("src/main/resources/br/com/pedront/hackerrank/crackingthecodinginterview"
                        + "/queues/TestCase13"))) {
            Scanner scan = new Scanner(inStream);
            int n = scan.nextInt();

            for (int i = 0; i < n; i++) {
                int operation = scan.nextInt();
                if (operation == 1) { // enqueue
                    queue.enqueue(scan.nextInt());
                } else if (operation == 2) { // dequeue
                    // queue.dequeue();
                    opCache[index++] = operation;
                } else if (operation == 3) { // print/peek
                    // System.out.println(queue.peek());
                    opCache[index++] = operation;
                }

                if (index == 20) {
                    for (int idx = 0; idx < 20; idx++) {
                        if (opCache[idx] == 2) {
                            queue.dequeue();
                        } else if (opCache[idx] == 3) {
                            System.out.println(queue.peek());
                        }
                    }

                    index = 0;
                }
            }
            scan.close();
        }
    }
}
