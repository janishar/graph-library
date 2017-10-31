package com.mindorks.java.graph.core;

public interface SimpleGraph {

    /**
     * prints all the edges of the graph
     */
    static void print(SimpleGraph G) {
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                System.out.println(v + "-" + w);
            }
        }
    }

    /**
     * @return number of edges connected to the vertex v
     */
    static int degree(SimpleGraph G, int v) {
        int degree = 0;
        for (int w : G.adj(v)) degree++;
        return degree;
    }

    static int maxDegree(SimpleGraph G) {
        int max = 0;
        for (int v = 0; v < G.V(); ) {
            int degree = degree(G, v);
            if (max < degree) max = degree;
        }
        return max;
    }

    static double averageDegree(SimpleGraph G) {
        return 2.0 * G.E() / G.V(); // each edge is counted twice v-w and w-v
    }

    static int numberOfSelfLoops(SimpleGraph G) {
        int count = 0;
        for (int v = 0; v < G.V(); v++)
            for (int w : G.adj(v))
                if (v == w) count++;
        return count / 2; //each edge is counted twice
    }

    /**
     * Add an edge v-w
     */
    void addEdge(int v, int w) throws IndexOutOfBoundsException;

    /**
     * @return vertices adjacent to v
     */
    Iterable<Integer> adj(int v);

    /**
     * @return Number of vertices
     */
    int V();

    /**
     * @return number of edges
     */
    int E();

}