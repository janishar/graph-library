/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.mindorks.java.graph.core;

import java.util.LinkedList;

public class UndirectedGraph implements Graph {

    // number of vertices
    private final int V;

    /**
     * adjacency list implementation of data representation.
     * The adjacency matrix hold the vertices by index
     * and it connected vertex list
     */
    private LinkedList<Integer>[] adj;


    @SuppressWarnings("unchecked")
    public UndirectedGraph(int V) {
        this.V = V;
        adj = (LinkedList<Integer>[]) new LinkedList[V]; // array of Generic List has to be cast;
        for (int v = 0; v < V; v++)
            adj[v] = new LinkedList<>();
    }

    @Override
    public void addEdge(int v, int w) {
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

    protected LinkedList<Integer>[] getAdjArray() {
        return adj;
    }
}
