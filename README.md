# Topological Ordering
Finds a Topological Ordering of vertices in a Directed Acyclic Graph

## Problem Statement
**Topological Ordering:** arranges nodes as v<sub>1</sub>, v<sub>2</sub> ..., v<sub>n</sub> so that for every edge (v<sub>i</sub>, v<sub>j</sub>), i < j
- Must be a Directed Graph
- Must NOT contain a cycle

### Graph 1
<img src="images/graph1.png" width="400">

### Graph 1 Topological Ordering
<img src="images/graph1-topological-ordering.png" width="550">

**Can can be more than 1 topologcal ordering. Algorithm finds 1 if 1 exists**


## Algorithm
A DAG must have a node with **no incoming edges**  
Pick a node `v` with no incoming edges  
Print `v`  
Calculate a topological ordering on G – {`v`}  
Ends when all nodes are included in the ordering

Keep track of 2 things:
- `count[w]` = number of incoming edges
- `S` = set of nodes with no incoming edges

Set-Up
- Scan through the graph to initialize `count[]` and `S`
- **O(m + n)**

Finding the Ordering
- Remove v from S
- Decrement `count[w]` for all edges from `v` to` w`  
add `w` to `S` if `count[w]` hits `0`
- **O(1) per edge**


## Runtime
**O(m + n)**

## Usage
**Detects cycles if graph is not a DAG and prints an error message**  
**Node names are integers for simplicity of the code & start at `0`**

- Create a graph as an adjacency list  
`ArrayList<ArrayList<Integer>> graph1 = new ArrayList<ArrayList<Integer>>();`
  - Add rows for each vertex. `graph1.get(u)` is a list of nodes representing edges FROM `u`
  - Orphan nodes are allowed (i.e. a node with no incoming or outgoing edges). It doesn't have to be the last node in the graph, but is probably easier if it is. Just make sure no edges go to that node. (e.g. if node `5` is an orphan, then `5` must not appear in any of the rows of the adjacency list)
  - Nodes with no outgoing edges just need an empty `ArrayList`  
  `graph1.add(new ArrayList<Integer>());`
- Run `TopologicalOrdering.findTopologicalOrdering(graph1);`

### Graph 2
<img src="images/graph2.png" width="400">

### Graph 2 Topological Ordering
<img src="images/graph2-topological-ordering.png" width="550">

### Graph 3 (No topological ordering)
<img src="images/graph3.png" width="200">
Contains a cycle, & no nodes with no incoming edges

### Graph 4 (No topological ordering)
<img src="images/graph4.png" width="350">
Contains a cycle


## References
- [Kevin Wayne Slides](https://www.cs.princeton.edu/~wayne/kleinberg-tardos/pdf/03Graphs.pdf#page=45)
- [University of Washington slides](https://homes.cs.washington.edu/~jrl/421slides/lec5.pdf)
- [Rajesh Rao Slides](https://courses.cs.washington.edu/courses/cse326/03wi/lectures/RaoLect20.pdf)
