  Bonus Task: Dijkstra’s Algorithm
This project implements Dijkstra’s Algorithm for finding the shortest path from one starting vertex to all other vertices in a weighted graph.

  What was added
The graph was updated to support weighted edges.

Main changes:
 {Edge} class has a {weight} field
 Graph stores edges with weights
 Method {dijkstra(int start)} was implemented
 The program prints the shortest distance from the starting vertex to every other vertex

   Algorithm
Dijkstra’s Algorithm finds the shortest distance from one vertex to all other vertices.
In this project, the algorithm uses:

1. an array for distances
2. an array for visited vertices
3. simple loops

Priority Queue is not used.

   Classes

   Edge

Stores information about one edge:

```java
int to;
int weight;
