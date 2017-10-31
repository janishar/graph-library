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

import java.util.Iterator;

/**
 * Created by janisharali on 26/10/17.
 */
public class Bag<T> implements Iterable<T> {

    private Node start;

    public void put(T t) {
        Node node = new Node(t);
        if (start != null) {
            Node oldStart = start;
            start = node;
            start.next = oldStart;
        } else {
            start = node;
        }
    }

    public T get() {
        if (start == null)
            return null;
        Node current = start;
        start = current.next;
        return current.value;
    }

    public T remove(T t) {
        Node current = start;
        Node previous = null;

        while (current != null) {
            if (current.value.equals(t)) {
                if (previous == null) {
                    start = null;
                } else {
                    previous.next = current.next;
                    current = current.next;
                }
            } else {
                previous = current;
                current = current.next;
            }
        }

        T value = null;
        if (previous != null) {
            value = previous.value;
        }

        return value;
    }

    @Override
    public Iterator<T> iterator() {
        return new BagIterator();
    }

    private class Node {
        T value;
        Node next;

        Node(T value) {
            this.value = value;
        }
    }

    private class BagIterator implements Iterator<T> {

        Node current;

        BagIterator() {
            current = start;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T value = current.value;
            current = current.next;
            return value;
        }
    }
}
