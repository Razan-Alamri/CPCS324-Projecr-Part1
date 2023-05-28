
/* CPCS324 Project Part 1

 Group members: 
    1- Razan Alamri
    2- Khloud Alsofyani
    3- Leen Ba Galaql
    4- Shatha Binmahfouz
 */
package GraphFramework;

import java.util.*;

import PhoneNetworkApp.Line;
import PhoneNetworkApp.Office;

/* MHPrimAlg is a subclass of MSTAlgorithm that implements the minimum spanning tree
 *  algorithm using the modified heap-based Prim's algorithm.
 */
public class MHPrimAlg extends MSTAlgorithm {

    // capacity of the heap maxSize
    int capacity;

    // current size of the heap
    int currentSize;

    // minHeap Array
    Edge[] MinHeapArr;

    // position of heap elements in the Heap
    int[] indexes;

    // cost of MST
    int cost;

    public MHPrimAlg(Graph graph) {
        super(graph);
        this.MSTResultList = new ArrayList<>();
        capacity = graph.vertices.size();
        MinHeapArr = new Line[capacity + 1];
        indexes = new int[capacity];
        MinHeapArr[0] = new Line();
        MinHeapArr[0].weight = Integer.MIN_VALUE; // minumn value to do not use it
        MinHeapArr[0].source.ID = -1;
        currentSize = 0;
    }

    /**
     * PrimMH method take the graph as its parameter to find MST of the graph
     *
     * @param graph
     */
    public void PrimMH() {

        MSTResultList = new ArrayList<>(capacity);

        // intillize all edges
        for (int i = 0; i < graph.verticesNo; i++) {
            // intilize all heap nodes
            MSTResultList.add(i, new Line());
            MSTResultList.get(i).source.ID = i;
            MSTResultList.get(i).parent.ID = -1;
            MSTResultList.get(i).weight = Integer.MAX_VALUE; // and infinity as the key
        }
        // the first node has weight of 0
        MSTResultList.get(0).weight = 0;

        // add all vertices to the minHeap
        for (int i = 0; i < capacity; i++) {
            insert(MSTResultList.get(i));
        }
        //
        Map<Integer, Vertex> IndexVertex = new HashMap<>();
        //
        for (Map.Entry<String, Vertex> entry : graph.vertices.entrySet()) {
            Vertex ver = entry.getValue();
            IndexVertex.put(ver.ID, ver);
            // System.out.println(ver.label + " " + ver.ID);
        }

        // while heap node is not empty
        while (!isEmpty()) {
            // extract the min top element
            Edge extractedMinNode = extractMin();
            cost += extractedMinNode.weight;
            // extracted vertex lable
            int extractedVertex = extractedMinNode.source.ID;
            // System.out.println(extractedVertex + " kl");
            MSTResultList.get(extractedVertex).source.isVisited = true; // mark the extracted vertex ad visited
            String lable = IndexVertex.get(extractedVertex).label;
            // System.out.println(lable + " gg " +
            // IndexVertex.get(extractedVertex).adjList);
            System.out.println(lable + " bb " + extractedVertex);
            LinkedList<Edge> list = graph.vertices.get(lable).adjList;// for all edges of the vertex
            for (int i = 0; i < list.size(); i++) {
                Edge edge = list.get(i);
                // only if edge destination doesnt visited yet
                if (!MSTResultList.get(edge.target.ID).source.isVisited) {
                    int destination = edge.target.ID;
                    int newWight = edge.weight;
                    // check if updated key
                    if (MSTResultList.get(destination).weight > newWight) {
                        decreaseKey(newWight, destination);// change thee wight of the node
                        // update the wight and the parent
                        MSTResultList.get(destination).parent.ID = extractedVertex;
                        MSTResultList.get(destination).weight = newWight;

                    }
                }
            }

        }
    }

