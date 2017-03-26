package com.fit.gg;

import java.util.*;

/**
 * Created by m01231 on 15/11/16.
 */
public class Graph {

    private Map<String, List<String>> graph;
    private Map<String, Boolean> visited;
    private String path = "";

    public testingal() {
        graph = new HashMap<>();
        visited = new HashMap<>();
    }

    public static void main(String[] args) {
        testingal r = new testingal();
        r.addEdge("A", "B");
        r.addEdge("B", "C");
        r.addEdge("C", "D");
        r.addEdge("D", "A");

        String source = "A";
        String dest   = "D";
        r.DFS(source, dest, source);

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
}

