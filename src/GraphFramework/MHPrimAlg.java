/* CPCS324 Project Part 1

 Group members: 
    1- Razan Alamri
    2- Khloud Alsofyani
    3- Leen Ba Galaql
    4- Shatha Binmahfouz
 */
package GraphFramework;

import java.util.*;

/* MHPrimAlg: is a subclass of MSTAlgorithm. It implements the polymorphic operation
displayResultingMST(). Make sure it calls the displayInfo() method of the Vertex and Edge
classes.
 */
public class MHPrimAlg extends MSTAlgorithm {
    public MHPrimAlg(Graph graph) {
        super(graph);
        this.MSTResultList = new ArrayList<>();
    }

    @Override
    public void displayResultingMST() {
        int totalCost = 0;
        System.out.println(MSTResultList);
        for (Edge e : MSTResultList) {
            System.out.printf("Office No. %s - Office No. %s : line length: %d\n",
                    e.getSource().getLabel(), e.getTarget().getLabel(), e.getWeight());
            totalCost += e.getWeight();
        }
        System.out.println("The cost of designed phone network: " + totalCost);
    }

    public void computeMST() {
        // Initialize MSTResultList and visited vertices
        MSTResultList = new ArrayList<>();
        boolean[] visited = new boolean[graph.getVerticesNo()];

        // Create a min-heap of edges
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(graph.getEdgeNo(),
                (e1, e2) -> Integer.compare(e1.getWeight(), e2.getWeight()));

        // Find the vertex with label "0"
        Vertex startVertex = graph.vertices.get("O1");
        if (startVertex == null) {
            // The vertex with label "0" is notpresent in the graph
            return;
        }

        // Add the edges incident to the start vertex to the min-heap
        visited[startVertex.hashCode()] = true;
        for (Edge e : startVertex.getAdjList()) {
            if (!visited[e.getTarget().hashCode()]) {
                minHeap.add(e);
            }
        }

        // Repeatedly add the shortest edge to the MST until all vertices are visited
        while (!minHeap.isEmpty()) {
            // Remove the shortest edge from the min-heap
            Edge e = minHeap.poll();

            // Check if the target vertex of the edge is already visited
            if (visited[e.getTarget().hashCode()]) {
                continue;
            }

            // Add the edge to the MST and mark the target vertex as visited
            MSTResultList.add(e);
            visited[e.getTarget().hashCode()] = true;

            // Add the edges incident to the target vertex to the min-heap
            for (Edge f : e.getTarget().getAdjList()) {
                if (!visited[f.getTarget().hashCode()]) {
                    minHeap.add(f);
                }
            }
        }
    }
}