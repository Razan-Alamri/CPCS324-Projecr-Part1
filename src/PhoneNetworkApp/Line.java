/* CPCS324 Project Part 1

 Group members: 
    1- Razan Alamri
    2- Khloud Alsofyani
    3- Leen Ba Galaql
    4- Shatha Binmahfouz
 */
package PhoneNetworkApp;

import GraphFramework.Edge;
import GraphFramework.Vertex;

// Line is a subclass of Edge, it inherits all attributes, operations & relationships
public class Line extends Edge {

   // Data filed

   // Line length
   private int lLength;

   // Contructors

   public Line(Vertex source, Vertex target, int weight) {
      // Call a super class "Edge"
      super(source, target, weight);
      /*
       * The lLength attribute represents the line length and it is 5 times the weight
       * of the corresponding edge
       */
      lLength = weight * 5;
   }

   public Line(int w) {
      // Call a super class "Edge"
      super(w);
   }

   public Line() {
      // Call a super class "Edge"
      super();
   }

   /*
    * Override method that responsible for displaying
    * the information of the class attributes
    */
   @Override
   public void displyInfo() {
      System.out.println(getSource().displyInfo() + " - " + getTarget().displyInfo() + " : line length: " + lLength);
   }

}
