/* CPCS324 Project Part 1

 Group members: 
    1- Razan Alamri
    2- Khloud Alsofyani
    3- Leen Ba Galaql
    4- Shatha Binmahfouz
 */
package PhoneNetworkApp;

import java.io.*;
import GraphFramework.Edge;
import GraphFramework.Graph;
import GraphFramework.Vertex;

// PhNWDesignApp is a class. It is the starting point of the program and contains the main function
public class PhoneNWDesignApp {
    public static void main(String[] args) throws FileNotFoundException {

        // Create a new graph object
        Graph PhLNetwork = new BluePrintsGraph(6, 8, false);

        // File InputFile = new File("InputGraph.txt");
        // PhLNetwork.readGraphFromFile(InputFile);
        PhLNetwork.makeGraph();

        // Print the graph using the displayInfo() method of the Line class

        for (String label : PhLNetwork.vertices.keySet()) {
            Vertex vertex = PhLNetwork.vertices.get(label);
            for (Edge edge : vertex.adjList) {
                Line line = (Line) edge;
                line.displyInfo();
            }
        }

        /*
         * for (Vertex v : PhLNetwork.vertices.values()) {
         * for (Edge e : v.adjList) {
         * e.displyInfo();
         * }
         * }
         */
    }
}
