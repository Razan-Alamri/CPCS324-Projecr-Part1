/* CPCS324 Project Part 1

 Group members: 
    1- Razan Alamri
    2- Khloud Alsofyani
    3- Leen Ba Galaql
    4- Shatha Binmahfouz
 */
package PhoneNetworkApp;

import java.io.*;
import java.util.*;
import GraphFramework.*;

// PhNWDesignApp is a class. It is the starting point of the program and contains the main function
public class PhoneNWDesignApp {
    public static void main(String[] args) throws FileNotFoundException {

        // To read input from user
        Scanner input = new Scanner(System.in);
        // To store running time of each algorithm
        double start_Time, end_Time;

        // Print Hedar massege
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("-------              Welcome to Phone Network Design Program               -------");
        System.out.println("----------------------------------------------------------------------------------");

        System.out.println("\n This program to Compute the minimum spanning tree using two algorithms:");
        System.out.println("\t1- Kruskal's Algorithm");
        System.out.println("\t2- Min-heap based Prim algorithm");
        System.out.println("\n----------------------------------------------------------------------------------");

        // To disply menu of test cases can do
        System.out.println("\n<<  Test Cases  >>\n");
        System.out.println(" 1:  Read Phone Network Design From File");
        System.out.println(" 2:  n = 1000 and  m = 10000");
        System.out.println(" 3:  n = 1000 and  m = 15000");
        System.out.println(" 4:  n = 1000 and  m = 25000");
        System.out.println(" 5:  n = 5000 and  m = 15000");
        System.out.println(" 6:  n = 5000 and  m = 25000");
        System.out.println(" 7:  n = 10000 and m = 15000");
        System.out.println(" 8:  n = 10000 and m = 25000");
        System.out.println();
        System.out.println("< NOTE: n is the number of offices and m is the number of Lines >");
        System.out.print("\n> From these cases, please enter your choice: ");
        // To save number of test Case choice
        int test_Case = input.nextInt();

        // Create a new graph object
        Graph PhLNetwork = new BluePrintsGraph();

        // To get test case
        switch (test_Case) {
            case 1:
                // Create a new graph object
                PhLNetwork = new BluePrintsGraph();
                File InputFile = new File("InputGraph.txt");
                PhLNetwork.readGraphFromFile(InputFile);
                break;
            case 2:
                // Create a new graph object
                PhLNetwork = new BluePrintsGraph();
                PhLNetwork.makeGraph(1000, 10000);
                break;
            case 3:
                // Create a new graph object
                PhLNetwork = new BluePrintsGraph();
                PhLNetwork.makeGraph(1000, 15000);
                break;
            case 4:
                // Create a new graph object
                PhLNetwork = new BluePrintsGraph();
                PhLNetwork.makeGraph(1000, 25000);
                break;
            case 5:
                // Create a new graph object
                PhLNetwork = new BluePrintsGraph();
                PhLNetwork.makeGraph(5000, 15000);
                break;
            case 6:
                // Create a new graph object
                PhLNetwork = new BluePrintsGraph();
                PhLNetwork.makeGraph(5000, 25000);
                break;
            case 7:
                // Create a new graph object
                PhLNetwork = new BluePrintsGraph();
                PhLNetwork.makeGraph(10000, 15000);
                break;
            case 8:
                // Create a new graph object
                PhLNetwork = new BluePrintsGraph();
                PhLNetwork.makeGraph(10000, 25000);
                break;
            default:
                System.out.println("<   Invalid input!  >");
                break;
        }

        // Apply two algoritms and compute the run time for each algorithm
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println();

        // - Compute the minimum spanning tree using Kruskal algorithm and print the
        // result
        start_Time = System.currentTimeMillis();
        // ***********************************************************************************************************
        // */
        // KruskalAlg kruskalAlg = new KruskalAlg();
        // kruskalAlg.displayResultingMST();
        // System.out.println("Minimum Spanning Tree cost: " + kruskalAlg.getMSTCost());
        end_Time = System.currentTimeMillis();

        System.out.println("Kruskal's Algorithm's run time is  " + (end_Time - start_Time) + " ms.\n");

        // Compute the minimum spanning tree using Min-heap based Prim algorithm and
        // print the result
        start_Time = System.currentTimeMillis();
        // ***********************************************************************************************************
        // */

        MHPrimAlg primAlg = new MHPrimAlg(PhLNetwork);
        // Compute the minimum spanning tree using Prim's algorithm
        // primAlg.PrimMH();
        primAlg.displayResultingMST();

        end_Time = System.currentTimeMillis();

        System.out.println("Min-heap based Prim Algorithm's run time is  " + (end_Time - start_Time) + " ms.\n");

        // Print Hedar massege
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("-------         Thank You For Using Phone Network Design Program           -------");
        System.out.println("----------------------------------------------------------------------------------");

        // Close scanner
        input.close();
    }
}