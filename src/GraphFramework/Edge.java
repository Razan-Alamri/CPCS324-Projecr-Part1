/* CPCS324 Project Part 1

 Group members: 
    1- Razan Alamri
    2- Khloud Alsofyani
    3- Leen Ba Galaql
    4- Shatha Binmahfouz
 */
package GraphFramework;

// Edge is a class that represents a graph edge
public abstract class Edge {

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
    public Edge(Vertex source, Vertex target, int weight) {
        this.weight = weight;
        this.source = source;
        this.target = target;
        this.parent = source;
    }

    // Method is responsible for displaying the information of the class attributes.
    public abstract void displyInfo();

    // Setteers and Getters
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public Vertex getTarget() {
        return target;
    }

    public void setTarget(Vertex target) {
        this.target = target;
    }
}
