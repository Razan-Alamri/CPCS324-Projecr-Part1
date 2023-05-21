/* CPCS324 Project Part 1

 Group members: 
    1- Razan Alamri
    2- Khloud Alsofyani
    3- Leen Ba Galaql
    4- Shatha Binmahfouz
 */
package GraphFramework;

import java.io.*;
import java.util.*;;

// Graph is a class defines the structure of a graph
public abstract class Graph {

    // Data filed

    // Number of vertices
    int verticesNo;
    // Number of edges
    int edgeNo;
    // Check if graph is directed or not
    boolean isDigraph;
    // Map to can store and found vertex by label (from association relationship)
    public Map<String, Vertex> vertices;

    // ----------------------------------------------------------check
    // Map to can found Edge by source
    // Map<String, Edge> edgeMap;

    // Contructors
    public Graph() {
    }

    public Graph(int verticesNo, int edgeNo, boolean isDigraph) {
        this.verticesNo = verticesNo;
        this.edgeNo = edgeNo;
        this.isDigraph = isDigraph;
        this.vertices = new HashMap<>(verticesNo);
    }

    // Abstract method to create object of Vertex
    public abstract Vertex creatVertex(String lable);

    // Abstract method to create object of Edge
    public abstract Edge creatEdge(Vertex v, Vertex u, int w);

    /*
     * Methos responsible for creating a graph object with the specified parameters
     * and randomly initializes the vertices’ labels,
     * creating edges that connects the created vertices randomly and
     * assigning them random weights.
     */
    public Graph makeGraph() {

        // Create vertices
        for (int i = 0; i < verticesNo; i++) {
            // Lable of vertex (name of labeal will be VertexN where N is number )
            String lable = "O" + (i + 1);
            Vertex ver = creatVertex(lable);
            ver.setVisited(false);
            vertices.put(lable, ver);
        }
        // Create edges
        // To get random vertex and wight
        Random r = new Random();
        int edgeCount = 0;
        while (edgeCount < edgeNo) {
            // Read source , diestination and w
            String sLable = "O" + r.nextInt(verticesNo);
            String dLable = "O" + r.nextInt(verticesNo);
            Vertex s = vertices.get(sLable);
            Vertex d = vertices.get(dLable);
            /*
             * 1- s != d ==> to check source and diestination are not the same
             * 2- !s.adjList.contains(d) && !d.adjList.contains(s) ==> to check there is no
             * edge between
             */
            if (s != d && !s.adjList.contains(d) && !d.adjList.contains(s)) {
                // Random wight in range 1-50
                int w = r.nextInt(50) + 1;
                // Call method addEdge to add edges
                addEdge(s, d, w);
                edgeCount++;
            }
        }

        // Return graph
        return this;

    }

    /*
     * Method to reads the edges and vertices from the text file
     * whose name is inputFile
     */
    public Graph readGraphFromFile(String fileName) throws FileNotFoundException {

        // Read graph from file
        Scanner inpScanner = new Scanner(new File(fileName));
        // Rerad number of vertecies and edges
        this.verticesNo = inpScanner.nextInt();
        this.edgeNo = inpScanner.nextInt();

        // Create vertices
        for (int i = 0; i < verticesNo; i++) {
            // Read lable of vertex
            String lable = inpScanner.next();
            Vertex ver = creatVertex(lable);
            ver.setVisited(false);
            vertices.put(lable, ver);
        }
        // Create edges
        for (int i = 0; i < edgeNo; i++) {
            // Read source , diestination and w
            String sLable = inpScanner.next();
            String dLable = inpScanner.next();
            int w = inpScanner.nextInt();
            Vertex s = vertices.get(sLable);
            Vertex d = vertices.get(dLable);
            // Call method addEdge to add edges
            addEdge(s, d, w);
        }
        // Close scanner
        inpScanner.close();
        // Return graph
        return this;
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
