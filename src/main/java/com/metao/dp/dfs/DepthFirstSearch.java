package com.metao.dp.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {

    public static void main(String[] args) {
        Vertex v1 = Vertex.build("1");
        Vertex v2 = Vertex.build("2");
        Vertex v3 = Vertex.build("3");
        Vertex v4 = Vertex.build("4");
        Vertex v5 = Vertex.build("5");
        v1.setConnection(v2.setConnection(v3, v4), v5);
        dfs(v1);
    }

    static void dfs(Vertex root) {
        List<Vertex> visited = new ArrayList<>();
        Stack<Vertex> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Vertex top = stack.pop();
            if (!visited.contains(top)) {
                visited.add(top);
            }
            if (top.vertices != null) {
                for (Vertex vertex : top.vertices) {
                    stack.push(vertex);
                }
            }
        }
        visited.forEach(vertex -> System.out.println(vertex.cell));
    }

    private static class Graph {
        private final Vertex root;

        Graph(Vertex root) {
            this.root = root;
        }
    }

    private static class Vertex {
        private final String cell;
        private Vertex[] vertices;

        private Vertex(String cell) {
            this.cell = cell;
        }

        static Vertex build(String cell) {
            return new Vertex(cell);
        }

        public Vertex setConnection(Vertex... vertices) {
            this.vertices = vertices;
            return this;
        }
    }
}