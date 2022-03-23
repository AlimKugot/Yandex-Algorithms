package com.algorithms.v1.lesson8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BInsertionDepth {

    private static final String INPUT_PATH = "src/main/resources/cases/v1/lesson8/B/input2.txt";

    static class TreeNode {
        private int index;
        private int key;
        private int depth;
        private TreeNode left;
        private TreeNode right;
        private TreeNode parent;

        public TreeNode() {
        }

        public TreeNode(int index, int key) {
            this.index = index;
            this.key = key;
            this.depth = 1;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        public TreeNode(int index, int key, int depth, TreeNode left, TreeNode right, TreeNode parent) {
            this.index = index;
            this.key = key;
            this.depth = depth;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public void createTree(int[] arr) {
            TreeNode root = new TreeNode(0, arr[0]);
            System.out.print(root.depth + " ");
            for (int i = 1; i < arr.length; i++) {
                add(root, i, arr[i]);
            }
        }

        private void add(TreeNode node, int index, int val) {
            // 10 val = 5
            if (val < node.key) {
                if (node.left == null) {
                    node.left = new TreeNode(index, val, node.depth + 1, null, null, node);
                    System.out.print(node.left.depth + " ");
                } else {
                    add(node.left, index, val);
                }
            } else if (val > node.key) {
                if (node.right == null) {
                    node.right = new TreeNode(index, val, node.depth + 1, null, null, node);
                    System.out.print(node.right.depth + " ");
                } else {
                    add(node.right, index, val);
                }
            }
        }
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH))) {
            String[] line = reader.readLine().split(" ");
            int[] arr = new int[line.length - 1];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(line[i]);
            }
            TreeNode root = new TreeNode();
            root.createTree(arr);
        } catch (IOException ignored) {
        }
    }
}
