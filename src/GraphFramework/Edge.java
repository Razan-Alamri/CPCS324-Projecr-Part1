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
    // Parent vertex (from association relationship)
    Vertex parent;
    // Source vertex (from association relationship)
    Vertex source;
    // Target vertex (from association relationship)
    Vertex target;

    // Contructors

    public Edge() {
    }

    public Edge(Vertex source, Vertex target, int weight) {
        this.weight = weight;
        this.source = source;
        this.target = target;
        this.parent = source;
    }

    // Method is responsible for displaying the information of the class attributes.
    public void displyInfo() {
        System.out.println("Parent vertex: " + parent.label + "\nSource vertex: " + source.label + "\nTarget vertex: "
                + target.label + " \nEdge weight: " + weight);
    }
}
