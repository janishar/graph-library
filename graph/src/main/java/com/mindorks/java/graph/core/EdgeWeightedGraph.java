package com.mindorks.java.graph.core;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class EdgeWeightedGraph implements WeightedGraph {

    private final int V;
    private final LinkedList<Edge>[] adj;

    @SuppressWarnings("unchecked")
    public EdgeWeightedGraph(int V) {
        this.V = V;
        adj = (LinkedList<Edge>[]) new LinkedList[V];
        for (int v = 0; v < V; v++)
            adj[v] = new LinkedList<>();
    }

    @Override
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
    }

    @Override
    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    @Override
    public Iterable<Edge> edges() {
        Stack<Edge> stack = new Stack<>();
        for (int v = 0; v < V; v++)
            for (Edge e : adj[v])
                stack.push(e);
        return stack;
    }

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return 0;
    }

    @Override
    public String toString() {
        return "EdgeWeightedGraph{" +
                "V=" + V +
                ", adj=" + Arrays.toString(adj) +
                '}';
    }
}
