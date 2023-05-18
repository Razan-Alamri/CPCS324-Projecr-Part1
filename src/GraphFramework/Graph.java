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
    // Array list to store vertices (from association relationship)
    List<Vertex> vertices;
    // Map to can found vertex by label
    Map<String, Vertex> vLeabelMap;
    // Map to can found Edge by source
    Map<String, Edge> edgeMap;

    // Contructors
    public Graph() {
    }

    public Graph(int verticesNo, int edgeNo, boolean isDigraph) {
        this.verticesNo = verticesNo;
        this.edgeNo = edgeNo;
        this.isDigraph = isDigraph;
        this.vertices = new ArrayList<>(verticesNo);
        this.vLeabelMap = new HashMap<>(verticesNo);
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
    public Graph makeGraph(int verticesNo, int edgeNo) {

        // Create a new graph with this patameters
        this.verticesNo = verticesNo;
        this.edgeNo = edgeNo;
        this.vertices = new ArrayList<>(verticesNo);
        this.vLeabelMap = new HashMap<>(verticesNo);
        this.edgeMap = new HashMap<>(edgeNo);

        // Create vertices
        for (int i = 0; i < verticesNo; i++) {
            // Lable of vertex (name of labeal will be VertexN where N is number )
            String lable = "Vertex" + (i + 1);
            Vertex ver = creatVertex(lable);
            ver.setVisited(false);
            vertices.add(ver);
            vLeabelMap.put(lable, ver);
        }
        // Create edges
        // To get random vertex and wight
        Random r = new Random();
        for (int i = 0; i < edgeNo; i++) {
            // Read v , u and w
            int vLable_index = r.nextInt(verticesNo);
            int uLable_index = r.nextInt(verticesNo);
            // To avoid duplicate vertex ( 1- visited vertex 2- not visited and not equal
            // visited )
            while (vLable_index == uLable_index) {
                uLable_index = r.nextInt(verticesNo);
            }
            // Random wight in range 0-100
            int w = r.nextInt(100) + 1;
            Vertex v = vLeabelMap.get(vLable_index);
            Vertex u = vLeabelMap.get(uLable_index);
            // Call method addEdge to add edges
            addEdge(v, u, w);
        }
        // Check graph is connected or no
        if (!Graph_isCnnected()) {
            makeGraph(verticesNo, edgeNo);
        }
        // Return graph
        return this;
    }

    // ------------------------------------------------Chech connected method

    /*
     * Metod to Make sure that the resulting graph is connected
     * using depth first search
     */
    private boolean Graph_isCnnected() {
        if (vertices.isEmpty()) {
            return true;
        }
        Vertex sourceVer = vertices.get(0);
        int countVisited = 0;
        // Call DFS to search for a source vertex
        DFS(sourceVer);
        // To count visited vertices and compair with vertices number
        for (Vertex ver : vertices) {
            if (ver.isVisited) {
                countVisited++;
            }
        }
        for (Vertex ver : vertices) {
            ver.setVisited(false);
        }
        // eqaul (true) then graph is connected
        return countVisited == verticesNo;
    }

    // Depth first search to search for a source vertex
    public void DFS(Vertex v) {
        v.setVisited(true);
        for (Edge e : v.getAdjList()) {
            Vertex u = e.getTarget();
            if (!u.isVisited()) {
                DFS(u);
            }
        }
    }

    /*
     * Method to reads the edges and vertices from the text file
     * whose name is inputFile
     */
    public Graph readGraphFromFile(String inputFile) throws FileNotFoundException {

        // Read graph from file
        Scanner inpScanner = new Scanner(new File(inputFile));
        // Rerad number of vertecies and edges
        this.verticesNo = inpScanner.nextInt();
        this.edgeNo = inpScanner.nextInt();

        // Create vertices
        for (int i = 0; i < verticesNo; i++) {
            // Read lable of vertex
            String lable = inpScanner.next();
            Vertex ver = creatVertex(lable);
            ver.setVisited(false);
            vertices.add(ver);
            vLeabelMap.put(lable, ver);
        }
        // Create edges
        for (int i = 0; i < edgeNo; i++) {
            // Read v , u and w
            String vLable = inpScanner.next();
            String uLable = inpScanner.next();
            int w = inpScanner.nextInt();
            Vertex v = vLeabelMap.get(vLable);
            Vertex u = vLeabelMap.get(uLable);
            // Call method addEdge to add edges
            addEdge(v, u, w);
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
