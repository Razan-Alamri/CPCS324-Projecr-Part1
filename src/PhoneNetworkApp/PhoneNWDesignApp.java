/* CPCS324 Project Part 1

 Group members: 
    1- Razan Alamri
    2- Khloud Alsofyani
    3- Leen Ba Galaql
    4- Shatha Binmahfouz
 */
package PhoneNetworkApp;

import java.io.*;
import java.util.Scanner;

import GraphFramework.Edge;
import GraphFramework.Graph;
import GraphFramework.Vertex;

// PhNWDesignApp is a class. It is the starting point of the program and contains the main function
public class PhoneNWDesignApp {
    public static void main(String[] args) throws FileNotFoundException {

        /* اضيف خيار يقراء من ملف او يختار وبعدها اضبط كومنت واسماء واستدعاء القورثم */
        //
        Scanner input = new Scanner(System.in);

        //
        System.out.println("\t ------------Minimum Spanning Tree Algorithms-----------\n");
        System.out.println("\t1- Kruskal's Algorithm& Priority Queue based Prim Algorithem\n"
                + "\t2- Min Heap bease on Prim Algorithm & Prim's Algorithm(based on Priority Queue)");

        System.out.print(">>> Enter your choice (1 or 2) : ");
        int comparison = input.nextInt();

        System.out.println(">>> n is the number of vertices) and (m is the number of edges) : ");
        System.out.println(" 1: Read Graph From File");
        System.out.println(" 2:  n=1,000 ,  m=10,000");
        System.out.println(" 3:  n=1,000 ,  m=15,000");
        System.out.println(" 4:  n=1,000 ,  m=25,000");
        System.out.println(" 5:  n=5,000 ,  m=15,000");
        System.out.println(" 6:  n=5,000 ,  m=25,000");
        System.out.println(" 7:  n=10,000 , m=15,000");
        System.out.println(" 8:  n=10,000 , m=25,000");
        System.out.println(" 9:  n=20,000 , m=200,000");
        System.out.println(" 10:  n=20,000 , m=300,000");
        System.out.println("11:  n=50,000 , m=1,000,000");
        System.out.print("\n>>> Enter a case to test : ");
        int Case = input.nextInt();

        switch (Case) {
            case 1:
                graph(0, 0, comparison);
                break;
            case 2:

                graph(1000, 10000, comparison);
                break;
            case 3:
                graph(1000, 15000, comparison);
                break;
            case 4:
                graph(1000, 25000, comparison);
                break;
            case 5:
                graph(5000, 15000, comparison);
                break;
            case 6:
                graph(5000, 25000, comparison);
                break;
            case 7:
                graph(10000, 15000, comparison);
                break;
            case 8:
                graph(10000, 25000, comparison);
                break;
            case 9:
                graph(20000, 200000, comparison);
                break;
            case 10:
                graph(20000, 300000, comparison);
                break;
            case 11:
                graph(50000, 1000000, comparison);
                break;
            default:
                System.out.println("---Invalid input!---");
                break;
        }
    }

    public static void graph(int n, int m, int comparison) throws FileNotFoundException {

        System.out.println("-------------------------(" + n + ")---------------------------");
        // Create a new graph object
        Graph PhLNetwork = new BluePrintsGraph();
        File InputFile = new File("InputGraph.txt");
        PhLNetwork.readGraphFromFile(InputFile);
        // PhLNetwork.makeGraph(n, m);

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