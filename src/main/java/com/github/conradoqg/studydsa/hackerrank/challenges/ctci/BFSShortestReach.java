package com.github.conradoqg.studydsa.hackerrank.challenges.ctci;

import java.util.LinkedList;
import java.util.Scanner;

public class BFSShortestReach {
    public static class Node {
        int id;
        int distance = -1;
        LinkedList<Node> connectedNodes = new LinkedList<Node>();

        public Node(int id) {
            this.id = id;
        }

        public void addEdge(Node otherNode) {
            connectedNodes.add(otherNode);
        }
    }

    public static class Graph {
        Node[] nodes = null;

        public Graph(int size) {
            nodes = new Node[size];

            for (int i = 0; i < nodes.length; i++) {
                nodes[i] = new Node(i);
            }
        }

        public void addEdge(int first, int second) {
            Node firstNode = nodes[first];
            Node secondNode = nodes[second];

            firstNode.addEdge(secondNode);
            secondNode.addEdge(firstNode);
        }

        public int[] shortestReach(int startId) { // 0 indexed
            Node baseNode = nodes[startId];
            int[] distances = new int[nodes.length];

            for (int nextId = 0; nextId < nodes.length; nextId++) {
                if (nextId == startId)
                    continue;

                int distance = bfsFindDistance(baseNode, nodes[nextId]);
                distances[nextId] = (distance == -1) ? -1 : (6 * distance);
            }

            return distances;
        }

        public int bfsFindDistance(Node source, Node target) {
            LinkedList<Node> nextToVisit = new LinkedList<Node>();            
            nextToVisit.add(source);
            source.distance = 0;

            while (!nextToVisit.isEmpty()) {
                Node nextNode = nextToVisit.remove();               

                for (Node childNode : nextNode.connectedNodes) {
                    if (childNode.distance == -1) {                    
                        childNode.distance = nextNode.distance + 1;
                        nextToVisit.add(childNode);
                    }                    
                }
            }
            
            return target.distance;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
