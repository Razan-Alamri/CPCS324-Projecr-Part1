/* CPCS324 Project Part 1

 Group members: 
    1- Razan Alamri
    2- Khloud Alsofyani
    3- Leen Ba Galaql
    4- Shatha Binmahfouz
 */
package GraphFramework;

import java.util.*;

import PhoneNetworkApp.Line;
import PhoneNetworkApp.Office;

/* MHPrimAlg is a subclass of MSTAlgorithm that implements the minimum spanning tree
 *  algorithm using the modified heap-based Prim's algorithm.
 */
public class MHPrimAlg extends MSTAlgorithm {

    public MHPrimAlg(Graph graph) {
        super(graph);
        this.MSTResultList = new ArrayList<>();
    }

    @Override
    public void displayResultingMST() {
        //

        Map<Integer, Vertex> IndexVertex = new HashMap<>();

        for (Map.Entry<String, Vertex> entry : graph.vertices.entrySet()) {
            Vertex ver = entry.getValue();
            IndexVertex.put(ver.ID, ver);
            // System.out.println(ver.label + " " + ver.ID);
        }

        // Initialize the minimum priority queue
        PriorityQueue<Edge> pq = new PriorityQueue<>(new EdgeComparator());
        // Initialize the visited array
        boolean[] visited = new boolean[graph.vertices.size()];

        // Start at the first vertex in the graph
        System.out.println(graph.vertices.size());
        String lb = IndexVertex.get(0).getLabel();
        System.out.println(lb + "    " + graph.vertices.get(lb).ID);
        Vertex startVertex = graph.vertices.get(lb);
        visited[startVertex.ID + 1] = true;

        // Add all edges from the start vertex to the priority queue
        for (Edge edge : startVertex.getAdjList()) {
            pq.offer(edge);
        }

        // Loop until all vertices have been visited
        while (!pq.isEmpty()) {
            // Get the next lowest weight edge from the priority queue
            Edge currentEdge = pq.poll();
            Vertex currentVertex = currentEdge.target;

            // If the current vertex has not been visited, add the edge to the MST
            if (!visited[currentVertex.ID]) {
                MSTResultList.add(currentEdge);
                visited[currentVertex.ID] = true;

                // Add all edges from the current vertex to the priorityqueue that connect to
                // unvisited vertices
                for (Edge edge : currentVertex.getAdjList()) {
                    Vertex destVertex = edge.target;
                    if (!visited[destVertex.ID]) {
                        pq.offer(edge);
                    }
                }
            }
        }

        // Display the resulting MST
        System.out.println("Minimum Spanning Tree:");
        for (Edge edge : MSTResultList) {
            System.out.println(
                    edge.getSource().getLabel() + " - " + edge.target.getLabel() + " : " + edge.getWeight());
        }
    }

}
