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

   /*
    * Override abstract method from graph class
    * to create object of Vertex "Office"
    */
   @Override
   public Vertex creatVertex(String lable) {
      return new Office();

   }

   /*
    * Override abstract method from graph class
    * to create object of Edge "Line"
    */
   @Override
   public Edge creatEdge(Vertex v, Vertex u, int w) {
      return new Line(u, u, w);

   }

}
