# ☎️ Phone Network Design using MST Algorithms (Kruskal & Min-Heap Prim)

## 📌 Project Overview  
This project implements **Kruskal’s Algorithm** and **Min-Heap based Prim’s Algorithm** to solve the *Minimum Spanning Tree* (MST) problem for a **Phone Network Design** system. The objective is to connect all office branches using leased phone lines with the **minimum total cost**, forming a **spanning tree**.


## 🧩 Features
- 📄 **readGraphFromFile(filename)**  
  Reads graph data from a file (format provided in Appendix II) and initializes the graph.

- 🔧 **makeGraph(n, m)**  
  Randomly generates a connected undirected graph with `n` vertices and `m` edges with random weights.

- 🌲 **MST Algorithms Implemented**:
  - **Kruskal’s Algorithm**
  - **Min-Heap based Prim’s Algorithm**

- 📊 **Performance Evaluation**  
  Compares the running times of both MST algorithms on graphs of varying sizes:
  - `n = 1000` with `m = 10000, 15000, 25000`
  - `n = 5000` with `m = 15000, 25000`
  - `n = 10000` with `m = 15000, 25000`


## 📁 Files Included
- `PhoneNetwork_MST_Assignment.pdf` – The original assignment brief including all requirements, UML class diagrams, and design instructions.
- `Empirical_Analysis__Report.pdf` – Detailed report analyzing the empirical performance of the algorithm vs theoretical expectations.
- `PhNWDesignApp.java` – Main application class.
- `Graph.java` – Base graph structure.
- `Office.java` – Subclass of Vertex.
- `Line.java` – Subclass of Edge.
- `KruskalAlg.java` – Implementation of Kruskal’s algorithm.
- `MHPrimAlg.java` – Implementation of Min-Heap Prim’s algorithm.
- `MSTAlgorithm.java` – Abstract base class for MST algorithms.
- `graph_input.txt` – Sample graph file (formatted as per Appendix II).
- `plot_results.png` – Runtime comparison graph.


## 🖥️ Tools & Technologies
- Java  
- Git & GitHub  
- Visual Studio Code  
- JDK 8+  
- Python (for plotting runtimes using matplotlib)

### 💡 Observations:
- **Kruskal's algorithm** performs better on sparse graphs.
- **Prim's algorithm with min-heap** scales better with denser graphs due to efficient edge selection.


## 📚 References  
- Levitin, A. *Introduction to The Design and Analysis of Algorithms*, 3rd Ed.  
- [GeeksforGeeks - MST Applications](https://www.geeksforgeeks.org/applications-of-minimum-spanning-tree-problem/)  
- [Gate Vidyalay - Kruskal Example](https://www.gatevidyalay.com/kruskal-algorithm-example/)


