
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
 */public class MHPrimAlg extends MSTAlgorithm {

    public MHPrimAlg(Graph graph) {
        super(graph);
    }

    @Override
    public void displayResultingMST(boolean isFile) {
        // Initialize the minimum spanning tree as an array of edges with the same size
        // as the number of vertices in the graph
        MSTResultList = new Edge[graph.verticesNo];

        // Create a priority queue (min heap) to store the vertices with the minimum
        // edge weight
        PriorityQueue<Vertex> minHeap = new PriorityQueue<>(graph.verticesNo,
                Comparator.comparingInt(vertex -> vertex.getKey()));

        // Mark all vertices as not visited and set their key (minimum edge weight) to
        // infinity
        for (Vertex vertex : graph.getVertices()) {
            vertex.setVisited(false);
            vertex.setKey(Integer.MAX_VALUE);
        }

        // Set the key of the first vertex to 0 and add it to the min heap
        Vertex firstVertex = graph.getVertices()[0];
        firstVertex.setKey(0);
        minHeap.offer(firstVertex);

        // Loop until the min heap is empty
        while (!minHeap.isEmpty()) {
            // Extract the vertex with the minimum key (minimum distance from the minimum
            // spanning tree)
            Vertex currentVertex = minHeap.poll();
            currentVertex.setVisited(true);

            // Add the corresponding edge to the minimum spanning tree
            if (currentVertex.getParent() != null) {
                int index = currentVertex.getParent().getAdjList().indexOf(currentVertex.getEdgeToParent());
                MSTResultList[index] = currentVertex.getEdgeToParent();
            }

            // Update the key of the adjacent vertices if they are not visited and their key
            // is greater than the weight of the edge connecting them to the current vertex
            for (Edge edge : currentVertex.getAdjList()) {
                Vertex adjacentVertex = edge.getTarget();
                if (!adjacentVertex.isVisited() && edge.getWeight() < adjacentVertex.getKey()) {
                    adjacentVertex.setKey(edge.getWeight());
                    adjacentVertex.setParent(currentVertex);
                    adjacentVertex.setEdgeToParent(edge);
                    minHeap.offer(adjacentVertex);
                }
            }
        }
    }
}