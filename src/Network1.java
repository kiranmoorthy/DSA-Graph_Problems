/*
You are working as a network administrator for a company. The company has several computers (nodes)
connected via network cables (edges). The connections are bidirectional, and not all computers are directly
connected to each other.

Sometimes, when a computer sends a broadcast message, it should reach all other computers in the network
in the shortest number of hops (i.e., fewest intermediate computers). You are tasked to simulate this broadcast
operation using Breadth-First Search (BFS).

Your goal is to write a function that:

Traverses the network from a given source computer

Returns the order in which the computers receive the broadcast message

Assumes each edge takes equal time to traverse

Test Case 1 – Small Office Network1

Computers: [A, B, C, D]

Connections:

A - B
A - C
B - D

Start: A

Expected Output:

Broadcast Order: A, B, C, D

Test Case 2 – Medium Network1

Computers: [P, Q, R, S, T, U]

Connections:

P - Q
P - R
Q - S
R - T
T - U

Start: P

Output :

Broadcast Order: P, Q, R, S, T, U

*/

import java.util.*;

public class Network1 {

    public static void bfsBroadcast(Map<Character, List<Character>> graph, char startNode) {
        Queue<Character> queue = new LinkedList<>();
        Set<Character> visited = new HashSet<>();

        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {

            char currentNode = queue.poll();
            System.out.print(currentNode+" ");

            List<Character> neighbors = graph.get(currentNode);
            if (neighbors != null) {
                for (char neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
        System.out.println();
    }


    private static void addEdge(Map<Character, List<Character>> graph, char u, char v) {
        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    public static void main(String[] args) {

        Map<Character, List<Character>> network1 = new HashMap<>();
        addEdge(network1, 'A', 'B');
        addEdge(network1, 'A', 'C');
        addEdge(network1, 'B', 'D');

        char startNode1 = 'A';
        bfsBroadcast(network1, startNode1);

        Map<Character, List<Character>> network2 = new HashMap<>();
        addEdge(network2, 'P', 'Q');
        addEdge(network2, 'P', 'R');
        addEdge(network2, 'Q', 'S');
        addEdge(network2, 'R', 'T');
        addEdge(network2, 'T', 'U');

        char startNode2 = 'P';
        bfsBroadcast(network2, startNode2);

    }
}
