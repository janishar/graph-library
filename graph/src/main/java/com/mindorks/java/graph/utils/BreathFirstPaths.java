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
