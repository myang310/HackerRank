/*
For the purposes of this challenge, we define a binary search tree
to be a binary tree with the following ordering properties:

1. The data value of every node in a node's left subtree is less
than the data value of that node.
2. The data value of every node in a node's right subtree is
greater than the data value of that node.

Given the root node of a binary tree, can you determine if it's
also a binary search tree?

Complete the function in your editor below, which has 1 parameter:
a pointer to the root of a binary tree. It must return a boolean
denoting whether or not the binary tree is a binary search tree.
You may have to write one or more helper functions to complete
this challenge.

Link: https://www.hackerrank.com/challenges/ctci-is-binary-search-tree
*/

/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
    boolean checkBST(Node root) {
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean check(Node node, Integer min, Integer max) {
        if (node == null)
            return true;
        if (node.data < max && node.data > min)
            return check(node.left, min, node.data) &&
                   check(node.right, node.data, max);

        return false;
    }