    /**
     * remove the min value form the min heap
     *
     * @param newWight new wight to update
     * @param vertex   need to modify
     */
    public void decreaseKey(int newWight, int vertex) {
        // get the index which key's needs a decrease;
        int index = indexes[vertex];
        // get the node and update its value
        Edge node = MinHeapArr[index];
        node.weight = newWight;
        bubbleUp(index);

    }

    /**
     * to add new node to the minHeap
     *
     * @param Node new node
     */
    public void insert(Edge Node) {
        currentSize++; // increment size of heap
        int Index = currentSize;
        MinHeapArr[Index] = Node; // update the minHeap
        indexes[Node.source.ID] = Index; // update the place of the node
        bubbleUp(Index);

    }

    /**
     * put the new value added to the correct position
     *
     * @param Number to bubbleUp index
     */
    public void bubbleUp(int Number) {

        int parentIndex = Number / 2; // find parent of node
        int currentIndex = Number;
        // while parent is bigger than child
        // buble the child up
        while (currentIndex > 0 && MinHeapArr[parentIndex].weight > MinHeapArr[currentIndex].weight) {

            Edge currentNode = MinHeapArr[currentIndex];
            Edge parentNode = MinHeapArr[parentIndex];
            // swap the positions
            indexes[currentNode.source.ID] = parentIndex;
            indexes[parentNode.source.ID] = currentIndex;
            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
            parentIndex = parentIndex / 2;
        }
        // otherwise do nothing
    }

    /**
     * extract the node with the last weight
     *
     * @return the minimum node which is the root
     */
    public Edge extractMin() {
        Edge min = MinHeapArr[1];// take the root of heap first element
        Edge lastNode = MinHeapArr[currentSize]; // save the last element
        indexes[lastNode.source.ID] = 1; // put the last emlent as the first element in the hrap
        MinHeapArr[1] = lastNode; // replace the first element by the root
        MinHeapArr[currentSize] = null; // delete the last element
        sinkDown(1);
        currentSize--;// decrement the current size of heap
        return min; // return the deleted node
    }

    /**
     * sinkDown method rearrange the heap again after deleting the top
     *
     * @param k to sinkDown
     */
    public void sinkDown(int k) {
        int smallest = k;
        int leftChildIndex = 2 * k;
        int rightChildIndex = 2 * k + 1;
        if (leftChildIndex < heapSize() && MinHeapArr[smallest].weight > MinHeapArr[leftChildIndex].weight) {
            smallest = leftChildIndex;
        }
        if (rightChildIndex < heapSize() && MinHeapArr[smallest].weight > MinHeapArr[rightChildIndex].weight) {
            smallest = rightChildIndex;
        }
        if (smallest != k) {

            Edge smallestNode = MinHeapArr[smallest];
            Edge kNode = MinHeapArr[k];

            // swap the positions
            indexes[smallestNode.source.ID] = k;
            indexes[kNode.source.ID] = smallest;
            swap(k, smallest);
            sinkDown(smallest);
        }
    }

    /**
     * method to swap the position of two nodes
     *
     * @param a index of first node
     * @param b index of second node
     */
    public void swap(int a, int b) {
        Edge temp = MinHeapArr[a];
        MinHeapArr[a] = MinHeapArr[b];
        MinHeapArr[b] = temp;
    }

    /**
     *
     * @return true if minHeap is empty
     */
    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * @return the currentSize of minHeap
     */
    public int heapSize() {
        return currentSize;
    }

    /**
     *
     * @return cost of MST
     */
    public int getMSTCost() {
        return cost;
    }

    @Override
    public void displayResultingMST() {

        // Display the resulting MST
        System.out.println("Minimum Spanning Tree:");
        for (Edge edge : MSTResultList) {
            System.out.println(
                    edge.getSource().getLabel() + " - " + edge.target.getLabel() + " : " + edge.getWeight());
        }
        System.out.println("Cost              " + getMSTCost());
    }
}