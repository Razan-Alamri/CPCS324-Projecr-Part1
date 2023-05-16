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
public class Vertex {

    // Data filed

    // Represents the vertex label
    String label;
    // Check if vertex is visited or not
    boolean isVisited;
    // Store adjacency list in LL (from association relationship)
    LinkedList<Edge> adjList;

    // Contructors ------------ Check

    public Vertex() {
    }

    public Vertex(String label) {
        this.label = label;
        this.adjList = new LinkedList<Edge>();
    }

    // Method is responsible for displaying the information of the class attributes.
    // ------------- check
    public void displyInfo() {
        System.err.println("Vertex " + label + " is Visited " + isVisited + ", adjacency list of vertex is " + adjList);
    }

    @Override
    public String toString() {
        return "Vertex " + label + " is Visited " + isVisited + ", adjacency list of vertex is " + adjList;
    }
}
