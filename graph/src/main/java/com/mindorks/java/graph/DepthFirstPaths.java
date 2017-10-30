package com.mindorks.java.graph;

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
