package com.mindorks.java.graph;

import java.util.LinkedList;

public class UGraph implements Graph {

    // number of vertices
    private int V;

    /**
     * adjacency list implementation of data representation.
     * The adjacency matrix hold the vertices by index
     * and it connected vertex list
     */
    private LinkedList<Integer>[] adj;


    @SuppressWarnings("unchecked")
    public UGraph(int V) {
        this.V = V;
        adj = (LinkedList<Integer>[]) new LinkedList[V]; // array of Generic List has to be cast;
        for (int v = 0; v < V; v++)
            adj[v] = new LinkedList<>();
    }

    @Override
    public void addEdge(int v, int w) throws IndexOutOfBoundsException {
        if (v < 0 || v >= V || w < 0 || w >= V)
            throw new IndexOutOfBoundsException(
                    "The vertices should between " + 0 + " and " + (V - 1));
        adj[v].add(w);
        adj[w].add(v);
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return 0;
    }
}
