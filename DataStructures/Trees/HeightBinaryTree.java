/*
The height of a binary tree is the number of edges between
the tree's root and its furthest leaf. This means that a
tree containing a single node has a height of 0.

Complete the getHeight function provided in your editor so
that it returns the height of a binary tree. This function
has a parameter, root, which is a pointer to the root node
of a binary tree.

Link: https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree
*/

/*
class Node
    int data;
    Node left;
    Node right;
*/
static int getHeight(Node root) {
    if (root == null) return -1;
    return Math.max(1+getHeight(root.left), 1+getHeight(root.right));
}
