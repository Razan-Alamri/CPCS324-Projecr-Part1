/* CPCS324 Project Part 1

 Group members: 
    1- Razan Alamri
    2- Khloud Alsofyani
    3- Leen Ba Galaql
    4- Shatha Binmahfouz
 */
package GraphFramework;

// Edge is a class that represents a graph edge
public class Edge {

    // Data filed

    // Cost of edge
    int weight;
    // (from association relationship)
    Vertex parent;
    // Source vertex (from association relationship)
    Vertex source;
    // Target vertex (from association relationship)
    Vertex target;

    // Contructors ------------ Check

    public Edge() {
    }

    public Edge(int weight, Vertex parent, Vertex source, Vertex target) {
        this.weight = weight;
        this.source = source;
        this.target = target;
        //
        this.parent = new Vertex();
    }

    // Method is responsible for displaying the information of the class attributes.
    // ------------- check
    public void displyInfo() {
        System.out.println("Parent vertex: " + parent.label + "\nSource vertex: " + source.label + "\nTarget vertex: "
                + target.label + " \nEdge weight: " + weight);
    }
}
