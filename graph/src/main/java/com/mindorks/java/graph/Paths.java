package com.mindorks.java.graph;

public abstract class Paths {

    private Graph G;
    private int s; //source vertex

    public Paths(Graph G, int s) {
        this.G = G;
        this.s = s;
    }

    /**
     * Finds if there is a path from s to v
     */
    public abstract boolean hasPathTo(int v);

    /**
     * path from s to v : null if no such path
     */
    public abstract Iterable<Integer> pathTo(int v);

    public void printConnectedVertices() {
        for (int v = 0; v < G.V(); v++)
            if (hasPathTo(v))
                System.out.println(v);
    }

    protected Graph getG() {
        return G;
    }

    protected int getS() {
        return s;
    }
}
