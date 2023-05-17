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
public abstract class Graph {

    // Data filed

    // Number of vertices
    int verticesNo;
    // Number of edges
    int edgeNo;
    // Check if graph is directed or not
    boolean isDigraph;
    // Array to store vertices (from association relationship)
    Vertex vertices[];

    // Contructors

    public Graph() {

    }

    public Graph(int verticesNo, int edgeNo, boolean isDigraph) {
        this.verticesNo = verticesNo;
        this.edgeNo = edgeNo;
        this.isDigraph = isDigraph;
        vertices = new Vertex[verticesNo];

        /*
         * for (int i = 0; i < verticesNo; i++) {
         * vertices[i] = new Vertex(lable);
         * }
         */
    }

    // Abstract method to create object of Vertex
    // ----------------------------------------------- check
    public abstract Vertex creatVertex(String lable);

    // Abstract method to create object of Edge
    // ----------------------------------------------- check
    public abstract Edge creatEdge(Vertex v, Vertex u, int w);

    //
    public void makeGraph() {

    }

    //
    public void readGraphFromFile(File inputFile) {

    }

    /*
     * Method that creates an edge object and passes source v vertex, target u
     * vertex
     * and weight as parameters, assigns the target vertex to the adjacent list
     * of the source vertex
     */
    public void addEdge(Vertex v, Vertex u, int w) {
        // Create edge
        Edge edge1 = creatEdge(v, u, w);
        // Add edge to the source adjacent list
        v.adjList.add(edge1);
        // Check if it is a directed graph
        if (!isDigraph) {
            // Create edge
            Edge edge2 = creatEdge(v, u, w);
            // Add edge to the target adjacent list
            u.adjList.add(edge2);
            // Increments the EdgeNo + 1
            edgeNo++;
        }
        // If it is a undirected graph
        else {
            // Increments the EdgeNo + 2
            edgeNo += edgeNo + 2;
        }
    }
}
