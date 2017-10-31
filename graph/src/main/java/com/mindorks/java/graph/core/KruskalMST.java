package com.mindorks.java.graph.core;

import com.mindorks.java.graph.utils.QuickUnionUF;
import com.mindorks.java.graph.utils.UF;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class KruskalMST implements MST {

    private Queue<Edge> mst = new LinkedBlockingQueue<>();

    public KruskalMST(WeightedGraph G) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();// minimum priority queue
        for (Edge e : G.edges())
            pq.add(e);

        UF uf = new QuickUnionUF(G.V());
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.poll();
            int v = e.either();
            int w = e.other(v);
            if (!uf.connected(v, w)) { //to check cyclic components or duplicate edges
                uf.union(v, w);
                mst.add(e);
            }
        }
    }

    @Override
    public Iterable<Edge> edges() {
        return mst;
    }

    @Override
    public double weight() {
        double weight = 0;
        for (Edge e : mst)
            weight += e.weight();
        return weight;
    }

    @Override
    public String toString() {
        return "KruskalMST{" +
                "mst=" + mst +
                '}';
    }
}
