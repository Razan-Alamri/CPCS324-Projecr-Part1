/* CPCS324 Project Part 1

 Group members: 
    1- Razan Alamri
    2- Khloud Alsofyani
    3- Leen Ba Galaql
    4- Shatha Binmahfouz
 */
package GraphFramework;

/* MSTAlgorithm: is a superclass representing the general characteristics of an algorithm for computing
   the minimum spanning tree. It has three subclasses: KruskalAlg and MHPrimAlg. 
 */
public abstract class MSTAlgorithm {

   // Data filed

   // Create Graph object (from association relationship)
   protected Graph graph;
   // To stores the parent of the vertex and the weight needed by the MST
   // algorithm.
   Edge MSTResultList[];

   // Contructors
   public MSTAlgorithm(Graph graph) {
      this.graph = graph;
   }

   // It is an abstract function that should be implemented by the subclasses
   public abstract void displayResultingMST(boolean isFile);

}