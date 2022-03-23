package com.algorithms.v1.lesson8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FPrintForks {

    private static final String INPUT_PATH = "src/main/resources/cases/v1/lesson8/A/input3.txt";

        /*
            1.....................7...............
            2.............3..............9.............
            3..........2.......5......8.............
            4.......1........4...6................
         */

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH))) {
            String[] line = reader.readLine().split(" ");
            int[] arr = new int[line.length - 1];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(line[i]);
            }
            TreeNode root = new TreeNode();
            root = root.createTree(arr);
            root.printLeaves(root);
        } catch (IOException ignored) {

        }
    }


    private static class TreeNode {
        private int index;
        private int key;
        private TreeNode left;
        private TreeNode right;
        private TreeNode parent;

        public TreeNode() {
        }

        public TreeNode(int index, int key) {
            this.index = index;
            this.key = key;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        public TreeNode(int index, int key, TreeNode left, TreeNode right, TreeNode parent) {
            this.index = index;
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public TreeNode createTree(int[] arr) {
            TreeNode root = new TreeNode(0, arr[0]);
            for (int i = 1; i < arr.length; i++) {
                add(root, i, arr[i]);
            }
            return root;
        }

        private void add(TreeNode node, int index, int val) {
            // 10 val = 5
            if (val < node.key) {
                if (node.left == null) {
                    node.left = new TreeNode(index, val, null, null, node);
                } else {
                    add(node.left, index, val);
                }
            } else if (val > node.key) {
                if (node.right == null) {
                    node.right = new TreeNode(index, val, null, null, node);
                } else {
                    add(node.right, index, val);
                }
            }
        }

        private void printLeaves(TreeNode node) {
            if (node.left != null) printLeaves(node.left);
            if ((node.left != null && node.right == null)
                    || (node.left == null && node.right != null)) {
                System.out.println(node.key);
            }
            if (node.right != null) printLeaves(node.right);
        }
    }

}

