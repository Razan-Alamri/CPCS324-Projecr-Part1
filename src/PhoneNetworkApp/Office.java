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

   public Office(String lable, int id) {
      super.label = lable;
      super.ID = id;
   }

   // Method to set label
   public void setLabel(String label) {
      super.label = label;
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
