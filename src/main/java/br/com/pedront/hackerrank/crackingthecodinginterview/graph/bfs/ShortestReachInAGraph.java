package br.com.pedront.hackerrank.crackingthecodinginterview.graph.bfs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author pnakano
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 09/01/18 16:08
 */
public class ShortestReachInAGraph {

    static class NodeLevel {
        Node node;
        int level;

        public NodeLevel(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    static class Node {
        int data;
        ArrayList<Node> adjacents;

        public Node(int data) {
            this.data = data;
            this.adjacents = new ArrayList<>();
        }

        public void addAdjacent(Node node) {
            adjacents.add(node);
        }
    }

    public static class Graph {

        private ArrayList<Node> nodes;

        public Graph(int size) {
            this.nodes = new ArrayList<>(size);

            initGraphNodes(size);
        }

        public void initGraphNodes(int size) {
            for (int i = 0; i < size; i++) {
                nodes.add(new Node(i));
            }
        }

        public void addEdge(int first, int second) {
            Node node1st = nodes.get(first);
            Node node2nd = nodes.get(second);

            node1st.addAdjacent(node2nd);
            node2nd.addAdjacent(node1st);
        }

        public int[] shortestReach(int startId) { // 0 indexed
            int[] distances = new int[nodes.size()];

            for (int i = 0; i < nodes.size(); i++) {
                if (i == startId) {
                    continue;
                }

                distances[i] = findDistanceFrom(nodes.get(startId), nodes.get(i));
            }

            return distances;
        }

        private int findDistanceFrom(final Node startNode, final Node destNode) {
            ArrayList<NodeLevel> nextNodes = new ArrayList<>();
            HashSet<Node> visited = new HashSet<>();

            nextNodes.add(new NodeLevel(startNode, 0));

            while (!nextNodes.isEmpty()) {
                NodeLevel nodeLevel = nextNodes.remove(0);

                Node node = nodeLevel.node;
                int level = nodeLevel.level;

                for (int i = 0; i < node.adjacents.size(); i++) {
                    Node adjacent = node.adjacents.get(i);

                    if (!visited.contains(adjacent)) {
                        visited.add(adjacent);

                        if (adjacent == destNode) {
                            return (level + 1) * 6;
                        } else {
                            nextNodes.add(new NodeLevel(adjacent, level + 1));
                        }
                    }
                }
            }

            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        try (InputStream inStream = new FileInputStream(
                new File("src/main/resources/br/com/pedront/hackerrank/crackingthecodinginterview"
                        + "/graph/bfs/TestCase0"))) {
            Scanner scanner = new Scanner(inStream);

            int queries = scanner.nextInt();

            for (int t = 0; t < queries; t++) {

                // Create a graph of size n where each edge weight is 6:
                Graph graph = new Graph(scanner.nextInt());
                int m = scanner.nextInt();

                // read and set edges
                for (int i = 0; i < m; i++) {
                    int u = scanner.nextInt() - 1;
                    int v = scanner.nextInt() - 1;

                    // add each edge to the graph
                    graph.addEdge(u, v);
                }

                // Find shortest reach from node s
                int startId = scanner.nextInt() - 1;
                int[] distances = graph.shortestReach(startId);

                for (int i = 0; i < distances.length; i++) {
                    if (i != startId) {
                        System.out.print(distances[i]);
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }

            scanner.close();
        }
    }
}
