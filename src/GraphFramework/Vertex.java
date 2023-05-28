/* CPCS324 Project Part 1

 Group members: 
    1- Razan Alamri
    2- Khloud Alsofyani
    3- Leen Ba Galaql
    4- Shatha Binmahfouz
 */
package GraphFramework;

import java.util.*;

// Vertex is a class that represents a graph vertex
public abstract class Vertex {

    // Data filed

    // Represents the vertex label
    protected String label;
    // Check if vertex is visited or not
    boolean isVisited = false;
    // Store adjacency list in LL (from association relationship)
    public LinkedList<Edge> adjList;
    //
    protected int ID;

    // Contructors
    public Vertex() {
        this.adjList = new LinkedList<Edge>();
    }

    // Contructors
    public Vertex(String label, int ID) {
        this.label = label;
        this.adjList = new LinkedList<Edge>();
        this.ID = ID;
    }

    // Method is responsible for displaying the information of the class attributes.
    public abstract String displyInfo();

    // Check if this vertex is adjacent to another vertex
    public boolean isAdjacent(Vertex other) {
        for (Edge edge : adjList) {
            if (edge.target == other) {
                return true;
            }
        }
        return false;
    }

    // Setteers and Getters
    public String getLabel() {
        return label;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public LinkedList<Edge> getAdjList() {
        return adjList;
    }

    public void setAdjList(LinkedList<Edge> adjList) {
        this.adjList = adjList;
    }
}
