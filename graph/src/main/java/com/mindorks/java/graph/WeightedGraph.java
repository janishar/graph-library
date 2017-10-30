package com.mindorks.java.graph;

public interface WeightedGraph {

    void addEdge(Edge e);

    Iterable<Edge> adj(int v);

    Iterable<Edge> edges();

    int V();

    int E();
}
