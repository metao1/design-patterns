package com.metao.dp.dfs;

import java.util.Stack;

public class DFS {

    static class Cell {
        private final String value;

        Cell(String value) {
            this.value = value;
        }
    }

    static class Tree {
        public final Cell vertex;
        public final Tree left;
        public final Tree right;
        public boolean visited;

        private Tree(Builder builder) {
            this.left = builder.getLeft();
            this.right = builder.getRight();
            this.vertex = builder.getValue();
        }

        public static class Builder {
            private Tree left, right;
            private final Cell value;

            public Builder(Cell vertex) {
                value = vertex;
            }

            public static Builder builder(Cell vertex) {
                return new Builder(vertex);
            }

            public Builder setLeft(Tree left) {
                this.left = left;
                return this;
            }

            public Builder setRight(Tree right) {
                this.right = right;
                return this;
            }

            public Tree getLeft() {
                return left;
            }

            public Tree getRight() {
                return right;
            }

            public Cell getValue() {
                return value;
            }

            Tree build() {
                return new Tree(this);
            }
        }

        public Cell getVertex() {
            return vertex;
        }

        public Tree getRight() {
            return right;
        }

        public Tree getLeft() {
            return left;
        }
    }

    public DFS() {
        Tree tree = Tree.Builder.builder(new Cell("2"))
                .setLeft(Tree.Builder.builder(new Cell("3"))
                        .setLeft(Tree.Builder.builder(new Cell("4")).build())
                        .setRight(Tree.Builder.builder(new Cell("1")).build())
                        .build()
                )
                .setRight(Tree.Builder.builder(new Cell("10")).build())
                .build();

        Tree tree2 = Tree.Builder.builder(new Cell("1"))
                .setLeft(Tree.Builder.builder(new Cell("2"))
                        .setLeft(Tree.Builder.builder(new Cell("3"))
                                .setLeft(Tree.Builder.builder(new Cell("4")).build())
                                .setRight(Tree.Builder.builder(new Cell("5")).build())
                                .build())
                        .build()).build();
 
        Stack<Tree> vertices = new Stack<>();
        vertices.push(tree);
        vertices.push(tree2);
        while (!vertices.isEmpty()) {
            Tree topNode = vertices.pop();
            if (!topNode.visited) {
                System.out.println(topNode.vertex.value);
            }
            topNode.visited = true;
            Tree leftChild = topNode.left;
            Tree rightChild = topNode.right;
            if (rightChild != null && !rightChild.visited) {
                vertices.push(rightChild);
            }
            if (leftChild != null && !leftChild.visited) {
                vertices.push(leftChild);
            }
        }
    }

    public static void main(String[] args) {
        new DFS();
    }
}
