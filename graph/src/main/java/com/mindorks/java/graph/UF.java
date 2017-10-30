package com.mindorks.java.graph;

public interface UF {

    /**
     * Add component between p and q
     */
    void union(int p, int q);

    /**
     * check if p and q are in the same component
     */
    boolean connected(int p, int q);

    /**
     * component identifier for p
     */
    int find(int p);

    /**
     * number of components
     */
    int count();

}
