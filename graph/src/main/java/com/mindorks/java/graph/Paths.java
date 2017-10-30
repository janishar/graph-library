package com.mindorks.java.graph;

import java.util.Stack;

public abstract class Paths {

    protected final SimpleGraph G;
    protected final int s; //source vertex
    protected boolean[] marked;
    protected int[] edgeTo;

    public Paths(SimpleGraph G, int s) {
        this.G = G;
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
    }

    /**
     * Finds if there is a path from s to v
     */
    public boolean hasPathTo(int v) {
        return marked[v]; //if marked then it lies in the traversal
    }

    /**
     * path from s to v : null if no such path
     */
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }

    public void printConnectedVertices() {
        for (int v = 0; v < G.V(); v++)
            if (hasPathTo(v))
                System.out.println(v);
    }
}
