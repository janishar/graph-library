package com.mindorks.java.graph;

import java.util.Stack;

public class DepthFirstPaths extends Paths {

    private boolean[] marked;
    private int[] edgeTo;

    public DepthFirstPaths(Graph G, int s) {
        super(G, s);
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v))
            if (!marked[w]) {
                dfs(G, w);
                edgeTo[w] = v;
            }
    }

    @Override
    public boolean hasPathTo(int v) {
        return marked[v]; //if marked then it lies in the traversal
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != getS(); x = edgeTo[x])
            path.push(x);
        path.push(getS());
        return path;
    }
}
