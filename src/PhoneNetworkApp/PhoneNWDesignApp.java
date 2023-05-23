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
        Graph PhLNetwork = new BluePrintsGraph();

        File InputFile = new File("InputGraph.txt");
        PhLNetwork.readGraphFromFile(InputFile);
        // PhLNetwork.makeGraph(6, 7);

        // Print the graph using the displayInfo() method of the Line class
        for (Vertex v : PhLNetwork.vertices.values()) {
            for (Edge e : v.getAdjList()) {
                // Only print Line edges
                if (e instanceof Line) {
                    Line line = (Line) e;
                    String sourceLabel = line.getSource().getLabel();
                    String targetLabel = line.getTarget().getLabel();
                    // Only print if source label is smaller than targetlabel
                    if (sourceLabel.compareTo(targetLabel) < 0) {
                        // Print edge info
                        line.displyInfo();
                    }
                }
            }
        }

    }
}
