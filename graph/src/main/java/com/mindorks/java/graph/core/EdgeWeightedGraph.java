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
