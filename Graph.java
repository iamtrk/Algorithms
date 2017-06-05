package com.fit.gg;

import java.util.*;

/**
 * Created by iamtrk on 15/11/16.
 */
public class Graph {

    private Map<String, List<String>> graph;
    private Map<String, Boolean> visited;

    public Graph() {
        graph = new HashMap<>();
        visited = new HashMap<>();
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");
        graph.addEdge("D", "A");

        String source = "A";
        String dest   = "D";
        graph.BFS(source, dest, source);
        graph.DFS(source, dest, source);

    }

    public List<String> adj(String vert) {
        return graph.get(vert);
    }

    public void addEdge(String A, String B) {

        if(A.equals(B)) {
            System.out.println("Hey, No self loops");
            return;
        }

        List<String> a = graph.get(A);
        if(a!=null) {
            a.add(B);
        } else {
            a = new ArrayList<>();
            a.add(B);
        }
        graph.put(A, a);

        List<String> b = graph.get(B);
        if(b!=null) {
            b.add(A);
        } else {
            b = new LinkedList<>();
            b.add(B);
        }

        graph.put(B, b);
    }
    // DFS With path tracking capabilities
    public void DFS( String source, String dest, String path) {

        if(source.equals(dest)) {
            System.out.println(path);
            return;
        }

        visited.put(source, true);

        for (String a : graph.get(source)) {
            if(visited.get(a)==null || !visited.get(a)) {
                visited.put(a, true);
                DFS(a, dest, path+" => "+a);
            }
         }
    }
    // BFS With path tracking capabilities
    public void BFS(String source, String dest, String path) {
        Queue<KV> queue = new LinkedList<>();
        queue.add(new KV(source, path));
        visited.put(source, true);
        while (!queue.isEmpty()) {
            KV vert = queue.poll();
            if(dest.equals(vert.key)) {
                System.out.println(vert.value);
                return;
            }

            for (String a : graph.get(vert.key)) {
                if(visited.get(a)==null || !visited.get(a)) {
                    visited.put(a, true);
                    queue.add(new KV(a, vert.value+" => "+a));
                }
            }
        }
    }
    // Class used to keep track of path in BFS
    class KV {
        String key;
        String value;

        public KV(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}

