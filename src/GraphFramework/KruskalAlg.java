/* CPCS324 Project Part 1

 Group members: 
    1- Razan Alamri
    2- Khloud Alsofyani
    3- Leen Ba Galaql
    4- Shatha Binmahfouz
 */
package GraphFramework;

import java.util.*;

/*KruskalAlg: is a subclass of MSTAlgorithm. It implements the polymorphic operation
displayResultingMST(). Make sure it calls the displayInfo() method of the Vertex and Edge
classes.
 */
public class KruskalAlg extends MSTAlgorithm {

   private List<Edge> MSTResultList;

   public KruskalAlg(Graph graph) {
      this.graph = graph;
      this.MSTResultList = new ArrayList<>();
   }

   @Override
   public void displayResultingMST() {
      // Create a new list of edges
      List<Edge> edges = new ArrayList<>();
      for (Vertex v : graph.vertices.values()) {
         for (Edge e : v.getAdjList()) {
            edges.add(e);
         }
      }

   }
}
