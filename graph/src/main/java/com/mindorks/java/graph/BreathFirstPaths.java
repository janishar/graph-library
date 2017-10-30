package com.mindorks.java.graph;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class BreathFirstPaths extends Paths {

    public BreathFirstPaths(SimpleGraph G, int s) {
        super(G, s);
        bfs(G, s);
    }

    private void bfs(SimpleGraph G, int s) {
        Queue<Integer> q = new LinkedBlockingDeque<>();
        q.add(s);
        marked[s] = true;
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int w : G.adj(v))
                if (!marked[w]) {
                    q.add(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                }
        }
    }
}
