package com.algorithms.v1.lesson8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ATreeHeight {

    private static final String INPUT_PATH = "src/main/resources/cases/v1/lesson8/A/input1.txt";

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

        /**
         * Find by value
         *
         * @return index
         */
        private int find(TreeNode node, int val) {
            if (val < node.key) {
                if (node.left == null) {
                    return -1;
                } else {
                    return find(node.left, val);
                }
            } else if (val > node.key) {
                if (node.right == null) {
                    return -1;
                } else {
                    return find(node.right, val);
                }
            } else {
                return node.index;
            }
        }

        private int findHeight(TreeNode node, int maxHeight, int height) {
            if (node != null) {
                maxHeight = Math.max(maxHeight, findHeight(node.left, maxHeight, height + 1));
                maxHeight = Math.max(maxHeight, findHeight(node.right, maxHeight, height + 1));
            }
            if (height - 1 > maxHeight) maxHeight = height - 1;
            return maxHeight;
        }

        private int findHeightByValue(TreeNode node, int height, int val) {
            if (val < node.key) {
                if (node.left == null) {
                    return -1;
                } else {
                    return findHeight(node.left, height + 1, val);
                }
            } else if (val > node.key) {
                if (node.right == null) {
                    return -1;
                } else {
                    return findHeight(node.right, height + 1, val);
                }
            } else {
                return height;
            }
        }
    }
    /*
    7 3 2 1 9 5 4 6 8 0

    1.....................7...............
    2.............3.............9.............
    3..........2......5......8.............
    4.......1.......4...6................
    max = 4

    .....1
    .......2
    ..........3
    .............4
    ...............5
    .................6
    ...................7
    .....................8

    10 6 3 7 15 11 17
    1..................10................
    2.............6..........15.............
    3..........3.....7....11.....17..........
    max = 3
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
            int height = root.findHeight(root, -1, 1);
            System.out.println(height);
        } catch (IOException ignored) {
        }
    }
}
