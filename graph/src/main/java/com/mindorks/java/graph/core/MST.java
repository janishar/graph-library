package com.mindorks.java.graph.core;

/**
 * Minimum Spanning Tree:
 * Three having all the vertices of an edge weighted graph
 * such that the edges give the minimum weight of the tree
 */
public interface MST {

    Iterable<Edge> edges();

    double weight();
}
