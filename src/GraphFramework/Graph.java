/* CPCS324 Project Part 1

 Group members: 
    1- Razan Alamri
    2- Khloud Alsofyani
    3- Leen Ba Galaql
    4- Shatha Binmahfouz
 */
package GraphFramework;

import java.io.*;
import java.util.*;

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
    public Graph makeGraph(int n, int m) {
        // Create n vertices with random labels
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int labelNum = rand.nextInt(n);
            String label = "O" + labelNum;
            // initializ vertex
            Vertex v = creatVertex(label);
            // To avoid Vertex duplicate
            while (vertices.containsKey(label)) {
                labelNum = rand.nextInt(n);
                label = "O" + labelNum;
                v = creatVertex(label);
            }
            // Add vertex to map
            vertices.put(label, v);
        }

        // Create m edges randomly between vertices
        HashSet<String> edgeSet = new HashSet<>();
        for (int i = 0; i < m; i++) {
            // Choose two random vertices
            List<String> labels = new ArrayList<>(vertices.keySet());
            String label1 = labels.get(rand.nextInt(labels.size()));
            String label2 = labels.get(rand.nextInt(labels.size()));
            /*
             * label1.equals(label2) -> to check source and diestination are not the same
             * edgeSet.contains(label1+":"+label2) -> to check there is no edge between them
             */
            while (label1.equals(label2) || edgeSet.contains(label1 + ":" + label2)) {
                label1 = labels.get(rand.nextInt(labels.size()));
                label2 = labels.get(rand.nextInt(labels.size()));
            }

            // Create edge with random weight
            Vertex v = vertices.get(label1);
            Vertex u = vertices.get(label2);
            // Random weight between 1 and 50
            int weight = rand.nextInt(50) + 1;
            // Call method addEdge to add edges
            addEdge(v, u, weight);
            // Add edge to set to prevent duplicates
            edgeSet.add(label1 + ":" + label2);
        }

        // Return the current Graph object
        return this;
    }

    /*
     * Method to reads the edges and vertices from the text file
     * whose name is inputFile
     */
    public Graph readGraphFromFile(File fileName) throws FileNotFoundException {
        Scanner inpScanner = new Scanner(fileName);

        // Read header information
        String graphname = inpScanner.next();
        int is_Digraph = inpScanner.nextInt();
        if (is_Digraph == 1) {
            this.isDigraph = true;
        } else if (is_Digraph == 0) {
            this.isDigraph = false;
        }
        this.verticesNo = inpScanner.nextInt();
        this.edgeNo = inpScanner.nextInt();

        // Create vertices
        while (inpScanner.hasNext()) {
            String sLabel = inpScanner.next();
            String dLabel = inpScanner.next();
            int weight = inpScanner.nextInt();

            // Get or create source vertex
            Vertex s = vertices.get(sLabel);
            if (s == null) {
                s = creatVertex(sLabel);
                vertices.put(sLabel, s);
            }

            // Get or create destination vertex
            Vertex d = vertices.get(dLabel);
            if (d == null) {
                d = creatVertex(dLabel);
                vertices.put(dLabel, d);
            }

            // Add edge between source and destination vertices
            addEdge(s, d, weight);
        }

        inpScanner.close();
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
