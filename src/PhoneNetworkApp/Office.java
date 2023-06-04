/* CPCS324 Project Part 1

 Group members: 
    1- Razan Alamri
    2- Khloud Alsofyani
    3- Leen Ba Galaql
    4- Shatha Binmahfouz
 */
package PhoneNetworkApp;

import GraphFramework.Vertex;

// Office is a subclass of Vertex, it inherits all attributes, operations & relationships
public class Office extends Vertex {

   // Data filed
   private String stringLabel;

   // Contructors

   public Office(int id) {
      super(id);
      this.stringLabel = "" + getLabel();
   }

   public Office() {
      super();
   }

   // Method to set label
   public String setlabel(char label) {
      stringLabel = "O" + getID();
      return stringLabel;
   }

   /*
    * Override method that responsible for displaying
    * the information of the class attributes
    */
   @Override
   public String displyInfo() {

      return "Office No." + getLabel();
   }
}
