/* CPCS324 Project Part 1

 Group members: 
    1- Razan Alamri
    2- Khloud Alsofyani
    3- Leen Ba Galaql
    4- Shatha Binmahfouz
 */
package PhoneNetworkApp;

import GraphFramework.Edge;
import GraphFramework.Graph;
import GraphFramework.Vertex;

// Graph is a subclass of Graph, it inherits all attributes, operations & relationships
public class BluePrintsGraph extends Graph {

   // Contructors
   public BluePrintsGraph() {
      // Call a super class "Graph"
      super();
   }

   public BluePrintsGraph(int verticesNo, int edgeNo, boolean isDigraph) {
      // Call a super class "Graph"
      super(verticesNo, edgeNo, isDigraph);
   }

   /*
    * Override abstract method from graph class
    * to create object of Vertex "Office"
    */
   @Override
   public Vertex creatVertex(String lable, int ID) {
      return new Office(lable, ID);

   }

   /*
    * Override abstract method from graph class
    * to create object of Edge "Line"
    */
   @Override
   public Edge creatEdge(Vertex v, Vertex u, int w) {
      return new Line(v, u, w);

   }

}
