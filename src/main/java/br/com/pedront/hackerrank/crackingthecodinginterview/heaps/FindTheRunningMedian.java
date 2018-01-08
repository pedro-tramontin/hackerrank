package br.com.pedront.hackerrank.crackingthecodinginterview.heaps;

import java.util.ArrayList;

/**
 * @author pnakano
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 02/01/18 18:49
 */
public class FindTheRunningMedian {

    enum TYPE {
        MIN, MAX
    }

    static class Heap {
        private ArrayList<Integer> buffer = new ArrayList<>();

        private TYPE type;

        Heap(TYPE type) {
            this.type = type;
        }

        void insert(int value) {
            buffer.add(value);
            heapifyUp();
        }

        int remove() {
            int item = buffer.get(0);

            int lastItem = buffer.remove(buffer.size() - 1);
            buffer.set(0, lastItem);

            heapifyDown();

            return item;
        }

        int peek() {
            return buffer.get(0);
        }

        int size() {
            return buffer.size();
        }

        private void heapifyUp() {
            int index = buffer.size() - 1;

            while (hasParent(index) && isWrongOrder(getParentIndex(index), index)) {
                swap(getParentIndex(index), index);
                index = getParentIndex(index);
            }
        }

        private void heapifyDown() {
            int index = 0;
            boolean isAdjusting = true;

            while (hasLeft(index) && isAdjusting) {
                int smallestIndex = leftIndex(index);
                if (hasRight(index) && isWrongOrder(leftIndex(index), rightIndex(index))) {
                    smallestIndex = rightIndex(index);
                }

                if (isWrongOrder(index, smallestIndex)) {
                    swap(index, smallestIndex);
                    index = smallestIndex;
                } else {
                    isAdjusting = false;
                }
            }
        }

        private void swap(final int parent, final int index) {
            int value = buffer.get(parent);
            buffer.set(parent, buffer.get(index));
            buffer.set(index, value);
        }

        private boolean isWrongOrder(int parent, int index) {
            if (type == TYPE.MIN) {
                return buffer.get(parent) > buffer.get(index);
            } else if (type == TYPE.MAX) {
                return buffer.get(parent) < buffer.get(index);
            }

            throw new RuntimeException("Invalid Type");
        }

        private boolean hasLeft(int index) {
            return leftIndex(index) < buffer.size();
        }

        private boolean hasRight(int index) {
            return rightIndex(index) < buffer.size();
        }

        private boolean hasParent(int index) {
            return getParentIndex(index) >= 0;
        }

        private int leftIndex(int index) {
            return index * 2 + 1;
        }

        private int rightIndex(int index) {
            return index * 2 + 2;
        }

        private int getParentIndex(int index) {
            if (index % 2 == 0) {
                return (index - 2) / 2;
            } else {
                return (index - 1) / 2;
            }
        }
    }

    static class RunningMedian {
        private Heap min = new Heap(TYPE.MIN);
        private Heap max = new Heap(TYPE.MAX);

        double median = 0.0;

        void insert(int value) {
            if (value <= median) {
                max.insert(value);
            } else {
                min.insert(value);
            }

            if (Math.abs(min.size() - max.size()) > 1) {
                if (min.size() > max.size()) {
                    max.insert(min.remove());
                } else {
                    min.insert(max.remove());
                }
            }

            if (min.size() == max.size()) {
                median = (min.peek() + max.peek()) / 2.0;
            } else {
                if (min.size() > max.size()) {
                    median = min.peek();
                } else {
                    median = max.peek();
                }
            }
        }
    }

    public static void main(String[] args) {
        RunningMedian median = new RunningMedian();
        // Scanner in = new Scanner(System.in);
        // int n = in.nextInt();
        int[] arr = new int[] { 12, 4, 5, 3, 8, 7 };
        for (int i = 0; i < arr.length; i++) {
            median.insert(arr[i]);
            System.out.println(median.median);
        }
    }

    // public static void main(String[] args) {
    // Heap heap = new Heap(TYPE.MIN);
    // heap.insert(15);
    // heap.insert(5);
    // heap.insert(10);
    // heap.insert(90);
    // System.out.println(heap.remove());
    // }
}
