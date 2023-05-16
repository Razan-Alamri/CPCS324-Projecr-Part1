/* CPCS324 Project Part 1

 Group members: 
    1- Razan Alamri
    2- Khloud Alsofyani
    3- Leen Ba Galaql
    4- Shatha Binmahfouz
 */
package GraphFramework;

import java.io.File;

// Graph is a class defines the structure of a graph
public class Graph {

    // Data filed

    // Number of vertices
    int verticesNo;
    // Number of edges
    int edgeNo;
    // Check if graph is directed or not
    boolean isDigraph;
    // Array to store vertices (from association relationship)
    Vertex vertices[];

    // Contructors ------------ Check

    public Graph() {

    }

    public Graph(int verticesNo, int edgeNo, boolean isDigraph) {
        this.verticesNo = verticesNo;
        this.edgeNo = edgeNo;
        this.isDigraph = isDigraph;
    }

    //
    public static void creatVertex() {

    }

    //
    public static void createEdge() {

    }

    //
    public static void makeGraph() {

    }

    //
    public static void readGraphFromFile(File inputFile) {

    }

    //
    public static Edge addEdge() {
        return null;

    }
}
