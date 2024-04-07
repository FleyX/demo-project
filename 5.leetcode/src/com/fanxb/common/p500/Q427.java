package com.fanxb.common.p500;

public class Q427 {
    private static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public Node construct(int[][] grid) {
        return dfs(grid, 0, 0, grid[0].length);
    }

    private Node dfs(int[][] grid, int x, int y, int size) {
        if (size == 1) return new Node(grid[x][y] == 1, true);
        Boolean val = getVal(grid, x, y, size);
        if (val == null) {
            size = size / 2;
            return new Node(false, false, dfs(grid, x, y, size), dfs(grid, x, y + size, size), dfs(grid, x + size, y, size), dfs(grid, x + size, y + size, size));
        } else {
            return new Node(val, true);
        }
    }

    private Boolean getVal(int[][] grid, int x, int y, int size) {
        int val = grid[x][y];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (val != grid[x + i][y + j]) return null;
            }
        }
        return val == 1;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 1, 0, 0, 0, 0, 0, 0}, {1, 1, 0, 0, 0, 0, 0, 0}, {1, 1, 0, 0, 0, 0, 1, 1}, {1, 1, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 0, 0}};
        Node node = new Q427().construct(grid);
        System.out.println(node.val);
    }
}
