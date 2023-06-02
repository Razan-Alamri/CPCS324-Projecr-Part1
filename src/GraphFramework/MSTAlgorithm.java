/* CPCS324 Project Part 1

 Group members: 
    1- Razan Alamri
    2- Khloud Alsofyani
    3- Leen Ba Galaql
    4- Shatha Binmahfouz
 */
package GraphFramework;

import java.util.*;

/*MSTAlgorithm: is a superclass representing the general characteristics of an algorithm for computing
the minimum spanning tree. It has three subclasses: KruskalAlg and MHPrimAlg. It contains the
following attributes and functions:
Attributes displayed via association relationship in the diagram: MSTResultList attribute is a list of
objects of the type Edge. It stores the parent of the vertex and the weight needed by the MST algorithm.
displayResultingMST(): it is an abstract function that should be implemented by the subclasses’
polymorphic functions. */
public abstract class MSTAlgorithm {

   // Data filed

   // Create Graph object (from association relationship)
   protected Graph graph;
   //
   protected List<Edge> MSTResultList;

   // Contructors
   public MSTAlgorithm(Graph graph) {
      this.graph = graph;
   }

   public abstract void displayResultingMST();

}