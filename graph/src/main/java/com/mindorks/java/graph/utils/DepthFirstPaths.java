package com.mindorks.java.graph.utils;

import com.mindorks.java.graph.core.SimpleGraph;

public class DepthFirstPaths extends Paths {

    public DepthFirstPaths(SimpleGraph G, int s) {
        super(G, s);
        dfs(G, s);
    }

    private void dfs(SimpleGraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v))
            if (!marked[w]) {
                dfs(G, w);
                edgeTo[w] = v;
            }
    }
}
