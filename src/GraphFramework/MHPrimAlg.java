/* CPCS324 Project Part 1

 Group members: 
    1- Razan Alamri
    2- Khloud Alsofyani
    3- Leen Ba Galaql
    4- Shatha Binmahfouz
 */
package GraphFramework;

import java.util.*;

/* MHPrimAlg: is a subclass of MSTAlgorithm. It implements the polymorphic operation
displayResultingMST(). Make sure it calls the displayInfo() method of the Vertex and Edge
classes.
 */
public class MHPrimAlg extends MSTAlgorithm {

    public MHPrimAlg(Graph graph) {
        this.graph = graph;
        this.MSTResultList = new ArrayList<>();
    }

    @Override
    public void displayResultingMST() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayResultingMST'");
    }

}
