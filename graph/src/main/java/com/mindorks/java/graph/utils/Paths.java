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

package com.mindorks.java.graph.utils;

import com.mindorks.java.graph.core.SimpleGraph;

import java.util.Stack;

public abstract class Paths {

    protected final SimpleGraph G;
    protected final int s; //source vertex
    protected boolean[] marked;
    protected int[] edgeTo;

    public Paths(SimpleGraph G, int s) {
        this.G = G;
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
    }

    /**
     * Finds if there is a path from s to v
     */
    public boolean hasPathTo(int v) {
        return marked[v]; //if marked then it lies in the traversal
    }

    /**
     * path from s to v : null if no such path
     */
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }

    public void printConnectedVertices() {
        for (int v = 0; v < G.V(); v++)
            if (hasPathTo(v))
                System.out.println(v);
    }
}
