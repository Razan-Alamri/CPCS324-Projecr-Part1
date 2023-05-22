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
        this.verticesNo = 0;
        this.edgeNo = 0;
        this.isDigraph = false;
        this.vertices = new HashMap<>();
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
        // To get random vertex and wight
        Random r = new Random();
        // Create vertices
        for (int i = 0; i < verticesNo - 1; i++) {
            // Lable of vertex (name of labeal will be VertexN where N is number )
            String slable = "O" + (i + 1);
            String dlable = "O" + (i + 2);
            Vertex verS = creatVertex(slable);
            Vertex verD = creatVertex(dlable);
            verS.setVisited(false);
            vertices.put(slable, verS);
            verD.setVisited(false);
            vertices.put(dlable, verD);
            // Random wight in range 1-50
            int w = r.nextInt(50) + 1;
            addEdge(verS, verD, w);
            System.out.println(verS.getLabel() + " " + verD.getLabel());
        }
        // remaning edge
        int remaining = edgeNo - (verticesNo - 1);
        // Create edges
        for (int i = 0; i < remaining; i++) {
            // Read source , diestination and w
            // Get a random entry from the HashMap.
            Object[] crunchifyKeys = vertices.keySet().toArray();
            Object key1 = crunchifyKeys[new Random().nextInt(crunchifyKeys.length)];
            Object key2 = crunchifyKeys[new Random().nextInt(crunchifyKeys.length)];
            // String sLable ="O" + r.nextInt(remaining);
            // String dLable = "O" + r.nextInt(remaining);
            Vertex s = vertices.get(key1);
            Vertex d = vertices.get(key2);
            int weight = r.nextInt(50) + 1;
            System.out.println(key1 + "'   " + key2);
            //
            // to avoid duplicate edges
            if (s == d || isConnected(s, d)) {
                i--;
            } else {
                // add edge to graph
                System.out.println(s.getLabel() + " " + d.getLabel() + " w " + weight);
                addEdge(s, d, weight);
            }
        }
        return this;
    }

    // check if the edge is exist and connect
    public boolean isConnected(Vertex source, Vertex target) {
        for (Edge edge : source.adjList) {
            if ((edge.source == source && edge.target == target)
                    || (edge.source == target && edge.target == source)) {
                return true;
            }
        }

        return false;
    }

    /*
     * Method to reads the edges and vertices from the text file
     * whose name is inputFile
     */
    public Graph readGraphFromFile(File fileName) throws FileNotFoundException {

        // Read graph from file
        Scanner inpScanner = new Scanner(fileName);

        // Read header information
        String graphType = inpScanner.next();
        int isDigraph = inpScanner.nextInt();
        this.verticesNo = inpScanner.nextInt();
        this.edgeNo = inpScanner.nextInt();

        // Create vertices and edges
        while (inpScanner.hasNext()) {
            // Read source, destination, and weight
            String sLabel = inpScanner.next();
            String dLabel = inpScanner.next();
            int weight = inpScanner.nextInt();

            // Get source vertex
            Vertex s = creatVertex(sLabel);
            vertices.put(sLabel, s);
            // Get destination vertex
            Vertex d = creatVertex(dLabel);
            vertices.put(dLabel, d);
            addEdge(s, d, weight);
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
        Edge edge = creatEdge(v, u, w);

        // Add edge to the source adjacent list
        v.adjList.addFirst(edge);

        // Check if it is an undirected graph
        if (!isDigraph) {
            // Create reverse edge and add it to the target adjacent list
            Edge revEdge = creatEdge(u, v, w);
            u.adjList.addFirst(revEdge);
            ;
        }
        /*
         * Increment the edge count by 1 If it is a undirected graph
         * and by 2 if directed graph
         */
        edgeNo += isDigraph ? 1 : 2;
    }
}
