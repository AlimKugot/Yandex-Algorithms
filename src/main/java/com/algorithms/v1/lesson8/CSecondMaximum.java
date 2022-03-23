package com.algorithms.v1.lesson8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSecondMaximum {

    private static final String INPUT_PATH = "src/main/resources/cases/v1/lesson8/A/input4.txt";

    static class TreeNode {
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

        /*
        ...................5....
        ...............*.......11..
        .............*...*....7....
        ...........*......*.6..8...
        ........................9..
        ans = 9

        case 2.
        ...................5....
        ...............4.......11..
        .............*...*........
        ...........*......*.......
        ans = 5

        4 1 2 3 0
        .............4......
        ...........1........
        .............2......
        ...............3

        ..............5
        ............*...10
        ...............8
        */
        private int findSecondMax(TreeNode node) {
            // get parent if left && right == null
            TreeNode maxNode = findMax(node);
            if (maxNode.left == null) {
                return maxNode.parent.key;
            }
            return findMax(maxNode.left).key;
        }


        private TreeNode findMax(TreeNode node) {
            if (node.right == null) {
                return node;
            } else {
                return findMax(node.right);
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
            root = root.createTree(arr);
            System.out.println(root.findSecondMax(root));
        } catch (IOException ignored) {
        }
    }

}
