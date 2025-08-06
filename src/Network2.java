/*You are working as a network engineer responsible for ensuring that all parts of a company's internal computer network are properly connected.

The network consists of several computers (nodes) connected by network cables (edges with weights representing latency). However, due to missing or faulty cables, some computers might be disconnected from others, forming separate components.

You are tasked to:

Apply Prim’s Algorithm starting from any computer in a component.

Continue running Prim's on unvisited components to ensure all parts are checked.

Detect and report all disconnected components in the network.

For each connected component, return:

Its Minimum Spanning Tree (MST)

The total cost (latency)

Input Format:
List of computers (nodes): ["A", "B", "C", "D", "E", "F"]

List of weighted connections: [("A", "B", 3), ("A", "C", 1), ...]

Graph is undirected and weighted

 Output Format:
For each disconnected component:

List of edges in MST with weights

Total cost of that MST

Test Case 1 – Fully Connected Network

Computers: [A, B, C, D]
Connections:
A - B (1)
A - C (2)
B - C (2)
C - D (3)

Expected Output:

Component 1:
MST Edges: A-B(1), A-C(2), C-D(3)
Total Cost: 6


 Test Case 2 – Disconnected Network

Computers: [P, Q, R, S, T, U]
Connections:
P - Q (4)
Q - R (1)
S - T (3)
T - U (2)

Component 1:
MST Edges: Q-R(1), P-Q(4)
Total Cost: 5

Component 2:
MST Edges: T-U(2), S-T(3)
Total Cost: 5
*/

import java.util.*;
class edge{
    char v;
    int w;

    public edge(char v, int w) {
        this.v = v;
        this.w = w;
    }
}
class pair{
    char v;
    char p;
    int w;

    public pair(char v, char p, int w) {
        this.v = v;
        this.p = p;
        this.w = w;
    }
}
public class Network2 {
    public void prims(){
        Queue<pair> pq=new PriorityQueue<>(Comparator.comparingInt(e->e.w));
        pq.add(new pair('A','0',0));
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        Map<Character,List<edge>> map=new HashMap<>();
        String l1;
        while( in.hasNextLine() && !(l1 =in.nextLine()).isEmpty()){

            char[]line= l1.toCharArray();

            if(!map.containsKey(line[0])){
                map.put(line[0],new ArrayList<>());
            }
            map.get(line[0]).add(new edge(line[2],line[4]-'0'));
        }

        Set<Character> visited = new HashSet<>();

    }
}
