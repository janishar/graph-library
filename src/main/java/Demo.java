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

import com.mindorks.java.graph.core.*;
import com.mindorks.java.graph.utils.*;

/**
 * Created by janisharali on 26/10/17.
 */
public class Demo {

    public static void main(String[] args) {
        testGraph();
    }

    public static void testGraph() {
        testBFS(getTestGraph());
    }

    private static void testKruskalMST() {
        EGraph graph = new EdgeWeightedGraph(6);
        graph.addEdge(new Edge(0, 1, 0.21));
        graph.addEdge(new Edge(1, 2, 0.11));
        graph.addEdge(new Edge(2, 4, 0.93));
        graph.addEdge(new Edge(1, 3, 0.76));
        graph.addEdge(new Edge(3, 4, 0.40));
        graph.addEdge(new Edge(1, 5, 0.50));
        graph.addEdge(new Edge(0, 5, 0.97));
        graph.addEdge(new Edge(5, 4, 0.38));

        MST mst = new KruskalMST(graph);
        print(mst.edges());
        print(mst.weight());
    }

    private static void testUF() {
        UF uf = new QuickUnionUF(10);
        uf.union(4, 3);
        uf.union(3, 8);
        uf.union(6, 5);
        uf.union(9, 4);
        uf.union(2, 1);
        uf.union(5, 0);
        uf.union(7, 2);
        uf.union(6, 1);
        uf.union(7, 3);
        print(uf);
    }

    private static Graph getTestGraph() {
        Graph graph = new UndirectedGraph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 6);
        graph.addEdge(6, 4);
        graph.addEdge(4, 3);
        graph.addEdge(4, 5);
        graph.addEdge(5, 3);
        graph.addEdge(0, 5);
        return graph;
    }

    private static void testDFS(Graph graph) {
        Paths paths = new DepthFirstPaths(graph, 0);
        print(paths.pathTo(5));
    }

    private static void testBFS(Graph graph) {
        BreathFirstPaths paths = new BreathFirstPaths(graph, 0);
        print(paths.pathTo(4));// will give the shortest path
    }

    private static void testBag() {
        Bag<String> bag = new Bag<>();
        bag.put("Janishar");
        bag.put("Ali");
        bag.put("Anwar");
        bag.put("Anwar");
        bag.put("is");
        bag.put("awesome");

        System.out.println(bag.get() + bag.get());

        for (String item : bag) {
            System.out.println(item);
        }
    }

    private static <T> void print(T t) {
        System.out.println(t);
    }
}
