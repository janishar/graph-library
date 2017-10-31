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

public interface UF {

    /**
     * Add component between p and q
     */
    void union(int p, int q);

    /**
     * check if p and q are in the same component
     */
    boolean connected(int p, int q);

    /**
     * component identifier for p
     */
    int find(int p);

    /**
     * number of components
     */
    int count();

}
